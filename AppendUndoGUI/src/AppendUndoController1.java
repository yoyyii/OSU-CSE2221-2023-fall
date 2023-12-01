
/**
 * Controller class.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */

import components.stack.Stack;
import components.stack.Stack1L;

public final class AppendUndoController1 implements AppendUndoController {

    /**
     * Model object.
     */
    private final AppendUndoModel model;

    /**
     * View object.
     */
    private final AppendUndoView view;

    /**
     * Updates view to display model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     */
    private static void updateViewToMatchModel(AppendUndoModel model,
            AppendUndoView view) {
        /*
         * Get model info
         */
        String input = model.input();
        Stack<String> output = model.output();
        /*
         * Update view to reflect changes in model
         */

        view.updateInputDisplay(input);

        output.flip();
        Stack<String> temp = new Stack1L<>();
        String str = "";
        String pop = "";

        while (output.length() > 0) {
            pop = output.pop();
            str += pop;
            temp.push(pop);
        }

        output.transferFrom(temp);

        view.updateOutputDisplay(str);
    }

    /**
     * Constructor; connects {@code this} to the model and view it coordinates.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public AppendUndoController1(AppendUndoModel model, AppendUndoView view) {
        this.model = model;
        this.view = view;
        /*
         * Update view to reflect initial value of model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    /**
     * Processes event to reset model.
     *
     * @updates {@code this.model, this.view}
     * @ensures <pre>
     * {@code this.model.input = ""  and
     * this.model.output = <>  and
     * [this.view has been updated to match this.model]}
     * </pre>
     */
    public void processResetEvent() {

        this.model.setInput("");
        this.model.output().clear();
        this.model.output().push("");

        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes event to append to output.
     *
     * @param input
     *            string to be appended
     *
     * @updates {@code this.model, this.view}
     * @ensures <pre>
     * {@code this.model.input = ""  and
     * this.model.output =  <input> * #this.model.output  and
     * [this.view has been updated to match this.model]}
     * </pre>
     */
    @Override
    public void processAppendEvent(String input) {

        this.model.output().push(input);
        this.model.setInput("");
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes event to undo last append to output.
     *
     * @updates {@code this.model, this.view}
     * @requires <pre>
     * {@code this.model.output /= <>}
     * </pre>
     * @ensures <pre>
     * {@code #this.model.output = <this.model.input> * this.model.output  and
     * [this.view has been updated to match this.model]}
     * </pre>
     */
    @Override
    public void processUndoEvent() {
        this.model.output().pop();
        updateViewToMatchModel(this.model, this.view);
    }

}
