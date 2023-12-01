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
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
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
         * Put your main program code here
         */

        out.println("enter the amount of cents to make change");
        int money = in.nextInteger();
        int dollar = 100;
        int halfDollar = 50;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        int[] coinCounts = new int[6];
        int[] coinDenominations = { dollar, halfDollar, quarter, dime, nickel,
                penny };

        String[] coinName = { "dollar: ", "halfDollar: ", "quarter: ", "dime: ",
                "nickel: ", "penny: " };

        for (int i = 0; i < coinCounts.length && money >= 0; i++) {
            coinCounts[i] = money / coinDenominations[i];
            out.println(coinName[i] + coinCounts[i]);
            money = money % coinDenominations[i];
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
