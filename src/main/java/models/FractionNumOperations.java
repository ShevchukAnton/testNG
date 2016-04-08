package models;

/**
 * Created by anton on 19.10.15.
 */
public class FractionNumOperations {

    public FractionNumOperations() {

    }

    public FractionNumber add(FractionNumber a, FractionNumber b) throws IllegalArgumentException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments Can't be null");
        }
        int dividend = (a.getDividend() * b.getDivisor()) + (b.getDividend() * a.getDivisor());
        int divisor = (a.getDivisor() * b.getDivisor());
        return new FractionNumber(dividend, divisor);
    }

    public FractionNumber ded(FractionNumber a, FractionNumber b) throws IllegalArgumentException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments Can't be null");
        }
        int dividend = (a.getDividend() * b.getDivisor()) - (b.getDividend() * a.getDivisor());
        int divisor = (a.getDivisor() * b.getDivisor());

        return new FractionNumber(dividend, divisor);
    }

    public FractionNumber mul(FractionNumber a, FractionNumber b) throws IllegalArgumentException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments Can't be null");
        }
        int dividend = a.getDividend() * b.getDividend();
        int divisor = a.getDivisor() * b.getDivisor();
        return new FractionNumber(dividend, divisor);
    }

    public FractionNumber div(FractionNumber a, FractionNumber b) throws IllegalArgumentException, ArithmeticException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments Can't be null");
        }
        int divisor = a.getDivisor() * b.getDividend();
        if (divisor == 0) {
            throw new ArithmeticException("Divisor can't be 0");
        }
        int dividend = a.getDividend() * b.getDivisor();
        return new FractionNumber(dividend, divisor);
    }
}
