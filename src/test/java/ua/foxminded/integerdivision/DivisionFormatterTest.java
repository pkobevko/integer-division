package ua.foxminded.integerdivision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {

    @Test
    void format_shouldThrowIllegalArgumentException_whenPassingNull() {
        DivisionFormatter formatter = new DivisionFormatter();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                formatter.format(null);
            });

        String expectedMessage = "You cannot pass null to this function";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample1() {
        String expected = """
            _78945|4
             4    |-----
             -    |19736
            _38
             36
             --
             _29
              28
              --
              _14
               12
               --
               _25
                24
                --
                 1""";

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionData divisionData = integerDivision.divide(78945, 4);
        DivisionFormatter formatter = new DivisionFormatter();
        String actual = formatter.format(divisionData);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample2() {
        String expected = """
            _405000450|45
             405      |-------
             ---      |9000010
                  _45
                   45
                   --
                     0""";

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionData divisionData = integerDivision.divide(405000450, 45);
        DivisionFormatter formatter = new DivisionFormatter();
        String actual = formatter.format(divisionData);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample3() {
        String expected = """
            _12345|12345
             12345|-
             -----|1
                 0""";

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionData divisionData = integerDivision.divide(12345, 12345);
        DivisionFormatter formatter = new DivisionFormatter();
        String actual = formatter.format(divisionData);

        Assertions.assertEquals(expected, actual);
    }
}