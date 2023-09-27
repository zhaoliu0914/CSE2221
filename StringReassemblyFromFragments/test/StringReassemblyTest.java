import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void testCombination_1() {
        String str1 = "ABCDEFG";
        String str1Excepted = "ABCDEFG";

        String str2 = "EFGHIJK";
        String str2Excepted = "EFGHIJK";

        String resultExcepted = "ABCDEFGHIJK";

        int overlap = 3;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals(str1, str1Excepted);
        assertEquals(str2, str2Excepted);
        assertEquals(result, resultExcepted);
    }

    @Test
    public void testCombination_2() {
        String str1 = "A B C D    EF G";
        String str1Excepted = "A B C D    EF G";

        String str2 = "  EF G HI J-K";
        String str2Excepted = "  EF G HI J-K";

        String resultExcepted = "A B C D    EF G HI J-K";

        int overlap = 6;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals(str1, str1Excepted);
        assertEquals(str2, str2Excepted);
        assertEquals(result, resultExcepted);
    }

    @Test
    public void testCombination_3() {
        String str1 = "A,B~C!D(E   ";
        String str1Excepted = "A,B~C!D(E   ";

        String str2 = "   E*F & G";
        String str2Excepted = "   E*F & G";

        String resultExcepted = "A,B~C!D(E   E*F & G";

        int overlap = 3;

        String result = StringReassembly.combination(str1, str2, overlap);

        assertEquals(str1, str1Excepted);
        assertEquals(str2, str2Excepted);
        assertEquals(result, resultExcepted);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_1() {
        Set<String> strSet = new Set1L<>();
        strSet.add("ABCD");
        strSet.add("EFG");
        strSet.add("HIJK");

        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("ABCD");
        strSetExpected.add("EFG");
        strSetExpected.add("HIJK");

        String str = "BCD";
        String strExpected = "BCD";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);

        assertEquals(strSet, strSetExpected);
        assertEquals(str, strExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_2() {
        Set<String> strSet = new Set1L<>();
        strSet.add("ABCD");
        strSet.add("EFG");
        strSet.add("HIJK");

        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("ABCD");
        strSetExpected.add("EFG");
        strSetExpected.add("HIJK");

        String str = "IJ";
        String strExpected = "IJ";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);

        assertEquals(strSet, strSetExpected);
        assertEquals(str, strExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_3() {
        Set<String> strSet = new Set1L<>();
        strSet.add("ABCD");
        strSet.add("EFG");
        strSet.add("HIJK");

        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("ABCD");
        strSetExpected.add("ABHIJKLLL");
        strSetExpected.add("EFG");

        String str = "ABHIJKLLL";
        String strExpected = "ABHIJKLLL";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);

        assertEquals(strSet, strSetExpected);
        assertEquals(str, strExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_4() {
        Set<String> strSet = new Set1L<>();
        strSet.add("ABCD");
        strSet.add("EFG");
        strSet.add("HIJK");

        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("ABCD");
        strSetExpected.add("EFG");
        strSetExpected.add("HIJK");
        strSetExpected.add("LMN");

        String str = "LMN";
        String strExpected = "LMN";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);

        assertEquals(strSet, strSetExpected);
        assertEquals(str, strExpected);
    }

    @Test
    public void testLinesFromInput_1() {
        SimpleReader inFile = new SimpleReader1L("data/cheer-8-2.txt");
        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("Bucks -- Beat");
        strSetExpected.add("Go Bucks");
        strSetExpected.add("o Bucks -- B");
        strSetExpected.add("Beat Mich");
        strSetExpected.add("Michigan~");

        Set<String> strSet = StringReassembly.linesFromInput(inFile);

        assertEquals(strSet, strSetExpected);

        inFile.close();
    }

    @Test
    public void testPrintWithLineSeparators_1() {
        SimpleWriter out = new SimpleWriter1L();
        String str = "ABCD~EFG, ASDFSD,,,   SDF~ ASDASDGFSG ~ DDDDDDD";
        String strExcepted = "ABCD~EFG, ASDFSD,,,   SDF~ ASDASDGFSG ~ DDDDDDD";
        StringReassembly.printWithLineSeparators(str, out);

        assertEquals(str, strExcepted);
    }

    @Test
    public void testPrintWithLineSeparators_2() {
        SimpleWriter out = new SimpleWriter1L();
        String str = "ABCDEFG, HIJ\t,hfghfg.";
        String strExcepted = "ABCDEFG, HIJ\t,hfghfg.";
        StringReassembly.printWithLineSeparators(str, out);

        assertEquals(str, strExcepted);
    }

}
