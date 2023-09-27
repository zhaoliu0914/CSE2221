import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Zhao Liu
 *
 */
public final class Homework3n1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Homework3n1() {

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        output.print("Please enter Area Bound: ");
        int areaBound = input.nextInteger();

        int n = 1;
        int m = 1;
        int squareN = (int) Math.pow(n, 2);
        int squareM = (int) Math.pow(m, 2);
        int sum = 0;

        while (squareN < areaBound) {

            m = 1;
            while (squareM < areaBound) {
                sum = sum + squareN + squareM;

                m++;
                squareM = (int) Math.pow(m, 2);
            }

            n++;
            squareN = (int) Math.pow(n, 2);
        }

        output.print("Sum is: " + sum);

        input.close();
        output.close();
    }

}
