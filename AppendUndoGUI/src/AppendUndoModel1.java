import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Model class.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public final class AppendUndoModel1 implements AppendUndoModel {

    /**
     * Model variables.
     */
    private String input;
    Stack<String> output = new Stack1L<>();

    /**
     * Default constructor.
     */
    public AppendUndoModel1() {
        /*
         * Initialize model; both variables start as empty strings
         */
        this.input = "";
        this.output.clear();
    }

    @Override
    /**
     * Sets this.input to argument.
     *
     * @param input
     *            new this.input value
     * @ensures <pre>
     * {@code this.input = input}
     * </pre>
     *
     *          void setInput(String input);
     */

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    /**
     * Reports this.input.
     *
     * @return this.input
     * @ensures <pre>
     * {@code input = this.input}
     * </pre>
     *
     *          String input();
     */

    public String input() {
        return this.input;
    }

    @Override
    /**
     * Reports this.output.
     *
     * @return this.output
     * @aliases reference returned by {@code output}
     * @ensures <pre>
     * {@code output = this.output}
     * </pre>
     *
     *          Stack<String> output();
     */
    public Stack<String> output() {
        return this.output;
    }

}
