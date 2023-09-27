import java.math.BigDecimal;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Zhao Liu
 *
 */
public final class Oddity {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Oddity() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void myMethod() {
        /*
         * Put your code for myMethod here
         */
    }

    /**
     * Returns a modulo b using "clock arithmetic".
     *
     * @param a
     *            the first operand
     * @param b
     *            the modulus
     * @return a modulo b
     * @requires b > 0
     * @ensures mod = a mod b
     */
    private static int mod(int a, int b) {
        return 0;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        // First
        // Oddity
        final int[] values = { 8, -4, 3, 0, -5 };
        int i = 0;
        while (i < values.length) {
            int remainder = values[i] % 2;
            if (remainder == 0) {
                out.println("even");
            } else {
                out.println("odd");
            }
            i = i + 1;
        }

        // Second
        // Time for a Change
        double x = 456.0;
        double y = 100.0 * 4.56;
        // y = 455.99999999999994

        BigDecimal xDecimal = new BigDecimal("456");
        BigDecimal yDecimal = new BigDecimal("4.56");
        BigDecimal scalDecimal = new BigDecimal("100");
        yDecimal = yDecimal.multiply(scalDecimal);

        if (xDecimal.compareTo(yDecimal) == 0) {
            out.println("equal");
        } else {
            out.println("not equal");
        }

        // Third
        // Integer Division
        final int microsPerDay = 24 * 60 * 60 * 1000 * 1000;
        final int millisPerDay = 24 * 60 * 60 * 1000;
        int division = microsPerDay / millisPerDay;
        out.println(division);

        // Fourth
        // Elementary
        out.println(12345 + 54321);

        out.close();
    }

}
