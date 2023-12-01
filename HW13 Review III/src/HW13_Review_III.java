import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HW13_Review_III {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW13_Review_III() {
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
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        final NaturalNumber ten = new NaturalNumber2(10);
        final NaturalNumber zero = new NaturalNumber2(0);
        NaturalNumber result = new NaturalNumber2();

        if (n.compareTo(ten) < 0) {
            result = new NaturalNumber2(n);
        } else {
            int digit = n.divideBy10();
            NaturalNumber digitNN = new NaturalNumber2(digit);
            result.copyFrom(digitNN);
            result.multiply(productOfDigits1(n));
        }
        n.copyFrom(zero);
        return result;

    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {
        final NaturalNumber ten = new NaturalNumber2(10);
        NaturalNumber result = new NaturalNumber2();

        if (n.compareTo(ten) < 0) {
            result = new NaturalNumber2(n);
        } else {
            int digit = n.divideBy10();
            NaturalNumber digitNN = new NaturalNumber2(digit);
            result.copyFrom(digitNN);
            result.multiply(productOfDigits2(n));
            n.multiplyBy10(digit);
        }

        return result;

    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {
        int result = n.divideBy10();
        if (!n.isZero()) {
            result = toInt(n) * 10 + result;
        }
        return result;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean result = false;
        for (int i = 0; result == false && i < xml.numberOfChildren(); i++) {
            if (xml.child(i).isTag()) {
                result = findTag(xml.child(i), tag);
            }
            if (xml.isTag() && xml.child(i).label().equals(tag)) {
                result = true;
            }
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
