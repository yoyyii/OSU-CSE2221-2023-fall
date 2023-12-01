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
public final class HW12_Recursion_I {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW12_Recursion_I() {
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
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        final NaturalNumber ten = new NaturalNumber2(10);
        NaturalNumber nTemp = new NaturalNumber2(n);
        int count = 1;

        if (nTemp.compareTo(ten) >= 0) {
            nTemp.divideBy10();
            int timescall = numberOfDigits(nTemp);
            count = timescall + 1;
        }

        return count;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int sum = 0;
        if (!n.isZero()) {
            int digit = n.divideBy10();
            NaturalNumber c = new NaturalNumber2(n);
            sum = digit + sumOfDigits(c);
        }

        return sum;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigits_2(NaturalNumber n) {
        int digit = 0;
        NaturalNumber sum = new NaturalNumber2(digit);
        if (!n.isZero()) {
            digit = n.divideBy10();
            sum = new NaturalNumber2(digit);
            NaturalNumber addition = new NaturalNumber2(sumOfDigits_2(n));
            sum.add(addition);
        }

        return sum;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */

    private static void divideBy2(NaturalNumber n) {

        int digit = n.divideBy10();
        digit /= 2;

        if (!n.isZero()) {
            int next = n.divideBy10();

            if (next % 2 == 1 && next >= 0) {
                digit += 5;
                next--;
            }
            n.multiplyBy10(next);
            divideBy2(n);
        }
        n.multiplyBy10(digit);
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    /**
     * helper method of isPalindrome.
     *
     * @param str
     *            {@code String} to be checked
     * @param start
     *            the first index of the character of str
     * @param end
     *            the last index of the character of str
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (str = rev(str))
     */
    private static boolean isPalindromeHelper(String str, int start, int end) {
        boolean result = true;

        // If there is only one character
        if (start == end) {
            result = true;
        }

        /*
         * If there are more than two characters, check if middle substring is
         * also palindrome or not
         */
        if (start < end + 1 && start != end) {
            result = isPalindromeHelper(str, start + 1, end - 1);
        }

        // If first and last characters do not match
        if ((str.charAt(start)) != (str.charAt(end))) {
            result = false;
        }

        return result;
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
