import components.stack.Stack;

/**
 * Controller class.
 *
 * @author Zhao Liu
 */
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
        Stack<String> outputStack = model.output();

        // switch stack into string
        int index = outputStack.length();
        String[] outputArray = new String[outputStack.length()];
        for (String temp : outputStack) {
            index--;
            outputArray[index] = temp;
        }

        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < outputArray.length; i++) {
            outputBuilder.append(outputArray[i]);
        }

        /*
         * Update view to reflect changes in model
         */
        view.updateInputDisplay(input);
        view.updateOutputDisplay(outputBuilder.toString());

        // if there is no any text in output text area, then disable the undo Button
        if (outputBuilder.length() == 0) {
            view.updateUndoAllowed(false);
        } else {
            view.updateUndoAllowed(true);
        }

        Stack<String> redoStack = model.getRedoStack();
        if (redoStack.length() == 0) {
            view.updateRedoAllowed(false);
        } else {
            view.updateRedoAllowed(true);
        }
    }

    /**
     * Processes reset event.
     */
    @Override
    public void processResetEvent() {
        /*
         * Update model in response to this event
         */
        this.model.setInput("");
        Stack<String> outputStack = this.model.output();
        outputStack.clear();

        Stack<String> redoStack = this.model.getRedoStack();
        redoStack.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes append event.
     *
     * @param input
     *            value of input text (provided by view)
     */
    @Override
    public void processAppendEvent(String input) {
        /*
         * Update model in response to this event
         */
        this.model.setInput("");
        Stack<String> outputStack = this.model.output();
        if (input != null && !input.isBlank()) {
            outputStack.push(input);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processUndoEvent() {
        Stack<String> outputStack = this.model.output();
        if (outputStack.length() > 0) {
            String lastStr = outputStack.pop();

            Stack<String> redoStack = this.model.getRedoStack();
            redoStack.push(lastStr);
            this.model.setInput(lastStr);
        }

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRedoEvent() {
        Stack<String> redoStack = this.model.getRedoStack();
        String redoString = redoStack.pop();

        Stack<String> outputStack = this.model.output();
        outputStack.push(redoString);

        this.model.setInput("");

        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

}
