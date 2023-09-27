import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Zhao Liu
 *
 */
public final class Homework3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Homework3() {

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        final int coefficient = 4;

        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        output.print("How much terms: ");
        int n = input.nextInteger();

        double series = 0;
        for (int i = 0; i < n; i++) {

            int denominator = (2 * i) + 1;

            if (i % 2 == 0) {
                series = series + (1.0 / denominator);
            } else {
                series = series + (-1.0 / denominator);
            }

        }

        double result = series * coefficient;
        output.print("Result is: " + result);

        input.close();
        output.close();
    }

}
