package nl.jaarts.cleanconverter.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DoubleUtilTest {

    @Test
    void round_NegativePlace_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                DoubleUtil.round(0, -1);
            }
        });
    }

    @ParameterizedTest
    @CsvSource({
            "19.399282,     1, 19.4",
            "-30.678,       2, -30.68",
            "0.03,          6, 0.03",
            "106.44493812,  2, 106.44"
    })
    void round_DoubleValues_ReturnsDoubleValueWithPlace(double input, int place, double expected) {
        double result = DoubleUtil.round(input, place);

        assertEquals(expected, result);
    }
}