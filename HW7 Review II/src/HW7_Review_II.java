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
public final class HW7_Review_II {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW7_Review_II() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    public static void part_a(SimpleReader in, SimpleWriter out) {
        //      a. Only the uppercase letters in the String

        String input = in.nextLine();
        for (int j = 0; j < input.length(); j++) {
            if (Character.isUpperCase(input.charAt(j))) {
                out.println(input.charAt(j));
            }
        }

    }

    public static void part_b(SimpleReader in, SimpleWriter out) {
        //        b. Every second letter of the String

        String input = in.nextLine();
        for (int j = 0; j < input.length(); j += 2) {
            out.println(input.charAt(j));
        }

    }

    public static void part_c(SimpleReader in, SimpleWriter out) {
        //c.        The String with all vowels replaced by an underscore

        String input = in.nextLine();
        String copy = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e'
                    || input.charAt(i) == 'i' || input.charAt(i) == 'o'
                    || input.charAt(i) == 'u') {
                copy += "_";
            } else {
                copy += input.charAt(i);
            }

        }

        out.println(copy);

    }

    public static void part_d(SimpleReader in, SimpleWriter out) {
        //      d. The number of vowels in the String

        String input = in.nextLine();
        int vowels = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e'
                    || input.charAt(i) == 'i' || input.charAt(i) == 'o'
                    || input.charAt(i) == 'u') {
                vowels += 1;
            }
        }

        out.println(vowels);

    }

    public static void part_e(SimpleReader in, SimpleWriter out) {
        //      e. The positions of all vowels in the String

        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e'
                    || input.charAt(i) == 'i' || input.charAt(i) == 'o'
                    || input.charAt(i) == 'u') {
                out.println(i);
            }

        }

    }

    public static void question_3(SimpleReader in, SimpleWriter out) {

        /*
         * Write Java code for a loop that simultaneously computes both the
         * maximum and minimum of an array of ints called a.
         */

        int[] a = new int[20];
        int max = a[0];
        int min = a[0];
        for (int j = 0; j < a.length; j++) {
            max = Math.max(max, a[j]);
            min = Math.min(min, a[j]);
        }

        out.println(max);
        out.println(min);

    }

    public static void question_4(SimpleReader in, SimpleWriter out) {

        /*
         * 4. Write Java code for a loop that sets boolean variable isOrdered to
         * true if the elements of a given array of ints called a are in
         * non-decreasing order, otherwise it sets isOrdered to false.
         */

        int[] are = new int[20];
        boolean isOrdered = true;
        for (int j = 0; j < are.length - 1; j++) {
            if (are[j + 1] < are[j]) {
                isOrdered = false;
            }
        }

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
