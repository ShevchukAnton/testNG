import mwdn.anton.shevchuk.FractionNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author anton
 * @date 26.02.16.
 */
public class FractionNumberTest extends SetUpTests{

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
