import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Project for practicing getting name from user and then print it.
 *
 * @author Zhao Liu
 *
 */
public final class HelloJack7 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack7() {
    }

    /**
     *
     * Compute the both the maximum and minimum in a loop.
     *
     * @param a
     *            an array which need to be computed Max and Mini values
     * @param out
     *            out stream.
     */
    public static void computeMaxAndMini(int[] a, SimpleWriter out) {
        int max = a[0];
        int min = a[0];
        int temp;
        for (int i = 0; i < a.length; i++) {
            temp = a[i];

            if (temp < min) {
                min = temp;
            }
            if (temp > max) {
                max = temp;
            }
        }

        out.println("The maximum = " + max);
        out.println("The minimum = " + min);
    }

    /**
     * Check an array of int if this array is non-decreasing order.
     *
     * @param a
     *            an array which need to be checked
     * @param out
     *            out stream
     */
    public static void checkForOrder(int[] a, SimpleWriter out) {
        boolean isOrdered = true;

        int lastInt = a[0];
        for (int i = 0; i < a.length && isOrdered; i++) {
            if (lastInt > a[i]) {

                isOrdered = false;
            }
            lastInt = a[i];
        }
        out.println("This array is non-decreasing: " + isOrdered);
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

        final int[] a = { 1, 2, 3, 3, 3, 4, 5, 6, 10 };
        //computeMaxAndMini(a, out);

        checkForOrder(a, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
