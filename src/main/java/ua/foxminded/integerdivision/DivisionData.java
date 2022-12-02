package ua.foxminded.integerdivision;

import java.util.List;

public class DivisionData {

    private int dividend;
    private int divisor;
    private List<Integer> digitsList;
    private int quotient;
    private int remainder;

    public DivisionData(int dividend, int divisor, List<Integer> digitsList) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.digitsList = digitsList;
        this.quotient = dividend / divisor;
        this.remainder = dividend % divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public List<Integer> getDigitsList() {
        return digitsList;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }
}
