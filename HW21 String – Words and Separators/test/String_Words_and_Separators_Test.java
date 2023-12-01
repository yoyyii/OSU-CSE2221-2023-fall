import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

public class String_Words_and_Separators_Test {

    @Test
    //routine
    public void generateElementsTest() {
        Set<Character> charSet = new Set1L<>();
        String str = "abc";
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('a');
        charSetExpected.add('b');
        charSetExpected.add('c');
        HW21_String_Words_and_Separators.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    //challenge: str is empty
    public void generateElementsTest2() {
        Set<Character> charSet = new Set1L<>();
        String str = "";
        Set<Character> charSetExpected = new Set1L<>();

        HW21_String_Words_and_Separators.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    //challenge: str has duplicate string
    public void generateElementsTest3() {
        Set<Character> charSet = new Set1L<>();
        String str = "aaa";
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('a');

        HW21_String_Words_and_Separators.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    //challenge: charSet is not empty
    public void generateElementsTest4() {
        Set<Character> charSet = new Set1L<>();
        charSet.add('x');
        charSet.add('y');
        String str = "abc";
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('a');
        charSetExpected.add('b');
        charSetExpected.add('c');
        HW21_String_Words_and_Separators.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    @Test
    //challenge: str contains white spaces
    public void generateElementsTest5() {
        Set<Character> charSet = new Set1L<>();
        String str = "a bc";
        Set<Character> charSetExpected = new Set1L<>();
        charSetExpected.add('a');
        charSetExpected.add('b');
        charSetExpected.add('c');
        HW21_String_Words_and_Separators.generateElements(str, charSet);
        assertEquals(charSetExpected, charSet);
    }

    /**
     * Test for the common condition for getting a word.
     *
     */
    @Test
    public void nextWordOrSeparatorTest1() {
        String text = "Please separat this sentence";
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        String result = HW21_String_Words_and_Separators
                .nextWordOrSeparator(text, 0, separators);
        String resultExpect = "Please";
        assertEquals(result, resultExpect);
    }

    /**
     * Test for the common condition for getting a separator.
     *
     */
    @Test
    public void nextWordOrSeparatorTest2() {
        String text = "Please separat this sentence";
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        final int six = 6;
        String result = HW21_String_Words_and_Separators
                .nextWordOrSeparator(text, six, separators);
        String resultExpect = " ";
        assertEquals(result, resultExpect);
    }

    /**
     * Test for the special condition for getting double separators.
     *
     */
    @Test
    public void nextWordOrSeparatorTest3() {
        String text = "Please, separat this sentence";
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        final int six = 6;
        String result = HW21_String_Words_and_Separators
                .nextWordOrSeparator(text, six, separators);
        String resultExpect = ", ";
        assertEquals(result, resultExpect);
    }

}
