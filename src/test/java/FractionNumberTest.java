import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author anton
 * @date 26.02.16.
 */
public class FractionNumberTest {

    private int a, b, c, d;
    private FractionNumOperations operations;

    //SetUp before tests
    @BeforeClass
    public void setUp() {
        a = (int) ((Math.random() + 2) * 10);
        b = (int) ((Math.random() + 2) * 10);
        c = (int) ((Math.random() + 2) * 10);
        d = (int) ((Math.random() + 2) * 10);
    }

    @BeforeTest
    public void setOperations() {
        operations = new FractionNumOperations();
    }

    //Test FractionNumber block

    @Test
    public void testDefaultFractionNumberCreation() {
        FractionNumber frac = new FractionNumber();
        Assert.assertEquals((int)frac.value(), 1, "Default fraction should be equal 1");
    }

    @Test
    public void testDefaultFractionNumberToString() {
        FractionNumber frac = new FractionNumber();
        Assert.assertEquals(frac.toStringValue(), "1", "Default fraction should be present as 1");
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testIncorrectFractionNumberCreation() {
        FractionNumber frac = new FractionNumber(a, 0);
    }

    @Test
    public void testSetDividend() {
        FractionNumber frac = new FractionNumber();
        frac.setDividend(a);
        Assert.assertEquals(frac.getDividend(), a);
    }

    @Test
    public void testSetDivisor() {
        FractionNumber frac = new FractionNumber();
        frac.setDivisor(b);
        Assert.assertEquals(frac.getDivisor(), b);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testSetDivisorAs0() {
        FractionNumber frac = new FractionNumber();
        frac.setDivisor(0);
    }

    @Test
    public void testCustomFractionNumber() {
        FractionNumber frac = new FractionNumber(a, b);
        Assert.assertEquals(frac.toStringValue(), a + "/" + b);
    }

    @Test
    public void testCustomFractionNumber_1() {
        FractionNumber frac = new FractionNumber(a, b);
        double result = (double) Math.round(((double)a / (double) b) * 100) / 100;
        Assert.assertEquals(frac.value(), result);
    }

    //Test FractionNumberOperations block

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testIncorrectSumFractionNums() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = null;
        operations.add(frac, frac_1);
    }

    @Test
    public void testSumFractionNums() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.add(frac, frac_1);
        //It looks like shit, but this is one way to check it
        double expected =(double) Math.round(((double)((a * d) + (c * b)) /(double)(b * d)) * 100) / 100;
        Assert.assertEquals(result.value(), expected);
    }

    @Test
    public void testSumFractionNumsToString() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.add(frac, frac_1);
        Assert.assertEquals(result.toStringValue(), ((a * d) + (c * b)) + "/" + (b * d));
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testIncorrectDeductFractionNums() {
        FractionNumber frac = null;
        FractionNumber frac_1 = new FractionNumber(c, d);
        operations.ded(frac, frac_1);
    }

    @Test
    public void testDeductFractionNums() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.ded(frac, frac_1);
        double expected =(double) Math.round(((double)((a * d) - (c * b)) /(double)(b * d)) * 100) / 100;
        Assert.assertEquals(result.value(), expected);
    }

    @Test
    public void testDeductFractionNumsToString() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.ded(frac, frac_1);
        Assert.assertEquals(result.toStringValue(), ((a * d) - (c * b)) + "/" + (b * d));
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testIncorrectMultiFractionNums() {
        FractionNumber frac = null;
        FractionNumber frac_1 = new FractionNumber(c, d);
        operations.mul(frac, frac_1);
    }

    @Test
    public void testMultiFractionNums() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.mul(frac, frac_1);
        double expected =(double) Math.round(((double)(a * c) /(double)(b * d)) * 100) / 100;
        Assert.assertEquals(result.value(), expected);
    }

    @Test
    public void testMultiFractionNumsToString() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.mul(frac, frac_1);
        Assert.assertEquals(result.toStringValue(), (a * c) + "/" + (b * d));
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void testIncorrectDivFractionNums() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = null;
        FractionNumber result = operations.div(frac, frac_1);
    }

    @Test
    public void testDivFractionNums() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.div(frac, frac_1);
        double expected = (double) Math.round(((double)(a * d) /(double)(b * c)) * 100) / 100;
        Assert.assertEquals(result.value(), expected);
    }

    @Test
    public void testDivFractionNumsToString() {
        FractionNumber frac = new FractionNumber(a, b);
        FractionNumber frac_1 = new FractionNumber(c, d);
        FractionNumber result = operations.div(frac, frac_1);
        Assert.assertEquals(result.toStringValue(), (a * d) + "/" + (b * c));
    }
}
