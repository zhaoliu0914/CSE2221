import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * program will find the combination of exponents that minimizes the error of
 * the approximation of μ and then print the exponents, best approximation, and
 * corresponding relative error.
 *
 * @author Zhao Liu
 *
 */
public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {

    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean isPositiveNumber = false;
        String number;
        int returnNumber = 0;
        boolean isCanParseInt;

        do {
            out.print("Please enter a positive number: ");
            number = in.nextLine();

            // check if the number can be converted to integer
            isCanParseInt = FormatChecker.canParseInt(number);

            // if it can not be converted into integer, it will continue the loop.
            // if it can be converted into integer, it will check the positive.
            if (isCanParseInt) {
                returnNumber = Integer.parseInt(number);

                if (returnNumber > 0) {
                    isPositiveNumber = true;
                } else {
                    isPositiveNumber = false;
                }
            } else {
                isPositiveNumber = false;
            }

        } while (!isPositiveNumber);

        return returnNumber;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean isValidNumber = false;
        String number;
        int returnNumber = 0;
        boolean isCanParseInt;

        do {
            out.print("Please enter a positive number not equal to 1.0: ");
            number = in.nextLine();

            // check if the number can be converted to integer
            isCanParseInt = FormatChecker.canParseInt(number);

            // if it can not be converted into integer, it will continue the loop.
            // if it can be converted into integer, it will check the positive.
            if (isCanParseInt) {
                returnNumber = Integer.parseInt(number);

                if (returnNumber > 0 && returnNumber != 1) {
                    isValidNumber = true;
                } else {
                    isValidNumber = false;
                }
            } else {
                isValidNumber = false;
            }

        } while (!isValidNumber);

        return returnNumber;
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

        final double[] exponents = { -5, -4, -3, -2, -1, -1.0 / 2.0, -1.0 / 3.0,
                -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1, 2, 3, 4, 5 };

        final int precision = 8;

        // get the constant μ
        double mu = getPositiveDouble(in, out);

        final double initialRelativeError = mu * 0.1;

        // get four positive real numbers not equal to 1
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        // ow consider the de Jager formula (w^a)*(x^b)*(y^c)*(z^d),
        // where each of a, b, c, and d is one of the 17 numbers
        // {-5, -4, -3, -2, -1, -1/2, -1/3, -1/4, 0, 1/4, 1/3, 1/2, 1, 2, 3, 4, 5}.

        int wIndex = 0;
        int xIndex = 0;
        int yIndex = 0;
        int zIndex = 0;

        double wExponent;
        double xExponent;
        double yExponent;
        double zExponent;

        double multiplyWXYZ;
        double different;
        double smallestDifferent = initialRelativeError;
        double bestApproximation = 0;
        double relativeError = 0;
        int correspondingW = 0;
        int correspondingX = 0;
        int correspondingY = 0;
        int correspondingZ = 0;

        while (wIndex < exponents.length) {
            wExponent = Math.pow(w, exponents[wIndex]);

            xIndex = 0;
            while (xIndex < exponents.length) {

                xExponent = Math.pow(x, exponents[xIndex]);

                yIndex = 0;
                while (yIndex < exponents.length) {

                    yExponent = Math.pow(y, exponents[yIndex]);

                    zIndex = 0;
                    while (zIndex < exponents.length) {

                        zExponent = Math.pow(z, exponents[zIndex]);

                        multiplyWXYZ = wExponent * xExponent * yExponent
                                * zExponent;

                        different = Math.abs(mu - multiplyWXYZ);
                        if (different < smallestDifferent) {
                            smallestDifferent = different;
                            bestApproximation = multiplyWXYZ;
                            correspondingW = wIndex;
                            correspondingX = xIndex;
                            correspondingY = yIndex;
                            correspondingZ = zIndex;
                        }

                        zIndex++;
                    }

                    yIndex++;
                }

                xIndex++;
            }

            wIndex++;
        }

        out.println("the exponents:");
        out.println("a = " + exponents[correspondingW]);
        out.println("b = " + exponents[correspondingX]);
        out.println("c = " + exponents[correspondingY]);
        out.println("d = " + exponents[correspondingZ]);

        out.println("the best approximation = " + bestApproximation);

        relativeError = Math.abs(bestApproximation - mu) / mu;

        out.print("the relative error = ");
        out.print(relativeError, precision, false);

        // 238900
        // 14
        // 102329
        // 1936
        // 13

        // 14^(-5)
        // 102329^1
        // 1936^(1/2)
        // 13^4
        // result 239,103

        // Close input and output streams
        in.close();
        out.close();
    }

}
