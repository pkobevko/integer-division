package ua.foxminded.integerdivision;

import java.util.List;

public class DivisionResult {

    private int dividend;
    private int divisor;
    private List<Integer> resultDigits;
    private int quotient;
    private int remainder;

    public DivisionResult(int dividend, int divisor, List<Integer> resultDigits) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.resultDigits = resultDigits;
        this.quotient = dividend / divisor;
        this.remainder = dividend % divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public List<Integer> getResultDigits() {
        return resultDigits;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }
}
