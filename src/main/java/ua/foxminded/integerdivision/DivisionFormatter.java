package ua.foxminded.integerdivision;

import java.util.List;

public class DivisionFormatter {

    private static final String LINE_SEPARATOR = "\n";

    public String format(DivisionResult result) {

        String firstThreeLines = createFirstThreeLines(result);

        String otherLines = "";


        return firstThreeLines + otherLines;
    }

    public int numOfDigits(int num) {
        return String.valueOf(num).length();
    }

    public String createFirstThreeLines(DivisionResult result) {

        List<Integer> resultDigits = result.getResultDigits();
        int firstDigit = resultDigits.get(0);
        int secondDigit = resultDigits.get(0);

        String firstThreeLines = "_" + result.getDividend() + "|" + result.getDivisor() + LINE_SEPARATOR
            + " ".repeat(numOfDigits(firstDigit) - numOfDigits(secondDigit) + 1) + resultDigits.get(1) + " ".repeat(numOfDigits(result.getDividend()) - numOfDigits(firstDigit)) + "|" + "-".repeat(numOfDigits(result.getQuotient())) + LINE_SEPARATOR
            + " " + "-".repeat(numOfDigits(firstDigit)) + " ".repeat(numOfDigits(result.getDividend()) - numOfDigits(firstDigit)) + "|" + (result.getQuotient()) + LINE_SEPARATOR;
        return firstThreeLines;
    }
}
