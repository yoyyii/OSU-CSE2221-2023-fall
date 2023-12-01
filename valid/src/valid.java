import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class valid {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private valid() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    public static boolean check(String s) {
        String[] open = { "(", "{", "[", "<" };
        String[] close = { ")", "}", "]", ">" };

        Stack<String> openS = new Stack1L<>();
        Queue<String> closeQ = new Queue1L<>();

        boolean result = true;
        if (s.length() % 2 == 0) {

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < open.length; k++) {
                    String cur = Character.toString(s.charAt(j));
                    if (cur.equals(open[k])) {
                        openS.push(cur);
                    }
                }

                for (int k = 0; k < close.length; k++) {
                    String cur = Character.toString(s.charAt(j));
                    if (cur.equals(close[k])) {
                        closeQ.enqueue(cur);
                    }
                }
            }

            for (int i = 0; i < closeQ.length() && result == true; i++) {
                if (!(closeQ.dequeue()).equals(openS.pop())) {
                    result = false;
                }
            }
        } else {
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
        out.println(check("{}"));
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
