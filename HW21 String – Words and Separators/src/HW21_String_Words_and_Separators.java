import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HW21_String_Words_and_Separators {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW21_String_Words_and_Separators() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    public static void generateElements(String str, Set<Character> charSet) {
        Set<Character> temp = new Set1L<>();

        for (int i = 0; i < str.length(); i++) {
            if (!temp.contains(str.charAt(i))
                    && !Character.isWhitespace(str.charAt(i))) {
                temp.add(str.charAt(i));
            }
        }

        charSet.transferFrom(temp);
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    public static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {

        String word = "";
        int i = position;

        if (!separators.contains(text.charAt(position))) {

            while (i < text.length() && !separators.contains(text.charAt(i))) {
                /*
                 * if first character is not a separator, go until it hit a
                 * separator
                 */
                word += text.charAt(i);
                i++;

            }
        } else {
            /*
             * if first character is a separator, go until it hit a non
             * separator
             */
            while (!Character.isWhitespace(text.charAt(i)) && i < text.length()
                    && separators.contains(text.charAt(i))) {
                /*
                 * if first character is not a separator, go until it hit a
                 * separator
                 */
                word += text.charAt(i);
                i++;

            }
            word += text.charAt(i);
            i++;
        }

        return word;

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        myMethod();
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
