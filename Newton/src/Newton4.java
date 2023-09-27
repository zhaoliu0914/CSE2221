import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Calculate square root of a positive number which enter by user, and user also
 * needs to enter relative error.
 *
 * This program will quit if user enter a negative number.
 *
 * @author Zhao Liu
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * equation for Newton iteration: Xn+1 = (1/2)*(Xn + (a/Xn))
     *
     * @param x
     *            positive number to compute square root of
     * @param relativeError
     *            a relative error
     * @return estimate of square root
     */
    private static double sqrt(double x, double relativeError) {
        // this method only take positive number as parameter.
        if (x <= 0.0) {
            return 0.0;
        }

        double root;
        double error;
        double nextNumber = x;

        final double coefficient = 0.5;
        boolean isContinuous = true;

        do {

            // the equation is Xn+1 = (1/2)*(Xn + (a/Xn))
            root = coefficient * (nextNumber + (x / nextNumber));

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
        Double squareRoot;

        out.print("Please enter the relative error of ε: ");
        double relativeError = Double.parseDouble(in.nextLine());

        while (isContinue) {
            out.print(
                    "Please enter a positive number to calculate square root: ");
            double number = Double.parseDouble(in.nextLine());
            if (number > 0.0) {
                // compute square roots by using Newton iteration
                squareRoot = sqrt(number, relativeError);
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
