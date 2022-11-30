package ua.foxminded.integerdivision;

import java.util.List;

public class DivisionFormatter {

    private static final String LINE_SEPARATOR = "\n";
    private static final int NUMBER_OF_DIGITS_IN_EACH_GROUP = 2;

    public String format(DivisionData divisionData) {
        validate(divisionData);

        List<Integer> digitsList = divisionData.getDigitsList();

        StringBuilder stringBuilder = new StringBuilder("");

        int pointer = "_".length() + numOfDigits(digitsList.get(0));

        for (int i = 0; i < digitsList.size(); i += NUMBER_OF_DIGITS_IN_EACH_GROUP) {
            if (i == 0) {
                stringBuilder.append(createFirstThreeLines(divisionData));
                continue;
            }
            int firstNumber = digitsList.get(i);
            int secondNumber = digitsList.get(i + 1);

            int firstNumberOfPreviousGroup = digitsList.get(i - 2);
            int secondNumberOfPreviousGroup = digitsList.get(i - 1);

            if (secondNumber == 0) {
                pointer++;
                continue;
            }

            if (firstNumberOfPreviousGroup - secondNumberOfPreviousGroup == 0) {
                pointer++;
            }

            int numberOfSpaces = pointer - numOfDigits(firstNumberOfPreviousGroup - secondNumberOfPreviousGroup) - "_".length();

            String firstLine = spaces(numberOfSpaces) + "_" + firstNumber + LINE_SEPARATOR;
            pointer = firstLine.length() - "_".length();
            String secondLine = spaces(pointer - numOfDigits(secondNumber)) + secondNumber + LINE_SEPARATOR;
            String thirdLine = spaces(pointer - numOfDigits(firstNumber)) + hyphens(numOfDigits(firstNumber)) + LINE_SEPARATOR;

            stringBuilder.append(firstLine);
            stringBuilder.append(secondLine);
            stringBuilder.append(thirdLine);
        }

        String lastLine = spaces(pointer - numOfDigits(divisionData.getRemainder())) + divisionData.getRemainder();
        stringBuilder.append(lastLine);

        return stringBuilder.toString();
    }

    private int numOfDigits(int num) {
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

    private String createFirstThreeLines(DivisionData divisionData) {

        int firstDigit = divisionData.getDigitsList().get(0);
        int secondDigit = divisionData.getDigitsList().get(1);

        String line1 = "_" + divisionData.getDividend() + "|" + divisionData.getDivisor() + LINE_SEPARATOR;
        String line2 = spaces(numOfDigits(firstDigit) - numOfDigits(secondDigit) + "_".length()) + secondDigit + spaces(numOfDigits(divisionData.getDividend()) - numOfDigits(firstDigit)) + "|"
            + hyphens(numOfDigits(divisionData.getQuotient())) + LINE_SEPARATOR;
        String line3 = " " + hyphens(numOfDigits(firstDigit)) + spaces(numOfDigits(divisionData.getDividend()) - numOfDigits(firstDigit))
            + "|" + (divisionData.getQuotient()) + LINE_SEPARATOR;

        return line1 + line2 + line3;
    }

    private String spaces(int count) {
        return " ".repeat(count);
    }

    private String hyphens(int count) {
        return "-".repeat(count);
    }

    private void validate(DivisionData divisionData) {
        if (divisionData == null) {
            throw new IllegalArgumentException("You cannot pass null to this function");
        }
    }
}