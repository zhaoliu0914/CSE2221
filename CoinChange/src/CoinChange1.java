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
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {

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

        int tempCents = cents;
        int index = 0;
        StringBuilder changes = new StringBuilder();

        while (tempCents > 0 && index < unitConversionArray.length) {
            String unitName = unitNameArray[index];
            int unitConversion = unitConversionArray[index];

            // calculate changes based on unit conversion.
            // It's like 105 cents can be express to 1 dollar and 5 cents remainder.
            int unitChanges = tempCents / unitConversion;
            int centRemainder = tempCents % unitConversion;

            //change = change + unitChanges + " " + unitName;

            // append unit name and unit amount into changes(StringBuilder).
            changes.append(unitChanges);
            changes.append(" ");
            changes.append(unitName);

            if (index < unitConversionArray.length - 1) {
                //change = change + ", ";
                changes.append(", ");
            }

            // send remainder to next unit conversion to calculate the unit amount.
            tempCents = centRemainder;
            index++;
        }

        out.println(changes.toString());

        // Close input and output streams
        in.close();
        out.close();
    }

}
