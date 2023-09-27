import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        final double areaOfSquare = 4.0;
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Declare counters and initialize them
         */
        int ptsInInterval = 0, ptsInSubinterval = 0;
        /*
         * Create pseudo-random number generator
         */
        Random rnd = new Random1L();
        /*
         * Generate points and count how many fall in [0.0,0.5) interval
         */
        while (ptsInInterval < n) {
            /*
             * Generate pseudo-random number in [0.0,1.0) interval
             */
            double x = rnd.nextDouble() * 2.0;
            double y = rnd.nextDouble() * 2.0;

            // calculate the distance between point(x,y) and center(1.0, 1.0)
            double distanceX = Math.pow((x - 1.0), 2);
            double distanceY = Math.pow((y - 1.0), 2);
            double distance = Math.sqrt(distanceX + distanceY);

            /*
             * Increment total number of generated points
             */
            ptsInInterval++;

            if (distance < 1.0) {
                ptsInSubinterval++;
            }
        }
        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         */
        double estimate = (1.0 * ptsInSubinterval) / ptsInInterval;

        double areaOfCircle = estimate * areaOfSquare;
        //output.println("Estimate of percentage: " + estimate + "%");
        output.println("The area of a circle of radius 1: " + areaOfCircle);

        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}
