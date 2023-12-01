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
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * This method will calculate the square root of the number user input
     */
    private static double sqrt(double x, double e) {

        // define variable for error and my guess.
        double error = e;
        double r = x;

        // adding this if statement so if the user input 0 the program will
        // automatically return 0
        if (x == 0) {
            return 0;
        }

        // using while loop to update my guess until my error is within the range
        while ((Math.abs(r * r - x) / x) > error * error) {
            r = (r + x / r) / 2;
        }

        // return my guess
        return r;
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
         * Ask the user to type in the number and percentage of error they wish
         * to tolerate, then call sqrt method to calculate the square root. Quit
         * the program if the user enter negative number
         */

        boolean repeat = true;

        while (repeat == true) {
            out.println(
                    "Please enter the number you wish to square root. Enter "
                            + "a negative number to quit the program.");

            double x = in.nextDouble();

            if (x >= 0) {
                out.println(
                        "Please enter the percentage of error, in demimal, that you "
                                + "wish to tolerate (for example, please enter 0.0001 for "
                                + "0.01% of error):");
                double e = in.nextDouble();

                double result = sqrt(x, e);

                out.println(result);
            } else {
                repeat = false;
            }
        }

        out.println("bye bye!");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
