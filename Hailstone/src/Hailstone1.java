
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 */
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
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
        final int evenDenominator = 2;
        final int oddNumerator = 3;

        while (series != 1) {
            out.print(series + ", ");

            if (series % 2 == 0) {
                series = series / evenDenominator;
            } else {
                series = (oddNumerator * series) + 1;
            }
        }

        out.print(series);
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

        out.print("Please enter a positive number: ");
        int initialNumber = in.nextInteger();

        generateSeries(initialNumber, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
