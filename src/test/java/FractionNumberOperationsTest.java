import models.FractionNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author anton
 * @date 16.03.16.
 */
public class FractionNumberOperationsTest extends SetUpTests{

    @Test
    public void testDefaultFractionNumberCreation() {
        FractionNumber frac = new FractionNumber();
        Assert.assertEquals((int)frac.value(), 1);
    }

    @Test
    public void testDefaultFractionNumberToString() {
        FractionNumber frac = new FractionNumber();
        Assert.assertEquals(frac.toStringValue(), "1");
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
}
