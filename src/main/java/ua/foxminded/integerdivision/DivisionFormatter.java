package ua.foxminded.integerdivision;

import java.util.List;

public class DivisionFormatter {

    private static final String LINE_SEPARATOR = "\n";

    public String format(DivisionData divisionData) {
        validate(divisionData);

        List<Integer> digitsList = divisionData.getDigitsList();

        StringBuilder otherLines = new StringBuilder("");

        int pointer = "_".length() + numOfDigits(digitsList.get(0));

        for (int i = 2; i < digitsList.size(); i += 2) {
            int firstNumber = digitsList.get(i);
            int secondNumber = digitsList.get(i + 1);

            if (secondNumber == 0) {
                pointer++;
                continue;
            }

            if (digitsList.get(i - 2) - digitsList.get(i - 1) == 0) {
                pointer++;
            }

            int numberOfSpaces = pointer - numOfDigits(digitsList.get(i - 2) - digitsList.get(i - 1)) - "_".length();

            String firstLine = spaces(numberOfSpaces) + "_" + firstNumber + LINE_SEPARATOR;
            pointer = firstLine.length() - "_".length();
            String secondLine = spaces(pointer - numOfDigits(secondNumber)) + secondNumber + LINE_SEPARATOR;
            String thirdLine = spaces(pointer - numOfDigits(firstNumber)) + hyphens(numOfDigits(firstNumber)) + LINE_SEPARATOR;

            otherLines.append(firstLine);
            otherLines.append(secondLine);
            otherLines.append(thirdLine);
        }

        String lastLine = spaces(pointer - numOfDigits(divisionData.getRemainder())) + divisionData.getRemainder();

        return createFirstThreeLines(divisionData) + otherLines + lastLine;
    }

    public int numOfDigits(int num) {
        if (num == 0) {
            return 1;
        }

        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public String createFirstThreeLines(DivisionData divisionData) {

        int firstDigit = divisionData.getDigitsList().get(0);
        int secondDigit = divisionData.getDigitsList().get(1);

        String line1 = "_" + divisionData.getDividend() + "|" + divisionData.getDivisor() + LINE_SEPARATOR;
        String line2 = spaces(numOfDigits(firstDigit) - numOfDigits(secondDigit) + 1) + secondDigit + spaces(numOfDigits(divisionData.getDividend()) - numOfDigits(firstDigit)) + "|"
            + hyphens(numOfDigits(divisionData.getQuotient())) + LINE_SEPARATOR;
        String line3 = " " + hyphens(numOfDigits(firstDigit)) + spaces(numOfDigits(divisionData.getDividend()) - numOfDigits(firstDigit))
            + "|" + (divisionData.getQuotient()) + LINE_SEPARATOR;

        return line1 + line2 + line3;
    }

    public String spaces(int count) {
        return " ".repeat(count);
    }

    public String hyphens(int count) {
        return "-".repeat(count);
    }

    public void validate(DivisionData divisionData) {
        if (divisionData == null) {
            throw new IllegalArgumentException("You cannot pass null to this function");
        }
    }
}