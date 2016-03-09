import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author anton
 * @date 26.02.16.
 */
public class FractionNumberTests {

    int a, b, c, d;
    @BeforeClass
    public void setUp() {
        a = (int) (Math.random() * 10);
        b = (int) (Math.random() * 10);
        c = (int) (Math.random() * 10);
        d = (int) (Math.random() * 10);
    }

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
        FractionNumber frac = new FractionNumber(1, 0);
    }
}
