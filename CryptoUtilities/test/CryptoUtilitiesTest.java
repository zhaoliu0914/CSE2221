import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Zhao Liu
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_12_16() {
        NaturalNumber n = new NaturalNumber2("12");
        NaturalNumber nExpected = new NaturalNumber2("4");
        NaturalNumber m = new NaturalNumber2("16");
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_319_377() {
        NaturalNumber n = new NaturalNumber2("319");
        NaturalNumber nExpected = new NaturalNumber2("29");
        NaturalNumber m = new NaturalNumber2("377");
        NaturalNumber mExpected = new NaturalNumber2("0");
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_615_1997() {
        NaturalNumber n = new NaturalNumber2("615");
        NaturalNumber nExpected = new NaturalNumber2("1");
        NaturalNumber m = new NaturalNumber2("1997");
        NaturalNumber mExpected = new NaturalNumber2("0");
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_1() {
        NaturalNumber n = new NaturalNumber2("97979849845598");
        NaturalNumber nExpected = new NaturalNumber2("2");
        NaturalNumber m = new NaturalNumber2("1234567890124");
        NaturalNumber mExpected = new NaturalNumber2("0");
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2("0");
        NaturalNumber nExpected = new NaturalNumber2("0");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2("1");
        NaturalNumber nExpected = new NaturalNumber2("1");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_2() {
        NaturalNumber n = new NaturalNumber2("2");
        NaturalNumber nExpected = new NaturalNumber2("2");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_null() {
        NaturalNumber n = null;
        NaturalNumber nExpected = null;
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_10000() {
        NaturalNumber n = new NaturalNumber2("10000");
        NaturalNumber nExpected = new NaturalNumber2("10000");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_10001() {
        NaturalNumber n = new NaturalNumber2("10001");
        NaturalNumber nExpected = new NaturalNumber2("10001");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_10008() {
        NaturalNumber n = new NaturalNumber2("10008");
        NaturalNumber nExpected = new NaturalNumber2("10008");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_11_13_19() {
        NaturalNumber n = new NaturalNumber2(11);
        NaturalNumber nExpected = new NaturalNumber2(11);
        NaturalNumber p = new NaturalNumber2(13);
        NaturalNumber pExpected = new NaturalNumber2(13);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_4() {
        NaturalNumber n = new NaturalNumber2(5675635);
        NaturalNumber nExpected = new NaturalNumber2(12731);
        NaturalNumber p = new NaturalNumber2(445662);
        NaturalNumber pExpected = new NaturalNumber2(445662);
        NaturalNumber m = new NaturalNumber2(24343);
        NaturalNumber mExpected = new NaturalNumber2(24343);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_5() {
        NaturalNumber n = new NaturalNumber2("78938462696847639583");
        NaturalNumber nExpected = new NaturalNumber2(3663320);
        NaturalNumber p = new NaturalNumber2("100000000000");
        NaturalNumber pExpected = new NaturalNumber2("100000000000");
        NaturalNumber m = new NaturalNumber2("45869483");
        NaturalNumber mExpected = new NaturalNumber2("45869483");
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Test of isWitnessToCompositeness
     */
    @Test
    public void testIsWitnessToCompositeness_1() {
        NaturalNumber w = new NaturalNumber2("4");
        NaturalNumber wExpected = new NaturalNumber2("4");
        NaturalNumber n = new NaturalNumber2("8");
        NaturalNumber nExpected = new NaturalNumber2("8");
        boolean witnessExpected = true;

        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(w, wExpected);
        assertEquals(n, nExpected);
        assertEquals(witnessExpected, result);
    }

    @Test
    public void testIsWitnessToCompositeness_2() {
        NaturalNumber w = new NaturalNumber2("5");
        NaturalNumber wExpected = new NaturalNumber2("5");
        NaturalNumber n = new NaturalNumber2("11");
        NaturalNumber nExpected = new NaturalNumber2("11");
        boolean witnessExpected = false;

        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(w, wExpected);
        assertEquals(n, nExpected);
        assertEquals(witnessExpected, result);
    }

    @Test
    public void testIsWitnessToCompositeness_3() {
        NaturalNumber w = new NaturalNumber2("21");
        NaturalNumber wExpected = new NaturalNumber2("21");
        NaturalNumber n = new NaturalNumber2("99");
        NaturalNumber nExpected = new NaturalNumber2("99");
        boolean witnessExpected = true;

        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(w, wExpected);
        assertEquals(n, nExpected);
        assertEquals(witnessExpected, result);
    }

    @Test
    public void testIsWitnessToCompositeness_4() {
        NaturalNumber w = new NaturalNumber2("90");
        NaturalNumber wExpected = new NaturalNumber2("90");
        NaturalNumber n = new NaturalNumber2("271");
        NaturalNumber nExpected = new NaturalNumber2("271");
        boolean witnessExpected = false;

        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(w, wExpected);
        assertEquals(n, nExpected);
        assertEquals(witnessExpected, result);
    }

    /*
     * Test of isPrime1
     */
    @Test
    public void testIsPrime1_1() {
        NaturalNumber n = new NaturalNumber2("4");
        NaturalNumber nExpected = new NaturalNumber2("4");
        boolean primeExpected = false;

        boolean result = CryptoUtilities.isPrime1(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    @Test
    public void testIsPrime1_2() {
        NaturalNumber n = new NaturalNumber2("123");
        NaturalNumber nExpected = new NaturalNumber2("123");
        boolean primeExpected = false;

        boolean result = CryptoUtilities.isPrime1(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    @Test
    public void testIsPrime1_3() {
        NaturalNumber n = new NaturalNumber2("11");
        NaturalNumber nExpected = new NaturalNumber2("11");
        boolean primeExpected = true;

        boolean result = CryptoUtilities.isPrime1(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    @Test
    public void testIsPrime1_4() {
        NaturalNumber n = new NaturalNumber2("83");
        NaturalNumber nExpected = new NaturalNumber2("83");
        boolean primeExpected = true;

        boolean result = CryptoUtilities.isPrime1(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    /*
     * Test of isPrime2
     */
    @Test
    public void testIsPrime2_1() {
        NaturalNumber n = new NaturalNumber2("4");
        NaturalNumber nExpected = new NaturalNumber2("4");
        boolean primeExpected = false;

        boolean result = CryptoUtilities.isPrime2(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    @Test
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2("251");
        NaturalNumber nExpected = new NaturalNumber2("251");
        boolean primeExpected = true;

        boolean result = CryptoUtilities.isPrime2(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    @Test
    public void testIsPrime2_3() {
        NaturalNumber n = new NaturalNumber2("51");
        NaturalNumber nExpected = new NaturalNumber2("51");
        boolean primeExpected = false;

        boolean result = CryptoUtilities.isPrime2(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    @Test
    public void testIsPrime2_4() {
        NaturalNumber n = new NaturalNumber2("89");
        NaturalNumber nExpected = new NaturalNumber2("89");
        boolean primeExpected = true;

        boolean result = CryptoUtilities.isPrime2(n);

        assertEquals(n, nExpected);
        assertEquals(primeExpected, result);
    }

    /*
     * Test of generateNextLikelyPrime
     */
    @Test
    public void testGenerateNextLikelyPrime_1() {
        NaturalNumber n = new NaturalNumber2("4");
        NaturalNumber nExpected = new NaturalNumber2("5");

        CryptoUtilities.generateNextLikelyPrime(n);

        assertEquals(n, nExpected);
    }

    @Test
    public void testGenerateNextLikelyPrime_2() {
        NaturalNumber n = new NaturalNumber2("20");
        NaturalNumber nExpected = new NaturalNumber2("23");

        CryptoUtilities.generateNextLikelyPrime(n);

        assertEquals(n, nExpected);
    }

    @Test
    public void testGenerateNextLikelyPrime_3() {
        NaturalNumber n = new NaturalNumber2("104");
        NaturalNumber nExpected = new NaturalNumber2("107");

        CryptoUtilities.generateNextLikelyPrime(n);

        assertEquals(n, nExpected);
    }

}
