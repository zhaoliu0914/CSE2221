import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {

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

        // declare unit name and unit conversion.
        final String[] unitNameArray = { "dollar", "half-dollar", "quarter",
                "dime", "nickel", "penny" };
        final int[] unitConversionArray = { 100, 50, 25, 10, 5, 1 };

        out.print("Please enter number of cents: ");
        int cents = Integer.parseInt(in.nextLine());

        // calculate how many dollar can be used.
        int tempCents = cents;
        int index = 0;
        int[] changes = new int[unitConversionArray.length];

        while (tempCents > 0 && index < unitConversionArray.length) {
            //String unitName = unitNameArray[index];
            int unitConversion = unitConversionArray[index];

            // calculate changes based on unit conversion.
            // It's like 105 cents can be express to 1 dollar and 5 cents remainder.
            int unitChanges = tempCents / unitConversion;
            int centRemind = tempCents % unitConversion;

            changes[index] = unitChanges;

            // send remainder to next unit conversion to calculate the unit amount.
            tempCents = centRemind;
            index++;
        }

        for (int i = 0; i < changes.length; i++) {
            out.print(changes[i] + " " + unitNameArray[i]);
            if (i < changes.length - 1) {
                out.print(", ");
            }
        }

        // Close input and output streams
        in.close();
        out.close();
    }

}
