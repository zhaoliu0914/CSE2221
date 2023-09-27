import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code NaturalNumber}.
 *
 * @author Zhao Liu
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
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
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        String numberNode = "number";
        String plusOperator = "plus";
        String minusOperator = "minus";
        String timesOperator = "times";
        String divideOperator = "divide";
        String modOperator = "mod";
        String powerOperator = "power";
        String rootOperator = "root";
        NaturalNumber zero = new NaturalNumber2("0");
        NaturalNumber two = new NaturalNumber2("2");

        // current node indicates operator
        String operator = exp.label();
        NaturalNumber result;

        if (operator.equals(numberNode)) {
            // current node is a number node
            String value = exp.attributeValue("value");
            result = new NaturalNumber2(value);
        } else {
            // left node is an operator node
            // right node is an operator node
            XMLTree leftNode = exp.child(0);
            XMLTree rightNode = exp.child(1);

            result = evaluate(leftNode);

            NaturalNumber rightValue = evaluate(rightNode);

            // check for operator and do corresponding operation.
            if (plusOperator.equals(operator)) {
                // left value + right value
                result.add(rightValue);
            } else if (timesOperator.equals(operator)) {
                // left value * right value
                result.multiply(rightValue);
            } else if (minusOperator.equals(operator)) {
                // left value - right value
                if (result.compareTo(rightValue) < 0) {
                    components.utilities.Reporter.fatalErrorToConsole(
                            "The minus equation is negative number.");
                } else {
                    result.subtract(rightValue);
                }
            } else if (divideOperator.equals(operator)) {
                // left value / right value
                if (zero.compareTo(rightValue) == 0) {
                    components.utilities.Reporter.fatalErrorToConsole(
                            "The equation can not divide by 0.");
                } else {
                    result.divide(rightValue);
                }
            } else if (modOperator.equals(operator)) {
                // left value % right value
                if (zero.compareTo(rightValue) == 0) {
                    components.utilities.Reporter.fatalErrorToConsole(
                            "The equation can not divide by 0.");
                } else {
                    result = result.divide(rightValue);
                }
            } else if (powerOperator.equals(operator)) {
                // left value ^ right value
                result.power(rightValue.toInt());
            } else if (rootOperator.equals(operator)) {
                // root operation
                if (rightValue.compareTo(two) < 0) {
                    components.utilities.Reporter.fatalErrorToConsole(
                            "The root operation needs at least "
                                    + "2th root of its incoming value.");
                } else {
                    result.root(rightValue.toInt());
                }
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
