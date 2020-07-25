package com.nameapi.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  Aceasta clasa este acel 'thing' cerut in provocare
 *  in obiectul occuranceAndCount care este un Map ce are cheie Stringul introdus
 *  si ca valori, un Tuple cu doua valori Integer ce stocheaza de cate ori apare stringul
 *  si ce lungime are stringul.
 *  Mai exista un obiect de tipul clasei deoarece am decis ca in constructia clasei sa folosesc
 *  Singleton. (am sa explic in readme de ce)
 *  Si mai exista un Tuple ce tine doua valori, suma lungimilor stringurilor si numarul de stringuri.
 *  BTW, am hotarat ca aceasta sa nu poata fi mostenita. 
 *  Initial atributele clasei sunt initializate cu null pentru a evita cazul de Lazy loaded (adica un startup greu),
 *  iar aceste variabile sunt initializate cand se cere un obiect al clasei.
 */

final public class StringFed { 

    private static HashMap<String, Tuple<Integer, Integer>> occuranceAndCount = null;
    private static volatile StringFed instance = null; // folosit volatile pentru thread safe
    private static Tuple<Integer, Integer> sumOfLengthsAndNumOfStrings = null;

    private StringFed() {
        if (instance != null) { // partea asta am pus-o pentru ca ar trebui sa ofere protectie la initializarea prin Reflection.
            throw new RuntimeException("Use getStringFed() method to create");
        }
    }

    public static StringFed getStringFed() {
        if (instance == null) {
            synchronized(StringFed.class) { // sincronizarea crearii unei noi instante
                if (instance == null) {
                    instance = new StringFed();
                    occuranceAndCount = new HashMap<String, Tuple<Integer, Integer>>();
                    sumOfLengthsAndNumOfStrings = new Tuple<Integer,Integer>(0, 0);
                }
            }
        }
        return instance;
    }

    public void fedString(final String newString) {
        /**
         * fedString este functia ce se ocupa cu fed uirea structurii de date cu stringuri
         */
        if (newString != null) {
            Integer stringLen = newString.length();

            if (occuranceAndCount.containsKey(newString)) { // daca stringul deja exista in HashMap
                Tuple aux = new Tuple(occuranceAndCount.get(newString));
                aux.setX((Integer) aux.getX() + 1); // mareste numarul de aparitii cu 1
                occuranceAndCount.put(newString, aux); // face update la HashMap
            } else {
                Tuple aux = new Tuple(1, stringLen);
                occuranceAndCount.put(newString, aux); // daca nu exista deja, creeaza o noua pereche de key - val pentru noul string
            }

            sumOfLengthsAndNumOfStrings = new Tuple<Integer,Integer>(
                            sumOfLengthsAndNumOfStrings.getX() + stringLen, // adauga lungimea noului string
                            sumOfLengthsAndNumOfStrings.getY() + 1); // adauga +1 pentru ca avem inca un string
            
        }
    }


    // function to sort hashmap by values 
    private static HashMap<String, Tuple<Integer, Integer>> sortByValue(HashMap<String, Tuple<Integer, Integer>> hm) 
    { 
        /**
         * aceasta functie de sortare am preluat-o si am modificat partea din Collections.sort
         * mai exact, am precizat dupa ce campuri se face sortarea
         * Sortarea are loc astfel, doua stringuri se compara dupa numarul de apartii, si daca au acelasi numar
         * de apartii, se vor compara si dupa lungimea acestora. (Sortarea se face descrescator)
         */

        // Create a list from elements of HashMap 
        List<Map.Entry<String, Tuple<Integer, Integer>> > list = 
               new LinkedList<Map.Entry<String, Tuple<Integer, Integer>> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Tuple<Integer, Integer>> >() { 
            public int compare(Map.Entry<String, Tuple<Integer, Integer>> o1,  
                               Map.Entry<String, Tuple<Integer, Integer>> o2) 
            { 
                Integer o1Occ = o1.getValue().getX();
                Integer o1Len = o1.getValue().getY();

                Integer o2Occ = o2.getValue().getX();
                Integer o2Len = o2.getValue().getY();

                if (o1Occ > o2Occ) {
                    return -1;
                }
                else if(o1Occ < o2Occ) {
                    return 1;
                } else {
                    if (o1Len > o2Len) {
                        return -1;
                    }
                    else if (o1Len < o2Len) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Tuple<Integer, Integer>> temp = new LinkedHashMap<String, Tuple<Integer, Integer>>(); 
        for (Map.Entry<String, Tuple<Integer, Integer>> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

    public Tuple<HashMap<String, Tuple<Integer, Integer>>, Integer> getStrings() {
        /**
         * aceasta este functia de 'request' ce returneaza stringurile sortate descrescator (dupa cum am precizat mai sus)
         * PS: am mers pe urmatoarea presupunere, aplicatia va avea un numar mare de apeluri ale functiei fedString, si un numar
         * redus de apeluri ale functiei getStrings. Astfel pentru acest caz am decis ca sortarea sa se faca in functia getStrings.
         * Mai este loc de optimizari, dar pentru moment, nestiind usecaseul acestei clase, am decis sa nu fac optimizari premature.
         */
        Integer avg = 0;
        try {
            avg = sumOfLengthsAndNumOfStrings.getX() / sumOfLengthsAndNumOfStrings.getY();
        } catch (Exception e) {
            avg = -1;
        }
        return new Tuple(sortByValue(occuranceAndCount), avg);
    }

}