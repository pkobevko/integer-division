package ua.foxminded.integerdivision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class IntegerDivisionTest {

    IntegerDivision integerDivision = new IntegerDivision();

    @Test
    void divide_shouldThrowIllegalArgumentException_whenDivisorIsZero() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                integerDivision.divide(111111, 0);
            });

        String expectedMessage = "Divisor can't be zero";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void divide_shouldThrowIllegalArgumentException_whenDivisorBiggerThanDividend() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                integerDivision.divide(12345, 123456);
            });

        String expectedMessage = "Dividend must be bigger than divisor or equal";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void divide_shouldThrowIllegalArgumentException_whenDivisorLessThanOne() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                integerDivision.divide(100, -1);
            });

        String expectedMessage = "Dividend and divisor must be equal to at least 1";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void divide_shouldThrowIllegalArgumentException_whenDividendLessThanOne() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                integerDivision.divide(-1, 100);
            });

        String expectedMessage = "Dividend and divisor must be equal to at least 1";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void divide_shouldThrowIllegalArgumentException_whenPassingNull() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                integerDivision.divide(111111, 0);
            });

        String expectedMessage = "Divisor can't be zero";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void divide_shouldReturnDivisionDataObjectWithCorrectDigitsList_whenExample1() {
        List<Integer> digitsListExpected = Arrays.asList(7, 4, 38, 36, 29, 28, 14, 12, 25, 24);

        DivisionData divisionDataActual = integerDivision.divide(78945, 4);
        List<Integer> digitsListActual = divisionDataActual.getDigitsList();

        Assertions.assertTrue(digitsListExpected.equals(digitsListActual));
    }

    @Test
    void divide_shouldReturnDivisionDataObjectWithCorrectDigitsList_whenExample2() {
        List<Integer> digitsListExpected = Arrays.asList(38, 21, 177, 168, 92, 84, 81, 63, 183, 168, 155, 147);

        DivisionData divisionDataActual = integerDivision.divide(3872135, 21);
        List<Integer> digitsListActual = divisionDataActual.getDigitsList();

        Assertions.assertTrue(digitsListExpected.equals(digitsListActual));
    }

    @Test
    void divide_shouldReturnDivisionDataObjectWithCorrectDigitsList_whenNumOfDigitsOfFirstElementDigitsListBiggerThanDivisorNumOfDigits() {
        List<Integer> digitsListExpected = Arrays.asList(12, 7, 53, 49, 44, 42, 25, 21);

        DivisionData divisionDataActual = integerDivision.divide(12345, 7);
        List<Integer> digitsListActual = divisionDataActual.getDigitsList();

        Assertions.assertTrue(digitsListExpected.equals(digitsListActual));
    }
}