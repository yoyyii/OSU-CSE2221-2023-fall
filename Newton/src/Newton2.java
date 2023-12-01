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
public final class Newton2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton2() {
    }

    /**
     * This method will calculate the square root of the number user input
     */
    private static double sqrt(double x) {

        // define variable for error and my guess.
        final double error = 0.0001;
        double r = x;

        /*
         * adding this if statement so if the user input 0 the program will
         * automatically return 0
         */
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
         * ask user if they want to calculate the square root of their desire
         * number. If so, ask the user to type in the number and call sqrt
         * method to calculate the square root.
         */

        out.println(
                "Do you wish to calculate a square root? Respond 'y' for yes. "
                        + "Respond anything else to quit.");

        String y = in.nextLine();

        if (y.equals("y")) {
            out.println("Please enter the number you wish to square root");
            double x = in.nextDouble();
            double result = sqrt(x);

            out.println(result);
        } else {
            out.println("Bye bye!");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
