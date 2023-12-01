import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Yoyi Liao
 *
 */
public final class Glossary {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Glossary() {
    }

    /**
     * outprint the heading of html file
     *
     * @param out
     *            the output stream
     * @param title
     *            the title of the page
     * @requires out.is_open
     *
     * @ensures out.content = #out.content * [the html heading tags]
     */
    public static void printHTMLHeading(SimpleWriter out, String title) {

        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
    }

    /**
     * Read input file and maps it into maps that has {@code key} as key,
     * {@code value} as value.
     *
     * @param in
     *            the input file reader
     * @param dictionary
     *            map we wish to update
     * @update dictionary
     *
     * @requires {@code dictionary} != null
     *
     * @requires in.is_open
     *
     * @ensures {@code dictionary} pairs each term with its definition
     */
    public static void createMap(SimpleReader in,
            Map<String, String> dictionary) {

        assert dictionary != null : "Violation of: dictionary is not null";

        String key = "";
        String value = "";

        while (!in.atEOS()) {
            String next = in.nextLine();

            if (isTerm(next)) {
                key = next;
                value = getDefinition(in);
            }

            dictionary.add(key, value);
            value = "";
        }

    }

    /**
     * get the definition of the term
     *
     * @param in
     *            the input file reader
     *
     * @requires in.is_open
     *
     * @ensure the definition of the term
     *
     */
    public static String getDefinition(SimpleReader in) {

        String value = "";
        String next = in.nextLine();

        while (!next.isEmpty() && !in.atEOS()) {
            value += next;
            next = in.nextLine();

        }

        if (in.atEOS()) {
            value += next;
        }

        return value;

    }

    /**
     * Verify if {@code str} is a term of some definition .
     *
     * @param str
     *            given string
     *
     * @ensure whether {@code str} is a term
     *
     */

    public static boolean isTerm(String str) {

        boolean result;

        if (str.length() == 0) {
            result = false;
        } else {
            String[] array = str.trim().split(" ");
            if (array.length == 1) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }

    /**
     * outprint the home / index page of the glossary
     *
     * @param folder
     *            where the page will be saved
     *
     * @param terms
     *            a queue that contains all the terms in sorted order
     *
     * @param dictionary
     *            the map that maps each term to its definition
     *
     * @ensures a proper sub-page of the term
     */
    public static void printHomePage(String folder, Queue<String> terms,
            Map<String, String> dictionary) {

        SimpleWriter out = new SimpleWriter1L(folder + "/index.html");

        printHTMLHeading(out, "Glossary");

        out.println("<h2>Glossary</h2>");
        out.println("<hr>");
        out.println("<h3>Index</h3>");

        // loop through the queue and create a sub-page for each term
        for (String s : terms) {
            out.println("<li><a href=\"" + s + ".html\">" + s + "</a></li>");
            printTermPage(s, dictionary.value(s), folder, dictionary);
        }

        printHTMLFooter(out);
    }

    /**
     * outprint the sub page of the term
     *
     * @param out
     *            the output stream
     *
     * @param definition
     *            the definition of the term
     *
     * @param folder
     *            where the page will be saved
     *
     * @param dictionary
     *            the map that maps each term to its definition
     *
     * @ensures a proper sub-page of the term
     */
    public static void printTermPage(String title, String definition,
            String folder, Map<String, String> dictionary) {

        SimpleWriter out = new SimpleWriter1L(folder + "/" + title + ".html");
        printHTMLHeading(out, title);
        printTermTitle(out, title);
        printTermDefinition(out, definition, dictionary);
        out.println("<p>Return to <a href=\"index.html\">index</a>.</p>");
        printHTMLFooter(out);
    }

    /**
     * outprint the the definition of each term
     *
     * @param out
     *            the output stream
     *
     * @param definition
     *            the definition of the term
     *
     * @param dictionary
     *            the map that maps each term to its definition
     *
     * @requires out.is_open
     *
     * @ensures out.content = #out.content * [the proper html tags of the
     *          definition]
     */

    public static void printTermDefinition(SimpleWriter out, String definition,
            Map<String, String> dictionary) {

        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        //create an array to split and store each individual word in definition
        String[] arr = definition.split(" ");
        String print = "<blockquote>";

        /*
         * check if the current word is in the dictionary. If it is, hyperlink
         * the word to its corresponding page
         */
        for (String ss : arr) {
            //if this word contains comma at the end
            if (ss.contains(",")) {
                /*
                 * trim the comma away so it could test correctly
                 */
                ss = ss.substring(0, ss.length() - 1);
                if (dictionary.hasKey(ss)) {
                    print += "<a href = \"" + ss + ".html\">" + ss + "</a>";
                    //make sure to add the comma back
                    print += ", ";
                } else {
                    print += ss;
                    //make sure to add the comma back
                    print += ", ";
                }
            } else if (dictionary.hasKey(ss)) {
                //if ss is a term in map, hyper link it to its corresponding page
                print += "<a href = \"" + ss + ".html\">" + ss + "</a>";
                print += " ";
            } else {
                print += ss;
                print += " ";
            }
        }
        print += "</blockquote>";

        //outprint the definition with proper html tags
        out.println(print);
    }

    /**
     * outprint the title of each term's subpage
     *
     * @param out
     *            the output stream
     *
     * @param term
     *            the title of the page
     *
     * @requires out.is_open
     *
     * @ensures out.content = #out.content * [the term title format tag]
     */
    public static void printTermTitle(SimpleWriter out, String term) {

        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        out.println("<h2><b><i><font color=\"red\">" + term
                + "</font></i></b></h2>");
    }

    /**
     * outprint the footer of html file
     *
     * @param out
     *            the output stream
     *
     * @requires out.is_open
     *
     * @ensures out.content = #out.content * [the html closing tags]
     */

    public static void printHTMLFooter(SimpleWriter out) {

        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {
        if (q.length() != 0) {

            String temp = removeMin(q, order);
            sort(q, order);
            q.enqueue(temp);
        }
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    public static String removeMin(Queue<String> q, Comparator<String> order) {
        String min = "";
        Queue<String> copyQ = new Queue1L<>();

        for (String s : q) {

            if (min.equals("")) {//initial condition
                min = s;
            }

            int comp = order.compare(min, s);

            if (comp < 0) { // min < s
                min = s;
            }

            copyQ.enqueue(s);
        }

        for (String s : copyQ) {
            String temp = q.dequeue();
            if (!s.equals(min)) {
                q.enqueue(temp);
            }
        }
        return min;
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
         * enter file name
         */
        out.print("Enter the name of the input file : ");
        String fileIn = in.nextLine();

        // how to read the file input
        SimpleReader fileReader = new SimpleReader1L(fileIn);

        /*
         * enter the output file name
         */
        out.print(
                "Enter the name of a folder where all the output files will be saved (The output folder must already exist)");

        String folder = in.nextLine();

        // create a map to map each term with its definition
        Map<String, String> dictionary = new Map1L<>();
        createMap(fileReader, dictionary);

        //create a sorted queue
        Queue<String> terms = new Queue1L<>();

        for (Map.Pair<String, String> p : dictionary) {
            terms.enqueue(p.key());
        }

        Comparator<String> strCompare = new StringComparator();
        sort(terms, strCompare);

        //print the index page
        printHomePage(folder, terms, dictionary);

        /*
         * Close I/O streams.
         */

        in.close();
        out.close();

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
