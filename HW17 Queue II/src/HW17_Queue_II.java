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
public final class HW17_Queue_II {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW17_Queue_II() {
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
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip() {
        if (this.length() != 0) {
            T temp = this.dequeue();
            this.flip();
            this.enqueue(temp);
        }
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @requires |q| != 0
     * @ensures this = rev(#this)
     */
    public static void flip(Queue<T> q) {
        if (q.length() != 0) {
            T temp = q.dequeue();
            q.flip();
            q.enqueue(temp);
        }
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
