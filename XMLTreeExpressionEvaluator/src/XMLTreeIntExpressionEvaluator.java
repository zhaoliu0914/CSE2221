import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Zhao Liu
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        String numberNode = "number";
        String plusOperator = "plus";
        String minusOperator = "minus";
        String timesOperator = "times";
        String divideOperator = "divide";

        // current node indicates operator
        String operator = exp.label();
        int result = 0;

        if (operator.equals(numberNode)) {
            // current node is a number node
            String value = exp.attributeValue("value");
            result = Integer.parseInt(value);
        } else {
            // left node is an operator node
            // right node is an operator node
            XMLTree leftNode = exp.child(0);
            XMLTree rightNode = exp.child(1);

            int leftValue = evaluate(leftNode);

            int rightValue = evaluate(rightNode);

            // check for operator and do corresponding operation.
            if (plusOperator.equals(operator)) {
                // left value + right value
                result = leftValue + rightValue;
            } else if (timesOperator.equals(operator)) {
                // left value * right value
                result = leftValue * rightValue;
            } else if (minusOperator.equals(operator)) {
                // left value - right value
                result = leftValue - rightValue;
            } else if (divideOperator.equals(operator)) {
                // left value / right value
                result = leftValue / rightValue;
            }
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
