package com.nameapi.app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** aceasta clasa este foar o clasa Helper ce ofera functii de printare pentru
 *  structurile de date din StringFed.
 *  Am decis ca aceasta clasa sa nu poata fi initializata, avand doar metode statice, si de asmenea
 *  sa nu poata fi mostenita.
 */

final public class PrintHelpers {
    private PrintHelpers() {

    }
    
    public static String customPring(final HashMap<String, Tuple<Integer, Integer>> output) {
        Iterator it = (Iterator) output.entrySet().iterator();
        String outputString = new String();
        while (it.hasNext()) {
            final Map.Entry pair = (Map.Entry) it.next();
            final Tuple<Integer, Integer> value = new Tuple((Tuple) pair.getValue());
            outputString += pair.getKey() + " = Occ: " + Integer.toString(value.getX()) + " Len: " + Integer.toString(value.getY()) + System.lineSeparator();
            it.remove(); // avoids a ConcurrentModificationException
        }  

        return outputString;
    }

    public static String dataAndAvgPrint(final Tuple<?, ?> dataRetrived) {
        String datesFormated = new String();
        String avgFormated = new String();
        try {
            final HashMap<String, Tuple<Integer, Integer>> dates = (HashMap<String, Tuple<Integer, Integer>>) dataRetrived.getX();
            datesFormated = customPring(dates);
        } catch (final Exception e) {
            datesFormated = "Bad formating ! HashMap e: " + e + System.lineSeparator();
        }

        try {
            final Integer avgData = (Integer) dataRetrived.getY();
            avgFormated = "Avg Len: " + (avgData != -1 ? Integer.toString(avgData) : "Empty list") + System.lineSeparator();
        } catch (final Exception e) {
            avgFormated = "Bad formating! Avg e: " + e + System.lineSeparator();
        }

        return datesFormated + avgFormated;
    }
}