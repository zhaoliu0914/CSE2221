import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Model class.
 *
 * @author Zhao Liu
 */
public final class AppendUndoModel1 implements AppendUndoModel {

    /**
     * Model variables.
     */
    private String input;
    /**
     * output string in reverse order.
     */
    private Stack<String> output;

    /**
     * redo stack.
     */
    private Stack<String> redoStack;

    /**
     * Default constructor.
     */
    public AppendUndoModel1() {
        /*
         * Initialize model;
         */
        this.input = "";
        this.output = new Stack1L<>();
        this.redoStack = new Stack1L<>();
    }

    @Override
    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String input() {
        return this.input;
    }

    @Override
    public Stack<String> output() {
        return this.output;
    }

    @Override
    public Stack<String> getRedoStack() {
        return this.redoStack;
    }

}
