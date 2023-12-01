import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Yoyi Liao
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    //boundary: if n and m are both 0
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
    //routine test case
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
    //challenge: if a parameter is zero
    public void testReduceToGCD_2_0() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    //challenge: if both of the parameter is prime
    public void testReduceToGCD_7_3() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(3);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    //challenge: if they have no common divider other than 1
    public void testReduceToGCD_49_3() {
        NaturalNumber n = new NaturalNumber2(49);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(3);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    //boundary: if n is 0
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    //boundary: if n is 1
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    //routine: if n is 2
    public void testIsEven_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    //routine: if n is 10
    public void testIsEven_10() {
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber nExpected = new NaturalNumber2(10);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    //routine: if n is 11
    public void testIsEven_11() {
        NaturalNumber n = new NaturalNumber2(11);
        NaturalNumber nExpected = new NaturalNumber2(11);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    //challenge: if n is a large odd number
    public void testIsEven_1234567881() {
        NaturalNumber n = new NaturalNumber2(1234567881);
        NaturalNumber nExpected = new NaturalNumber2(1234567881);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    //challenge: if n is a large even number
    public void testIsEven_1234567882() {
        NaturalNumber n = new NaturalNumber2(1234567882);
        NaturalNumber nExpected = new NaturalNumber2(1234567882);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    //Boundary: tests a number raised to 0 which should be itself and its remainder when divided by 2.

    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber pExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    //routine
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
    //Challenge: tests a number raised to 1 which should be itself and its remainder when divided by 2.
    public void testPowerMod_54_1_2() {
        NaturalNumber n = new NaturalNumber2(54);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(1);
        NaturalNumber pExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    @Test
    //routine: w is not a witness of n
    public void isWitnessToCompositeness_3_5() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber wExpected = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(5);
        NaturalNumber nExpected = new NaturalNumber2(5);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    //routine: w is a witness of n
    public void isWitnessToCompositeness_3_6() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber wExpected = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(6);
        NaturalNumber nExpected = new NaturalNumber2(6);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    //routine: w is a witness of n
    public void isWitnessToCompositeness_11_121() {
        NaturalNumber w = new NaturalNumber2(11);
        NaturalNumber wExpected = new NaturalNumber2(11);
        NaturalNumber n = new NaturalNumber2(121);
        NaturalNumber nExpected = new NaturalNumber2(121);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    @Test
    //boundary: 2 is a prime but it's also an even number
    public void isPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(result, true);
    }

    @Test
    //routine
    public void isPrime2_5() {
        NaturalNumber n = new NaturalNumber2(5);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(result, true);
    }

    @Test
    //routine
    public void isPrime2_8() {
        NaturalNumber n = new NaturalNumber2(8);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(result, false);
    }

    @Test
    //routine
    public void isPrime2_19() {
        NaturalNumber n = new NaturalNumber2(19);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(result, true);
    }

    @Test
    //challenge: 21 is an odd number but it's not prime
    public void isPrime2_21() {
        NaturalNumber n = new NaturalNumber2(21);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(result, false);
    }

    @Test
    //challenge: 121 is an odd number but it's not prime
    public void isPrime2_121() {
        NaturalNumber n = new NaturalNumber2(121);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals(result, false);
    }

}