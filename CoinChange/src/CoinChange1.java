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
public final class CoinChange1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange1() {
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

        makeChange(money, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

    public static void makeChange(int money, SimpleWriter out) {
        int dollar = 0;
        int halfDollar = 0;
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        if (money > 0) {
            dollar = money / 100;
            money = money % 100;
        }

        if (money > 0) {
            halfDollar = money / 50;
            money = money % 50;
        }

        if (money > 0) {
            quarter = money / 25;
            money = money % 25;
        }

        if (money > 0) {
            dime = money / 10;
            money = money % 10;
        }

        if (money > 0) {
            nickel = money / 5;
            money = money % 5;
        }

        if (money > 0) {
            penny = money;
        }

        out.println("dollar: " + dollar);
        out.println("halfDollar: " + halfDollar);
        out.println("quarter: " + quarter);
        out.println("dime: " + dime);
        out.println("nickel: " + nickel);
        out.println("penny: " + penny);

    }

}
