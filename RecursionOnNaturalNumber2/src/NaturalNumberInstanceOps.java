import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Extension of {@code NaturalNumber2} with secondary operations implemented as
 * instance methods: add, subtract, and power.
 *
 * @author Zhao Liu
 *
 */
public final class NaturalNumberInstanceOps extends NaturalNumber2 {

    /**
     * No-argument constructor.
     */
    public NaturalNumberInstanceOps() {
    }

    /**
     * Constructor from {@code int}.
     *
     * @param i
     *            {@code int} to initialize from
     */
    public NaturalNumberInstanceOps(int i) {
        super(i);
    }

    /**
     * Constructor from {@code String}.
     *
     * @param s
     *            {@code String} to initialize from
     */
    public NaturalNumberInstanceOps(String s) {
        super(s);
    }

    /**
     * Constructor from {@code NaturalNumber}.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     */
    public NaturalNumberInstanceOps(NaturalNumber n) {
        super(n);
    }

    @Override
    public void add(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        /**
         * @decreases n
         */
        int thisLowDigit = this.divideBy10();
        int nLowDigit = n.divideBy10();
        if (!n.isZero()) {
            this.add(n);
        }
        thisLowDigit += nLowDigit;
        if (thisLowDigit >= RADIX) {
            thisLowDigit -= RADIX;
            this.increment();
        }
        this.multiplyBy10(thisLowDigit);
        n.multiplyBy10(nLowDigit);
    }

    @Override
    public void subtract(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        assert this.compareTo(n) >= 0 : "Violation of: this >= n";

        final int ten = 10;

        if (n.isZero()) {
            return;
        }

        int minuendRemainder = this.divideBy10();
        int subtrahendRemainder = n.divideBy10();

        if (minuendRemainder < subtrahendRemainder) {
            this.decrement();
            minuendRemainder = ten + minuendRemainder;
        }

        int result = minuendRemainder - subtrahendRemainder;

        this.subtract(n);

        this.multiplyBy10(result);
        n.multiplyBy10(subtrahendRemainder);
    }

    @Override
    public void power(int p) {
        assert p >= 0 : "Violation of: p >= 0";

        if (p <= 1) {
            return;
        }

        int decrease = p - 1;
        NaturalNumber temp = new NaturalNumber2(this.toString());

        this.power(decrease);

        this.multiply(temp);
    }

    /**
     * this implement for Fast Powering.
     *
     * @param n
     * @param p
     * @return the value of n^p
     */
    public static int fastPowering(int n, int p) {
        int remainder = p % 2;
        if (p == 0) {
            return 1;
        } else if (remainder == 0) {
            // this is for p is even
            int temp = fastPowering(n, p / 2);
            return temp * temp;
        } else {
            // this is for p is odd
            int temp = fastPowering(n, p - 1);
            return temp * n;
        }
    }

    /**
     * this implement for Fast Powering.
     *
     * @param p
     */
    public void fastPowering(NaturalNumber p) {
        NaturalNumber one = new NaturalNumber2("1");
        NaturalNumber two = new NaturalNumber2("2");

        if (p.isZero()) {
            this.setFromString("1");
            return;
        }

        NaturalNumber remainder = p.divide(two);

        if (remainder.isZero()) {
            // this is for p is even
            //p.divide(two);
            this.fastPowering(p);
            NaturalNumber temp = new NaturalNumber2(this.toString());
            this.multiply(temp);
        } else {
            // this is for p is odd
            NaturalNumber temp = new NaturalNumber2(this.toString());

            // restore p
            // this is only for parameter NaturalNumber
            // int does not need this step
            p.multiply(two);
            p.add(remainder);

            // p = p - 1;
            p.subtract(one);

            this.fastPowering(p);
            this.multiply(temp);
        }
    }

}
