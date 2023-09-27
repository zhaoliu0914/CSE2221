import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Zhao Liu
 *
 */
public final class Hailstone1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        NaturalNumber series = new NaturalNumber2(n.toInt());
        int seriesCount = 0;
        NaturalNumber maxValue = new NaturalNumber2("0");
        //int maxValue = 0;
        //final NaturalNumber zero = new NaturalNumber2("0");
        final NaturalNumber one = new NaturalNumber2("1");
        //final NaturalNumber two = new NaturalNumber2("2");
        final NaturalNumber evenDenominator = new NaturalNumber2("2");
        final NaturalNumber oddNumerator = new NaturalNumber2("3");

        while (series.compareTo(one) != 0) {
            out.print(series + ", ");
            seriesCount++;

            if (series.compareTo(maxValue) > 0) {
                maxValue.setFromInt(series.toInt());
            }

            if (series.toInt() % 2 == 0) {
                //series = series / evenDenominator;
                series.divide(evenDenominator);
            } else {
                series.multiply(oddNumerator);
                series.add(one);
            }
        }

        out.println(series);
        seriesCount++;

        out.println("The length of the series: " + seriesCount);

        out.println("The maximum value of the series: " + maxValue.toString());

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

        boolean isNotValidNumber = true;
        String number;
        int numberAsInt = 0;

        do {
            out.print("Please enter a positive number: ");
            number = in.nextLine();

            boolean isCanParseInt = FormatChecker.canParseInt(number);
            if (isCanParseInt) {
                numberAsInt = Integer.parseInt(number);

                if (numberAsInt > 0) {
                    isNotValidNumber = false;
                }
            }
        } while (isNotValidNumber);

        NaturalNumber naturalNumber = new NaturalNumber2(numberAsInt);

        generateSeries(naturalNumber, out);
        out.println(naturalNumber);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
