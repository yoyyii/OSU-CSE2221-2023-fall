import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    /*
     * test for testCombination
     */

    @Test
    //routine
    public void testCombination_ABC_BCD_2() {
        String str1 = "ABC";
        String str2 = "BCD";

        int overlapChar = StringReassembly.overlap(str1, str2);
        int overlapCharExpect = 2;

        String combination = StringReassembly.combination(str1, str2,
                overlapChar);
        String combinationExpect = "ABCD";

        assertEquals(overlapChar, overlapCharExpect);
        assertEquals(combination, combinationExpect);
    }

    @Test
    //routine
    public void testCombination_ABCD_DEFG_1() {
        String str1 = "ABCD";
        String str2 = "DEFG";

        int overlapChar = StringReassembly.overlap(str1, str2);
        int overlapCharExpect = 1;

        String combination = StringReassembly.combination(str1, str2,
                overlapChar);
        String combinationExpect = "ABCDEFG";

        assertEquals(overlapChar, overlapCharExpect);
        assertEquals(combination, combinationExpect);
    }

    @Test
    //challenge: if |str1| < |str2|
    public void testCombination_ABC_BCDE_2() {
        String str1 = "ABC";
        String str2 = "BCDE";

        int overlapChar = StringReassembly.overlap(str1, str2);
        int overlapCharExpect = 2;

        String combination = StringReassembly.combination(str1, str2,
                overlapChar);
        String combinationExpect = "ABCDE";

        assertEquals(overlapChar, overlapCharExpect);
        assertEquals(combination, combinationExpect);
    }

    @Test
    //challenge: if |str1| > |str2|
    public void testCombination_ABCD_CDE_2() {
        String str1 = "ABCD";
        String str2 = "CDE";

        int overlapChar = StringReassembly.overlap(str1, str2);
        int overlapCharExpect = 2;

        String combination = StringReassembly.combination(str1, str2,
                overlapChar);
        String combinationExpect = "ABCDE";

        assertEquals(overlapChar, overlapCharExpect);
        assertEquals(combination, combinationExpect);
    }

    @Test
    //challenge: if there's a space in string
    public void testCombination_AB_CD_CD_EF_3() {
        String str1 = "AB CD";
        String str2 = " CD EF";

        int overlapChar = StringReassembly.overlap(str1, str2);
        int overlapCharExpect = 3;

        String combination = StringReassembly.combination(str1, str2,
                overlapChar);
        String combinationExpect = "AB CD EF";

        assertEquals(overlapCharExpect, overlapChar);
        assertEquals(combinationExpect, combination);
    }

    /*
     * test for addToSetAvoidingSubstrings
     */

    @Test
    //challenge: add a new string into set and some strings in set is a substring of this new string
    public void testAddToSetAvoidingSubstrings_hey_they() {
        Set<String> strSet = new Set1L<>();
        strSet.add("hey");

        String str = "they";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> strSetExpect = new Set1L<>();
        strSetExpect.add("they");

        assertEquals(strSetExpect, strSet);
    }

    @Test
    //challenge: add a new string into set and some strings in set is a substring of this new string
    public void testAddToSetAvoidingSubstrings_ey_hey_they() {
        Set<String> strSet = new Set1L<>();
        strSet.add("ey");
        strSet.add("hey");

        String str = "they";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> strSetExpect = new Set1L<>();
        strSetExpect.add("they");

        assertEquals(strSetExpect, strSet);
    }

    @Test
    //challenge: add a string that is a substring of other strings in set
    public void testAddToSetAvoidingSubstrings_hey_they_ey() {
        Set<String> strSet = new Set1L<>();
        strSet.add("hey");
        strSet.add("they");

        String str = "ey";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> strSetExpect = new Set1L<>();
        strSetExpect.add("hey");
        strSetExpect.add("they");

        assertEquals(strSetExpect, strSet);
    }

    @Test
    /*
     * routine: add a new string into set. This new string is not a substring of
     * any strings in set already, nor does any strings in set already is a
     * substring of this new string
     */
    public void testAddToSetAvoidingSubstrings_hey_hello() {
        Set<String> strSet = new Set1L<>();
        strSet.add("hey");

        String str = "hello";

        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> strSetExpect = new Set1L<>();
        strSetExpect.add("hey");
        strSetExpect.add("hello");

        assertEquals(strSetExpect, strSet);
    }

    /*
     * test for printWithLineSeparators
     */

    @Test
    public void testPrintWithLineSeparators_abc_def_ghi() {
        String text = "abc~def~ghi~";
        SimpleWriter out = new SimpleWriter1L(
                "printWithLineSeparatorsTest.txt");
        StringReassembly.printWithLineSeparators(text, out);
        out.close();
        SimpleReader in = new SimpleReader1L("printWithLineSeparatorsTest.txt");

        assertEquals("abc", in.nextLine());
        assertEquals("def", in.nextLine());
        assertEquals("ghi", in.nextLine());
        assertEquals("", in.nextLine());
    }

}
