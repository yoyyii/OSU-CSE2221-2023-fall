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
public final class Hailstone4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone4() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer and give out the length of the series and the maximum number of
     * the series as well.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {

        if (n > 0) {
            int length = 1;
            int max = n;
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                    out.println(n);
                } else {
                    n = 3 * n + 1;
                    out.println(n);

                }

                if (max < n) {
                    max = n;
                }
                length++;
            }

            out.println("the length of the series is: " + length);
            out.println("the maximum value of the series is: " + max);
        } else {
            out.println("please enter a positive integer.");
            return;
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

        String ans;

        do {
            out.println("please enter a positive integer.");

            int n = in.nextInteger();

            generateSeries(n, out);
            out.println(
                    "do you want to calculate another series? Enter 'y' for yes. "
                            + "Enter anything else for no");
            ans = in.nextLine();
        } while (ans.equals("y"));

        out.println("bye bye!");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
