package com.nameapi.app;

public class App 
{
    public static void main(final String[] args) {

        // niste 'teste' pentru a observa functionarea clasei
        StringFed s1 = StringFed.getStringFed();
        s1.fedString("newString11");
        s1.fedString("newString31");
        s1.fedString("newString311");
        s1.fedString("newString3");
        s1.fedString("newString2");
        s1.fedString("newString3");
        s1.fedString("newString3");
        s1.fedString("newString11");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString311");
        s1.fedString("newString3");
        s1.fedString("newString2");
        s1.fedString("newString3");
        s1.fedString("newString3");
        s1.fedString("newString2");
        s1.fedString("newString3");
        s1.fedString("newString3");
        s1.fedString("newString11");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString2");
        s1.fedString(null);
        s1.fedString("newString311");
        s1.fedString("newString3");
        s1.fedString("newString2");
        s1.fedString("newString3");
        s1.fedString("newString3");
        s1.fedString("newString11");

        System.out.println(PrintHelpers.dataAndAvgPrint(s1.getStrings()));
        
        // Observatie, pentru ca nu s-a precizat stocarea
        // intr-o baza de date, am folosit stoacarea in memorie
        // intr-o structura de date aleasa astfel incat sa reduc redundanta de date. (cel putin asta ar fi trebui sa fie)
        // Insa consider ca puteam sa fi folosit H2 pentru stocarea stringurilor.
        
        // Vreau sa imi cer scuze pentru pentru eventualele greseli, dar pot zice ca nu sunt informatii pe care nu le stiu
        // ci informatii pe care nu le stiu inca ^^.

        // Ps: aceasta clasa poate fi stearsa, a fost folosita doar pentru developmentr
        // AppTest contine o serie de teste ce consider ca acopera o parte buna din usecasuri
    }
}
