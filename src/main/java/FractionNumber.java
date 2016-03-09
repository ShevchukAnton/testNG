/**
 * Created by anton on 19.10.15.
 */
public class FractionNumber {

    private int dividend;
    private int divisor;

    FractionNumber(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be 0");
        }
        this.dividend = dividend;
        this.divisor = divisor;
    }

    FractionNumber() {
        dividend = 1;
        divisor = 1;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDivisor(int divisor) throws IllegalArgumentException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be 0");
        }
        this.divisor = divisor;
    }

    public int getDivisor() {
        return divisor;
    }

    public double value() {
        double result = (double) dividend / divisor;
        return Math.rint(result * 100) / 100;
    }

    public String toStringValue() {
        if (divisor == 1) {
            return dividend + "";
        }
        return dividend + "/" + divisor;
    }
}
