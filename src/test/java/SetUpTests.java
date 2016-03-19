import mwdn.anton.shevchuk.FractionNumOperations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * @author anton
 * @date 16.03.16.
 */
public class SetUpTests {

    int a, b, c, d;
    FractionNumOperations operations;

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
}
