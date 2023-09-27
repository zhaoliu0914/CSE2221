import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Calculate square root of a positive number which enter by user, and user also
 * needs to enter relative error.
 *
 * it will also ask the user for a root k (an integer greater than or equal to
 * 2), and calculate the k-th root of x
 *
 * This program will quit if user enter a negative number.
 *
 * @author Zhao Liu
 *
 */
public final class Newton6 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton6() {
    }

    /**
     * Computes estimate of k-th root of x to within relative error 0.01%.
     *
     * equation for Newton iteration:
     *
     * X(n + 1) = (1 / k) * ((k - 1) * X(n) + A / X(n)^(k - 1))
     *
     * @param x
     *            positive number to compute square root of
     * @param k
     *            k-th root of x
     * @param relativeError
     *            a relative error
     * @return estimate of square root
     */
    private static double sqrt(double x, int k, double relativeError) {
        // this method only take positive number as parameter.
        if (x <= 0.0) {
            return 0.0;
        }

        double root;
        double error;
        double nextNumber = x;

        final double coefficient = 1.0 / k;
        boolean isContinuous = true;

        do {

            // X(n + 1) = (1 / k) * ((k - 1) * X(n) + A / X(n)^(k - 1))

            root = coefficient * (((k - 1) * nextNumber)
                    + (x / Math.pow(nextNumber, k - 1)));

            // check for relative error
            error = Math.abs(root - nextNumber);
            if (error > relativeError) {
                isContinuous = true;
            } else {
                isContinuous = false;
            }

            nextNumber = root;

        } while (isContinuous);

        return root;
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

        boolean isContinue = true;
        boolean isValidateDouble = true;
        double squareRoot;
        double number = 0.0;

        out.print("Please enter the relative error of ε: ");
        double relativeError = Double.parseDouble(in.nextLine());

        while (isContinue) {
            out.print(
                    "Please enter a positive number to calculate square root: ");
            String temp = in.nextLine();
            isValidateDouble = FormatChecker.canParseInt(temp);
            if (isValidateDouble) {
                number = Double.parseDouble(temp);
                isValidateDouble = true;
            } else {
                isValidateDouble = false;
            }

            out.print("Please enter a root k (the k-th root)"
                    + "which is an integer greater than or equal to 2: ");
            int kth = Integer.parseInt(in.nextLine());

            if (isValidateDouble && number > 0.0) {
                // compute square roots by using Newton iteration
                squareRoot = sqrt(number, kth, relativeError);
                out.println("The square root: " + squareRoot);

                out.println();

                isContinue = true;
            } else {
                isContinue = false;
            }
        }

        // Close input and output streams
        in.close();
        out.close();
    }

}
