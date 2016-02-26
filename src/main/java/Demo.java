/**
 * Created by anton on 19.10.15.
 */
public class Demo {
    public static void main(String[] args) {
        FractionNumber demo1 = new FractionNumber();
        FractionNumber demo2 = new FractionNumber();
        demo2.setDividend(3);
        demo2.setDivisor(8);
        System.out.println(demo2.toStringValue());
        System.out.println(demo2.value());

        demo1.setDividend(2);
        demo1.setDivisor(12);
        System.out.println(demo1.toStringValue());
        System.out.println(demo1.value());

        FractionNumOperations operations = new FractionNumOperations();
        System.out.println(operations.add(demo1, demo2).toStringValue());
        System.out.println(operations.div(demo1, demo2).toStringValue());
        System.out.println(operations.mul(demo1, demo2).toStringValue());
        System.out.println(operations.sub(demo1, demo2).toStringValue());

        System.out.println(operations.add(demo1, demo2).value());
        System.out.println(operations.mul(demo1, demo2).value());
        System.out.println(operations.div(demo1, demo2).value());
        System.out.println(operations.sub(demo1, demo2).value());
    }
}
