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
        String expected = "_78945|4\n" +
            " 4    |-----\n" +
            " -    |19736\n" +
            "_38\n" +
            " 36\n" +
            " --\n" +
            " _29\n" +
            "  28\n" +
            "  --\n" +
            "  _14\n" +
            "   12\n" +
            "   --\n" +
            "   _25\n" +
            "    24\n" +
            "    --\n" +
            "     1";

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionData divisionData = integerDivision.divide(78945, 4);
        DivisionFormatter formatter = new DivisionFormatter();
        String actual = formatter.format(divisionData);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample2() {
        String expected = "_405000450|45\n" +
            " 405      |-------\n" +
            " ---      |9000010\n" +
            "      _45\n" +
            "       45\n" +
            "       --\n" +
            "         0";

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionData divisionData = integerDivision.divide(405000450, 45);
        DivisionFormatter formatter = new DivisionFormatter();
        String actual = formatter.format(divisionData);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample3() {
        String expected = "_12345|12345\n" +
            " 12345|-\n" +
            " -----|1\n" +
            "     0";

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionData divisionData = integerDivision.divide(12345, 12345);
        DivisionFormatter formatter = new DivisionFormatter();
        String actual = formatter.format(divisionData);

        Assertions.assertEquals(expected, actual);
    }
}