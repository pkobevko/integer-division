package ua.foxminded.integerdivision;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {

    public DivisionData divide(int dividend, int divisor) {
        validate(dividend, divisor);

        List<Integer> digitsList = calculate(dividend, divisor);
        return new DivisionData(dividend, divisor, digitsList);
    }

    public List<Integer> calculate(int dividend, int divisor) {
        String dividendString = String.valueOf(dividend);

        // define the first and second number
        int firstNumber = Integer.parseInt(dividendString.substring(0, String.valueOf(divisor).length()));
        if (divisor > firstNumber) {
            firstNumber = Integer.parseInt(dividendString.substring(0, String.valueOf(divisor).length() + 1));
        }
        int secondNumber = divisor * (firstNumber / divisor);

        // define other digits for iteration
        String otherDigits = dividendString.substring(String.valueOf(firstNumber).length());

        // define list for result digits
        ArrayList<Integer> digitsList = new ArrayList<>();
        digitsList.add(firstNumber);
        digitsList.add(secondNumber);

        int difference = firstNumber - secondNumber;

        // iteration
        for (int i = 0; i < otherDigits.length(); i++) {
            int decreasing = difference * 10 + Integer.parseInt(String.valueOf(otherDigits.charAt(i)));
            int denominator = divisor * (decreasing / divisor);
            difference = decreasing - denominator;
            digitsList.add(decreasing);
            digitsList.add(denominator);
        }

        return digitsList;
    }

    public void validate(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be zero");
        }

        if (dividend < 1 || divisor < 1) {
            throw new IllegalArgumentException("Dividend and divisor must be equal to at least 1");
        }

        if (divisor > dividend) {
            throw new IllegalArgumentException("Dividend must be bigger than divisor or equal");
        }
    }
}
