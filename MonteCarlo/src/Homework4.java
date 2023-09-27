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
public final class Homework4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Homework4() {
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        double x = xCoord;
        double y = yCoord;

        // calculate the distance between point(x,y) and center(1.0, 1.0)
        double distanceX = Math.pow((x - 1.0), 2);
        double distanceY = Math.pow((y - 1.0), 2);
        double distance = Math.sqrt(distanceX + distanceY);

        // if the distance is less than 1.0, then return true.
        // else will return false;
        if (distance < 1.0) {
            return true;
        }

        return false;
    }

    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {
        int pointsCount = 0;
        int totalPointsInCircle = 0;
        boolean isFallInCircle = false;
        double xCoord;
        double yCoord;
        // Create pseudo-random number generator
        Random rnd = new Random1L();
        // Generate points and count
        // how many fall in a circle of radius 1 centered at (1.0,1.0)
        while (pointsCount < n) {
            // Generate pseudo-random number in [0.0, 2.0) interval
            xCoord = rnd.nextDouble() * 2.0;
            yCoord = rnd.nextDouble() * 2.0;

            isFallInCircle = pointIsInCircle(xCoord, yCoord);
            if (isFallInCircle) {
                totalPointsInCircle++;
            }
            // Increment the count of total number of generated points
            pointsCount++;
        }
        return totalPointsInCircle;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        final double areaOfSquare = 4.0;

        // Open input and output streams
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        // Ask user for number of points to generate
        output.print("Number of points: ");
        int n = input.nextInteger();

        // Declare counters and initialize them
        int ptsInInterval = 0;
        int ptsInSubinterval = 0;

        ptsInInterval = n;
        ptsInSubinterval = numberOfPointsInCircle(ptsInInterval);

        // Estimate proportion of points generated in square [0.0,2.0) x [0.0,2.0)
        // that fall in the circle of radius 1.0 centered at (1.0, 1.1).
        double estimate = (1.0 * ptsInSubinterval) / ptsInInterval;

        double areaOfCircle = estimate * areaOfSquare;
        output.println("The area of a circle of radius 1: " + areaOfCircle);

        // Close input and output streams
        input.close();
        output.close();
    }

}
