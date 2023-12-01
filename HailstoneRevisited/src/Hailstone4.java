import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        NaturalNumber output = n;
        final NaturalNumber converge = new NaturalNumber2(1);
        final NaturalNumber even = new NaturalNumber2(2);
        final NaturalNumber three = new NaturalNumber2(3);
        NaturalNumber test = new NaturalNumber2(output);
        int length = 1;
        NaturalNumber max = new NaturalNumber2(output);

        while (output.compareTo(converge) != 0) {
            out.print(output + ", ");

            if (test.divide(even).isZero()) {
                output.divide(even);
            } else {
                output.multiply(three);
                output.add(converge);
            }

            test.copyFrom(output);

            if (max.compareTo(output) < 0) {
                max.copyFrom(output);
            }

            length++;
        }

        out.println(converge);
        out.println("the length of the series is: " + length);
        out.println("the max value in this series is: " + max);
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

        String ans;
        do {
            out.println("enter an integer that is greater than zero");
            NaturalNumber n = new NaturalNumber2(in.nextInteger());
            generateSeries(n, out);
            out.println(
                    "do you wish to calculate another series. Response \"y\" to continue; "
                            + "enter anything else to quit.");
            ans = in.nextLine();
        } while (ans.equals("y"));

        out.println("bye!");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
