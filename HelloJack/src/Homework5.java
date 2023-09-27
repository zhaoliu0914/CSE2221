/**
 *
 * @author Zhao Liu
 *
 */
public final class Homework5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Homework5() {

    }

    /**
     * Find the the larger integer from parameter a and parameter b.
     *
     * @param a
     *            integer a
     * @param b
     *            integer b
     * @return the larger between a and b.
     */
    public static int findLarger(int a, int b) {
        return 0;
    }

    /**
     * find the smallest real number from parameter a, b and c
     *
     * @param a
     *            real number a
     * @param b
     *            real number b
     * @param c
     *            real number c
     * @return the smallest value of three parameters
     */
    public static double findSmallest(double a, double b, double c) {
        return 0.0;
    }

    /**
     * Checking whether parameter number is a prime number
     *
     * @param number
     *            the integer to be tested.
     * @return true, when it is a prime number. false when it is not a prime
     *         number
     */
    public static boolean isPrimeNumber(int number) {
        return true;
    }

    /**
     * Returns true if and a string s is contained inside another string o
     *
     * @param o
     *            largest string
     * @param s
     *            the string to search for
     * @return true if this string contains s, false otherwise
     */
    public static boolean isContained(String o, String s) {
        return true;
    }

    /**
     * Computing the balance of an account by a given initial balance, an annual
     * interest rate, and a number of years of earning interest
     *
     * @param initialBalance
     *            a initial balance
     * @param interestRate
     *            an annual interest rate
     * @param years
     *            a number of years of earning interest
     * @return the new balance
     */
    public static double computingBalance(double initialBalance,
            double interestRate, int years) {
        return 0;
    }

    /**
     * Printing the balance of an account with a given initial balance and an
     * annual interest rate over a given number of years
     *
     * @param initialBalance
     *            a initial balance
     * @param interestRate
     *            an annual interest rate
     * @param years
     *            a number of years of earning interest
     */
    public static void printBalance(double initialBalance, double interestRate,
            int years) {
    }

    /**
     * Printing the calendar for a given month and year
     *
     * @param month
     *            a month which needs to be print
     * @param year
     *            a year which needs to be print
     */
    public static void printingCalendar(int month, int year) {

    }

    /**
     * Computing the weekday for a given day, month, and year
     *
     * @param day
     *            day of month
     * @param month
     *            month of a year
     * @param year
     *            a year
     * @return weekday like "Monday"
     */
    public static String findWeekday(int day, int month, int year) {
        return "";
    }

    /**
     * Generating a random integer between 1 and parameter n
     *
     * @param scope
     *            the random integer will be from 1 to this parameter
     * @return random integer between 1 and parameter n
     */
    public static int randomInteger(int scope) {
        return 0;
    }

    /**
     * returning true if the arguments are all the same
     *
     * @param x
     *            first parameter
     * @param y
     *            second parameter
     * @param z
     *            third parameter
     * @return true if the arguments are all the same, false otherwise.
     */
    public static boolean allTheSame(int x, int y, int z) {
        if (x == y && y == z) {
            return true;
        }
        return false;
    }

    /**
     * returning true if the arguments are all different
     *
     * @param x
     *            first parameter
     * @param y
     *            second parameter
     * @param z
     *            third parameter
     * @return true if the arguments are all different, false otherwise
     */
    public static boolean allDifferent(int x, int y, int z) {
        if (x != y && y != z) {
            return true;
        }
        return false;
    }

    /**
     * returning true if the arguments are sorted with the smallest one coming
     * first
     *
     * @param x
     *            first parameter
     * @param y
     *            second parameter
     * @param z
     *            third parameter
     * @return true if the first parameter is the smallest, false otherwise
     */
    public static boolean sorted(int x, int y, int z) {
        if (x <= y && x <= z) {
            return true;
        }
        return false;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        boolean result = sorted(a, b, c);
        assert result : "The sorted method is not correct.";

        a = a + 2;

        result = sorted(a, b, c);
        assert !result : "The sorted method is not correct.";
    }

}
