package com.nameapi.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    StringFed strFedSingleton1 = StringFed.getStringFed();

    @Test
    public void testGetStringFed()
    {
        /**
         * testez daca a fost implementat ok Singleton-ul
         */
        StringFed strFedSingleton2 = StringFed.getStringFed();
        assertEquals(strFedSingleton1, strFedSingleton2);
    }

    @Test
    public void testFedStringNULL()
    {
        /**
         * testez daca la introducerea unui string null apar probleme
         */

        boolean testFail = false;
        try {
            strFedSingleton1.fedString(null);
        } catch(Exception e) {
            testFail = true;
        }
        assertFalse("Fail to fed!", testFail);
    }

    @Test
    public void testGetStringsWithNullStrings()
    {
        /**
         * testez daca dupa ce s-a introdus un string null si cer informatiile despre stringuri
         * functia PrintHelpers.dataAndAvgPrint si functia strFedSingleton1.getStrings functioneaza ok.
         */

        String testOutput = new String();
        try {
            testOutput =  PrintHelpers.dataAndAvgPrint(strFedSingleton1.getStrings());
        } catch(Exception e) {
            testOutput = "fail";
        }
        
        String expectedOut = "Avg Len: Empty list" + System.lineSeparator();
        assertEquals(expectedOut, testOutput);
    }

    @Test
    public void testFedStringAndGetStringsWithMultipleInStrings()
    {
        /**
         * testeaza o utilizare normala (insert, obtinere date, output pentru printare), 
         * se urmareste sa se testeze daca functia de sortare 
         * sorteaza cum trebuie HashMap-ul
         */

        boolean testFailFeed = false;
        try {
            strFedSingleton1.fedString("st");
            strFedSingleton1.fedString(null);
            strFedSingleton1.fedString("alex");
            strFedSingleton1.fedString(null);
            strFedSingleton1.fedString("sby");
            strFedSingleton1.fedString("alex");
        } catch(Exception e) {
            testFailFeed = true;
        }
        assertFalse("Fail to fed multiple!", testFailFeed);

        String expectedOutput = "alex = Occ: 2 Len: 4" + System.lineSeparator() +
                                "sby = Occ: 1 Len: 3" + System.lineSeparator() +
                                "st = Occ: 1 Len: 2" + System.lineSeparator() +
                                "Avg Len: 3" + System.lineSeparator();
        String ourOutput = PrintHelpers.dataAndAvgPrint(strFedSingleton1.getStrings());
        
        assertEquals(expectedOutput, ourOutput);
    }
}
