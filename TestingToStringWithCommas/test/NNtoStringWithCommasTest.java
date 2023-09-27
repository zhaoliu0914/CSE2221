import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * JUnit test fixture for NNtoStringWithCommas.
 *
 * @author Zhao Liu
 *
 */
public class NNtoStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas5.toStringWithCommas(n);
    }

    /**
     * Test case with input 0. Expected result 0
     */
    @Test
    public void toStringWithCommasTest1() {
        /*
         * Set up variables and call method under test
         */
        String originalNumber = "0";
        String expectedNumber = "0";
        NaturalNumber naturalNumber = new NaturalNumber2(originalNumber);
        String numberWithCommas = redirectToMethodUnderTest(naturalNumber);

        System.out.println("Input = " + originalNumber);
        System.out.println("Output = " + numberWithCommas);

        /*
         * Assert that values of variables match expectations
         */
        // Return result can not be null
        assertTrue(numberWithCommas != null);
        assertTrue(numberWithCommas.length() > 0);
        // the value of the given NaturalNumber must be restored
        assertEquals(naturalNumber.toString(), originalNumber);
        // return value should match to expect number.
        assertEquals(numberWithCommas, expectedNumber);
    }

    /**
     * Test case with input 1000. Expected result 1,000
     */
    @Test
    public void toStringWithCommasTest2() {
        /*
         * Set up variables and call method under test
         */
        String originalNumber = "1000";
        String expectedNumber = "1,000";
        NaturalNumber naturalNumber = new NaturalNumber2(originalNumber);
        String numberWithCommas = redirectToMethodUnderTest(naturalNumber);

        System.out.println("Input = " + originalNumber);
        System.out.println("Output = " + numberWithCommas);

        /*
         * Assert that values of variables match expectations
         */
        // Return result can not be null
        assertTrue(numberWithCommas != null);
        assertTrue(numberWithCommas.length() > 0);
        // the value of the given NaturalNumber must be restored
        assertEquals(naturalNumber.toString(), originalNumber);
        // return value should match to expect number.
        assertEquals(numberWithCommas, expectedNumber);
    }

    /**
     * Test case with input 10001. Expected result 10,001
     */
    @Test
    public void toStringWithCommasTest3() {
        /*
         * Set up variables and call method under test
         */
        String originalNumber = "10001";
        String expectedNumber = "10,001";
        NaturalNumber naturalNumber = new NaturalNumber2(originalNumber);
        String numberWithCommas = redirectToMethodUnderTest(naturalNumber);

        System.out.println("Input = " + originalNumber);
        System.out.println("Output = " + numberWithCommas);

        /*
         * Assert that values of variables match expectations
         */
        // Return result can not be null
        assertTrue(numberWithCommas != null);
        assertTrue(numberWithCommas.length() > 0);
        // the value of the given NaturalNumber must be restored
        assertEquals(naturalNumber.toString(), originalNumber);
        // return value should match to expect number.
        assertEquals(numberWithCommas, expectedNumber);
    }

    /**
     * Test case with input 1230456. Expected result 1,230,456
     */
    @Test
    public void toStringWithCommasTest4() {
        /*
         * Set up variables and call method under test
         */
        String originalNumber = "1234567891234567";
        String expectedNumber = "1,234,567,891,234,567";
        NaturalNumber naturalNumber = new NaturalNumber2(originalNumber);
        String numberWithCommas = redirectToMethodUnderTest(naturalNumber);

        System.out.println("Input = " + originalNumber);
        System.out.println("Output = " + numberWithCommas);

        /*
         * Assert that values of variables match expectations
         */
        // Return result can not be null
        assertTrue(numberWithCommas != null);
        assertTrue(numberWithCommas.length() > 0);
        // the value of the given NaturalNumber must be restored
        assertEquals(naturalNumber.toString(), originalNumber);
        // return value should match to expect number.
        assertEquals(numberWithCommas, expectedNumber);
    }

}
