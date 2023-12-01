import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommasTest {

    @After
    public void tearDown() throws Exception {
    }

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
        return NNtoStringWithCommas4.toStringWithCommas(n);
    }

    @Test
    public void test0toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(0);
        String test = redirectToMethodUnderTest(n);
        assertEquals("0", test);
    }

    @Test
    public void test1toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(1);
        String test = redirectToMethodUnderTest(n);
        assertEquals("1", test);
    }

    @Test
    public void test10toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(10);
        String test = redirectToMethodUnderTest(n);
        assertEquals("10", test);
    }

    @Test
    public void test100toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(100);
        String test = redirectToMethodUnderTest(n);
        assertEquals("100", test);
    }

    @Test
    public void test1000toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(1000);
        String test = redirectToMethodUnderTest(n);
        assertEquals("1,000", test);
    }

    @Test
    public void test10000toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(10000);
        String test = redirectToMethodUnderTest(n);
        assertEquals("10,000", test);
    }

    @Test
    public void test100000toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(100000);
        String test = redirectToMethodUnderTest(n);
        assertEquals("100,000", test);
    }

    @Test
    public void test1000000toStringWithCommas() {
        NaturalNumber n = new NaturalNumber2(1000000);
        String test = redirectToMethodUnderTest(n);
        assertEquals("1,000,000", test);
    }

}
