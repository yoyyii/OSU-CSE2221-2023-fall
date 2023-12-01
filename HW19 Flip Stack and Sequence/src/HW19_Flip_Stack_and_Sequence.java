import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HW19_Flip_Stack_and_Sequence {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HW19_Flip_Stack_and_Sequence() {
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
        Stack<T> copyThis = new Stack1L<>();
        while (this.length() != 0) {
            T temp = (T) this.pop();
            copyThis.push(temp);
        }

        this.transferFrom(copyThis);
    }

    /**
     * Reverses ("flips") {@code this}.
     * 
     * @updates this
     * @ensures this = rev(#this)
     */

    public void flip() {
        for (int i = 0; i < this.length(); i++) {
            T temp = this.remove(this.length() - 1);
            this.add(i, temp);
        }
    }

    public void flip_2() {
        if (this.length() != 0) {
            T temp = this.remove(this.length() - 1);
            this.flip();
            this.add(0, temp);
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
