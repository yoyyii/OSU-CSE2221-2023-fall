import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Yoyi Liao
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE),
            ZERO = new NaturalNumber2(0);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        // TODO: fill in body

        //get the value of inputs

        NaturalNumber num1 = model.top();
        NaturalNumber num2 = model.bottom();

        // check is subtraction allowed
        if (num1.compareTo(num2) < 0) {
            view.updateSubtractAllowed(false);
        } else {
            view.updateSubtractAllowed(true);
        }

        //check is division allowed
        if (num2.compareTo(ZERO) == 0) {
            view.updateDivideAllowed(false);
        } else {
            view.updateDivideAllowed(true);
        }

        //check is root allowed
        if (num2.compareTo(INT_LIMIT) > 0) {
            view.updateSubtractAllowed(false);
        } else {
            view.updateSubtractAllowed(true);
        }

        //check is division allowed
        if (num2.compareTo(TWO) < 0 && num2.compareTo(INT_LIMIT) > 0) {
            view.updateRootAllowed(false);
        } else {
            view.updateSubtractAllowed(true);
        }

        view.updateTopDisplay(num1);
        view.updateBottomDisplay(num2);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        // TODO: fill in body
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();

        top.copyFrom(bottom);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        // TODO: fill in body

        //get the value of inputs

        NaturalNumber num1 = this.model.top();
        NaturalNumber num2 = this.model.bottom();

        //perform event
        num1.add(num2);
        num2.clear();

        //update model
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        // TODO: fill in body

        //get the value of inputs

        NaturalNumber num1 = this.model.top();
        NaturalNumber num2 = this.model.bottom();

        //perform event
        num1.subtract(num2);
        num2.clear();

        //update model
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        // TODO: fill in body

        //get the value of inputs

        NaturalNumber num1 = this.model.top();
        NaturalNumber num2 = this.model.bottom();

        //perform event
        num1.multiply(num2);
        num2.clear();

        //update model
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        // TODO: fill in body
        //get the value of inputs

        NaturalNumber num1 = this.model.top();
        NaturalNumber num2 = this.model.bottom();

        //perform event
        num1.divide(num2);
        num2.clear();

        //update model
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        // TODO: fill in body

        //get the value of inputs

        NaturalNumber num1 = this.model.top();
        NaturalNumber num2 = this.model.bottom();

        //perform event
        num1.power(num2.toInt());
        num2.clear();

        //update model
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        // TODO: fill in body

        //get the value of inputs

        NaturalNumber num1 = this.model.top();
        NaturalNumber num2 = this.model.bottom();
        //perform event
        num1.root(num2.toInt());
        num2.clear();

        //update model
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        // TODO: fill in body

        NaturalNumber bottom = this.model.bottom();
        bottom.multiplyBy10(digit);
        updateViewToMatchModel(this.model, this.view);

    }

}
