import components.queue.Queue;
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
public final class HW15_Queue_I {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW15_Queue_I() {
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
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     * for all x: integer
     *     where (x is in entries(q))
     *   (min <= x)
     * </pre>
     */
    private static int min(Queue<Integer> q) {
        assert q.length() != 0 : "Violation of: q is not empty";
        int min = q.front();

        for (int j : q) {

            if (j < min) {
                min = j;
            }
        }

        return min;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        assert q.length() != 0 : "Violation of: q is not empty";
        int[] minAndMax = { q.front(), q.front() };

        for (int j : q) {
            if (j < minAndMax[0]) {
                minAndMax[0] = j;
            }

            if (j > minAndMax[1]) {
                minAndMax[1] = j;
            }
        }
        return minAndMax;
    }

    /*
     * 3. Consider the minAndMax operation again. Write a second implementation
     * for this operation that uses the "Noah's Ark" algorithm. This algorithm
     * takes entries from q in pairs, first comparing them to each other, then
     * comparing the smaller of the pair to the minimum so far and the larger of
     * the pair to the maximum so far.
     * 
     */
    private static int[] minAndMax_2(Queue<Integer> q) {
        assert q.length() != 0 : "Violation of: q is not empty";

        int[] minAndMax = { q.front(), q.front() };

        for (int j = 0; j < q.length() - 1; j += 2) {
            int x = q.dequeue();
            int y = q.dequeue();
            int[] compare = new int[2];

            if (x < y) {
                compare[0] = x;
                compare[1] = y;
            } else {
                compare[0] = y;
                compare[1] = x;
            }

            if (compare[0] < minAndMax[0]) {
                minAndMax[0] = compare[0];
            }

            if (compare[1] > minAndMax[1]) {
                minAndMax[1] = compare[1];
            }

            q.enqueue(x);
            q.enqueue(y);
        }

        return minAndMax;
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
