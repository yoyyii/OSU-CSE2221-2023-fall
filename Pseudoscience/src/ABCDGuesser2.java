import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * asks the user what constant μ should be approximated, and then asks in turn
 * for each of the four personal numbers w, x, y, and z. The program should then
 * calculate and report the values of the exponents a, b, c, and d that bring
 * the de Jager formula as close as possible to μ, as well as the value of the
 * formula waxbyczd and the relative error of the approximation to the nearest
 * hundredth of one percent
 *
 * @author Yoyi Liao
 *
 */
public final class ABCDGuesser2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {

        double mu = -1;

        while (Double.compare(mu, 0) <= 0) {
            out.println("please enter a positive real-valued for mu");
            String input = in.nextLine();

            if (FormatChecker.canParseDouble(input)) {
                mu = Double.parseDouble(input);
            }

        }

        return mu;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        double numInput = -1;

        while (Double.compare(numInput, 0) <= 0
                || Double.compare(numInput, 1) == 0) {
            out.println("Please choose positive "
                    + "numbers that are significant to you that are not 1");
            String input = in.nextLine();

            if (FormatChecker.canParseDouble(input)) {
                numInput = Double.parseDouble(input);
            }
        }
        return numInput;
    }

    /**
     * compute the guess value based on user's
     *
     * @param w
     *            double stream of user's choice
     * @param x
     *            double stream of user's choice
     * @param y
     *            double stream of user's choice
     * @param z
     *            double stream of user's choice
     * @param a
     *            int stream of counter to indicate the index of value in
     *            exponent we want to access
     * @param b
     *            int stream of counter to indicate the index of value in
     *            exponent we want to access
     * @param c
     *            int stream of counter to indicate the index of value in
     *            exponent we want to access
     * @param d
     *            int stream of counter to indicate the index of value in
     *            exponent we want to access
     * @param mu
     *            double stream that indicate which value we would like to
     *            approximate
     *
     * @param exponent
     *            array stream that contains the array of "magic numbers" we
     *            would use to help approximate the guessed value
     *
     * @return a double value of the guessed value computed
     */
    private static double guess(double w, double x, double y, double z, int a,
            int b, int c, int d, double mu, double[] exponents) {
        return Math.abs(((Math.pow(w, exponents[a]))
                * (Math.pow(x, exponents[b])) * (Math.pow(y, exponents[c]))
                * (Math.pow(z, exponents[d]))) - mu);
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

        // ask the user for the value of mu
        double mu = getPositiveDouble(in, out);

        // ask the user for the value of w, x, y, z
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        // declare exponents that will be used for the formula
        double[] exponents = { -5, -4, -3, -2, -1, -1.0 / 2.0, -1.0 / 3.0,
                -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1, 2, 3, 4, 5 };

        // declare counters
        double expoA = 0, expoB = 0, expoC = 0, expoD = 0;

        // find initial difference
        double difference = Math.abs(((Math.pow(w, exponents[0]))
                * (Math.pow(x, exponents[0])) * (Math.pow(y, exponents[0]))
                * (Math.pow(z, exponents[0]))) - mu);

        /*
         * loop through every possible permutation of a, b, c, and d to find the
         * combination that will produce the least amount of difference to mu
         */
        for (int a = 0; a < exponents.length; a++) {
            for (int b = 0; b < exponents.length; b++) {
                for (int c = 0; c < exponents.length; c++) {
                    for (int d = 0; d < exponents.length; d++) {

                        /*
                         * find the value using current exponent combination. If
                         * this combination produced smaller value than previous
                         * combination, update the value
                         */
                        double guess = guess(w, x, y, z, a, b, c, d, mu,
                                exponents);

                        if (difference > guess) {
                            difference = guess;
                            expoA = exponents[a];
                            expoB = exponents[b];
                            expoC = exponents[c];
                            expoD = exponents[d];
                        }
                    }
                }
            }
        }

        // report the value, relative error, as well as the value of a, b, c, d used to produce the result
        double value = (Math.pow(w, expoA)) * (Math.pow(x, expoB))
                * (Math.pow(y, expoC)) * (Math.pow(z, expoD));
        int intValue = (int) value;
        out.println("The calculated value is: " + intValue);

        double error = (difference / mu) * 100;
        out.print("The percentage of error is: ");
        out.print(error, 2, false);
        out.println(" %");

        out.println("The exponent of the first number you chose was: " + expoA);
        out.println(
                "The exponent of the second number you chose was: " + expoB);
        out.println("The exponent of the third number you chose was: " + expoC);
        out.println(
                "The exponent of the fourth number you chose was: " + expoD);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
