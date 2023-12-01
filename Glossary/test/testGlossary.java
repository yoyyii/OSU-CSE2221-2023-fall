import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class testGlossary {

    /*
     * test for createMap
     */

    @Test
    //routine
    public void testCreateMap() {
        Map<String, String> map = new Map1L<>();
        String fileIn = "data\\terms.txt";
        SimpleReader fileReader = new SimpleReader1L(fileIn);

        Map<String, String> mapExpect = new Map1L<>();
        mapExpect.add("meaning",
                "something that one wishes to convey, especially by language");
        mapExpect.add("term", "a word whose definition is in a glossary");
        mapExpect.add("word",
                "a string of characters in a language, which has at least one character");
        mapExpect.add("definition",
                "a sequence of words that gives meaning to a term");
        mapExpect.add("glossary",
                "a list of difficult or specialized terms, with their definitions, usually near the end of a book");
        mapExpect.add("language",
                "a set of strings of characters, each of which has meaning");
        mapExpect.add("book", "a printed or written literary work");

        Glossary.createMap(fileReader, map);

        assertEquals(mapExpect, map);
    }

    @Test
    //routine
    public void testCreateMap2() {
        Map<String, String> map = new Map1L<>();
        String fileIn = "data\\test.txt";
        SimpleReader fileReader = new SimpleReader1L(fileIn);

        Map<String, String> mapExpect = new Map1L<>();

        mapExpect.add("language",
                "a set of strings of characters, each of which has meaning");
        mapExpect.add("word",
                "a string of characters in a language, which has at least one character");
        mapExpect.add("test", "testcase");

        Glossary.createMap(fileReader, map);

        assertEquals(mapExpect, map);
    }

    /*
     * test for isTerm
     */

    @Test
    //routine: str is a word
    public void testIsWord_hello() {
        String str = "hello";
        boolean result = Glossary.isTerm(str);
        assertEquals(true, result);
    }

    @Test
    //routine: str is not a word
    public void testIsWord_he_llo() {
        String str = "he llo";
        boolean result = Glossary.isTerm(str);
        assertEquals(false, result);
    }

    @Test
    //challenge: str is an empty string
    public void testIsWord_() {
        String str = "";
        boolean result = Glossary.isTerm(str);
        assertEquals(false, result);
    }

    /*
     * test for sort
     */

    @Test
    //challenge: if queue is empty
    public void testSort_empty() {
        Queue<String> terms = new Queue1L<>();
        Queue<String> termsExpect = new Queue1L<>();

        Comparator<String> strCompare = new StringComparator();
        Glossary.sort(terms, strCompare);

        assertEquals(termsExpect, terms);
    }

    @Test
    //challenge: if queue only contain one element
    public void testSort_a() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("a");
        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("a");

        Comparator<String> strCompare = new StringComparator();
        Glossary.sort(terms, strCompare);

        assertEquals(termsExpect, terms);
    }

    @Test
    //challenge: if there's nothing need to be done
    public void testSort_aaa_bbb_ccc() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("aaa");
        terms.enqueue("bbb");
        terms.enqueue("ccc");

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("aaa");
        termsExpect.enqueue("bbb");
        termsExpect.enqueue("ccc");

        Comparator<String> strCompare = new StringComparator();
        Glossary.sort(terms, strCompare);

        assertEquals(termsExpect, terms);
    }

    @Test
    //routine
    public void testSort_c_b_a() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("c");
        terms.enqueue("b");
        terms.enqueue("a");

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("a");
        termsExpect.enqueue("b");
        termsExpect.enqueue("c");

        Comparator<String> strCompare = new StringComparator();
        Glossary.sort(terms, strCompare);

        assertEquals(termsExpect, terms);
    }

    @Test
    //challenge: if there's repeated elements in queue
    public void testSort_c_b_a_b() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("c");
        terms.enqueue("b");
        terms.enqueue("a");
        terms.enqueue("b");

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("a");
        termsExpect.enqueue("b");
        termsExpect.enqueue("c");

        Comparator<String> strCompare = new StringComparator();
        Glossary.sort(terms, strCompare);

        assertEquals(termsExpect, terms);
    }

    /*
     * test for removeMin
     */

    @Test
    //challenge: if queue is empty
    public void testRemoveMin_empty() {
        Queue<String> terms = new Queue1L<>();
        String minExpect = "";

        Comparator<String> strCompare = new StringComparator();
        String min = Glossary.removeMin(terms, strCompare);
        Queue<String> termsExpect = new Queue1L<>();

        assertEquals(minExpect, min);
        assertEquals(termsExpect, terms);
    }

    @Test
    //challenge: if queue only contain one element
    public void testRemoveMin_a() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("a");
        String minExpect = "a";

        Comparator<String> strCompare = new StringComparator();
        String min = Glossary.removeMin(terms, strCompare);
        Queue<String> termsExpect = new Queue1L<>();

        assertEquals(minExpect, min);
        assertEquals(termsExpect, terms);
    }

    @Test
    //routine
    public void testRemoveMin_aaa_bbb_ccc() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("aaa");
        terms.enqueue("bbb");
        terms.enqueue("ccc");
        String minExpect = "ccc";

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("aaa");
        termsExpect.enqueue("bbb");

        Comparator<String> strCompare = new StringComparator();
        String min = Glossary.removeMin(terms, strCompare);

        assertEquals(minExpect, min);
        assertEquals(termsExpect, terms);
    }

    @Test
    //routine
    public void testRemoveMin_ccc_bbb_aaa() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("ccc");
        terms.enqueue("bbb");
        terms.enqueue("aaa");
        String minExpect = "ccc";

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("bbb");
        termsExpect.enqueue("aaa");

        Comparator<String> strCompare = new StringComparator();
        String min = Glossary.removeMin(terms, strCompare);

        assertEquals(minExpect, min);
        assertEquals(termsExpect, terms);
    }

    @Test
    //challenge: if there's repeated elements in queue
    public void testRemoveMin_c_b_a_b() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("c");
        terms.enqueue("b");
        terms.enqueue("a");
        terms.enqueue("b");

        String minExpect = "c";

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("b");
        termsExpect.enqueue("a");
        termsExpect.enqueue("b");

        Comparator<String> strCompare = new StringComparator();
        String min = Glossary.removeMin(terms, strCompare);

        assertEquals(minExpect, min);
        assertEquals(termsExpect, terms);
    }

    @Test
    //challenge: if there's repeated elements in queue
    public void testRemoveMin_b_b_a_b() {
        Queue<String> terms = new Queue1L<>();
        terms.enqueue("b");
        terms.enqueue("b");
        terms.enqueue("a");
        terms.enqueue("b");

        String minExpect = "b";

        Queue<String> termsExpect = new Queue1L<>();
        termsExpect.enqueue("a");

        Comparator<String> strCompare = new StringComparator();
        String min = Glossary.removeMin(terms, strCompare);

        assertEquals(minExpect, min);
        assertEquals(termsExpect, terms);
    }

    private static class StringComparator implements Comparator<String> {
        /**
         * compares which String is bigger.
         *
         * @param str1
         *            the first String
         * @param str2
         *            the second String
         * @return 1 if {@code str1} is larger than {@code str2} -1 if
         *         {@code str1} is larger than {@code str2} 0 if @code str1}
         *         equals to {@code str2}
         */
        @Override
        public int compare(String s1, String s2) {
            if (s1.compareTo(s2) < 0) {
                return -1;
            } else if (s1.compareTo(s2) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
