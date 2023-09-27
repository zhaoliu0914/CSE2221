
import java.math.BigDecimal;
import java.util.regex.Pattern;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Zhao Liu
 */
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer and repeatedly asks the user whether they wish to calculate
     * another series.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        /*
         * If x is even, then the next value in the series is x/2; if x is odd,
         * then the next value in the series is 3x + 1
         */

        int series = n;
        int seriesCount = 0;
        int maxValue = 0;
        final int evenDenominator = 2;
        final int oddNumerator = 3;

        while (series != 1) {
            out.print(series + ", ");
            seriesCount++;

            if (series > maxValue) {
                maxValue = series;
            }

            if (series % 2 == 0) {
                series = series / evenDenominator;
            } else {
                series = (oddNumerator * series) + 1;
            }
        }

        out.println(series);
        seriesCount++;

        out.println("The length of the series: " + seriesCount);

        out.println("The maximum value of the series: " + maxValue);
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger1(SimpleReader in, SimpleWriter out) {
        boolean isPositiveNumber = false;
        String number;

        Pattern pattern = Pattern.compile("[\\d]*$");

        do {
            out.print("Please enter a positive number: ");
            number = in.nextLine();

            isPositiveNumber = pattern.matcher(number).matches();

            if (isPositiveNumber && "0".equals(number)) {
                isPositiveNumber = false;
            }

            if (isPositiveNumber) {
                BigDecimal tempNumber = new BigDecimal(number);
                BigDecimal maxInt = new BigDecimal(Integer.MAX_VALUE);
                if (tempNumber.compareTo(maxInt) > 0) {
                    isPositiveNumber = false;
                }
            }

        } while (!isPositiveNumber);

        return Integer.parseInt(number);
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
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
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        int initialNumber = getPositiveInteger(in, out);

        boolean isContinue = false;

        do {
            generateSeries(initialNumber, out);

            out.println();

            out.print("Do you wish to calculate another series? (Y/N) ");
            String answer = in.nextLine();
            if ("y".equalsIgnoreCase(answer)) {
                isContinue = true;

                initialNumber = getPositiveInteger(in, out);
            } else {
                isContinue = false;
            }

        } while (isContinue);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
