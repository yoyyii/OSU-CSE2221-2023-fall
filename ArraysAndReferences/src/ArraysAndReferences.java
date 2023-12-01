import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test arrays, references, and arrays of references.
 *
 * @author Yoyi Liao
 *
 */
public final class ArraysAndReferences {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ArraysAndReferences() {
    }

    /**
     * Computes the product of the {@code NaturalNumber}s in the given array.
     *
     * @param nnArray
     *            the array
     * @return the product of the numbers in the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * productOfArrayElements =
     *    [nnArray[0] * nnArray[1] * ... * nnArray[nnArray.length-1]]
     * </pre>
     */
    private static NaturalNumber productOfArrayElements(
            NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        // TODO - fill in body
        NaturalNumber product = new NaturalNumber2(1);

        for (int i = 0; i < nnArray.length; i++) {
            product.multiply(nnArray[i]);
        }

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return product;
    }

    /**
     * Replaces each element of {@code nnArray} with the partial product of all
     * the elements in the incoming array, up to and including the current
     * element.
     *
     * @param nnArray
     *            the array
     * @updates nnArray
     * @requires nnArray.length > 0
     * @ensures <pre>
     * for all i: integer where (0 <= i < nnArray.length)
     *   (nnArray[i] = [#nnArray[0] * #nnArray[1] * ... * #nnArray[i]])
     * </pre>
     */
    private static void computePartialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        // TODO - fill in body

    }

    /**
     * Creates and returns a new array of {@code NaturalNumber}s, of the same
     * size of the given array, containing the partial products of the elements
     * of the given array.
     *
     * @param nnArray
     *            the array
     * @return the array of partial products of the elements of the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * partialProducts.length = nnArray.length  and
     *  for all i: integer where (0 <= i < partialProducts.length)
     *    (partialProducts[i] = [nnArray[0] * nnArray[1] * ... * nnArray[i]])
     * </pre>
     */
    private static NaturalNumber[] partialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        NaturalNumber previous = new NaturalNumber2();
        previous.copyFrom(nnArray[0]);
        NaturalNumber curr = new NaturalNumber2();
        // TODO - fill in body

        for (int i = 1; i < nnArray.length; i++) {
            curr.copyFrom(nnArray[i]);
            curr.multiply(previous);
            nnArray[i].copyFrom(curr);
            previous.copyFrom(curr);
        }

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return nnArray;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Initialize an array of NaturalNumbers with values 1 through 42.
         */
        NaturalNumber[] array = new NaturalNumber[42];
        NaturalNumber count = new NaturalNumber2(1);

        for (int i = 0; i < array.length; i++) {
            array[i] = new NaturalNumber2(0);
            array[i].copyFrom(count);
            count.increment();
        }
        /*
         * Compute and output the product of the numbers in the array (should be
         * 42!, i.e., the factorial of 42).
         */
        NaturalNumber product = productOfArrayElements(array);
        out.println(product);

        NaturalNumber[] arr = partialProducts(array);
        for (int i = 0; i < arr.length; i++) {
            out.println(arr[i]);
        }
        /*
         * Run the program and test your implementation of
         * productOfArrayElements.
         *
         * What should be the correct output? A: 1.405E51 How do you know what
         * the correct output should be? A: i used a calculator to calculate 42!
         *
         * One of the problems with the current test code is that it uses a big
         * input (an array of 42 elements) for which it is difficult to even
         * know what the correct output should be.
         *
         * Modify the statement that creates the array so that the array has 1
         * element (instead of 42). What is the expected output? Run the program
         * again. Does it produce the correct output?
         *
         * A: expected output is 1,it doesn't produce the correct output. It
         * produced 2
         *
         * Now try with an array of size 2. What is the expected output? Run the
         * program again. Does it produce the correct output?
         *
         * A: expected output is 2, it produced 9 so it doesn't produced the
         * correct output
         */

        out.close();
    }

}