package nl.jaarts.cleanconverter.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void calculateBMI_MetricZeroWeight_ReturnsNaN() {
        double result = BMICalculator.calculateBMI(1, 0);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void calculateBMI_MetricZeroLength_ReturnsNaN() {
        double result = BMICalculator.calculateBMI(0, 1);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void calculateBMI_MetricZeroLengthAndWeight_ReturnsNaN() {
        double result = BMICalculator.calculateBMI(0, 0);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void calculateBMI_Metric_ReturnsBMI() {
        double result = BMICalculator.calculateBMI(172, 57);

        assertEquals(19.3d, result);
    }

    @Test
    void calculateBMI_ImperialZeroWeight_ReturnsNaN() {
        double result = BMICalculator.calculateBMI(1, 1, 0);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void calculateBMI_ImperialZeroLength_ReturnsNaN() {
        double result = BMICalculator.calculateBMI(0, 0, 1);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void calculateBMI_ImperialZeroLengthAndWeight_ReturnsNaN() {
        double result = BMICalculator.calculateBMI(0, 0, 0);

        assertTrue(Double.isNaN(result));
    }

    @Test
    void calculateBMI_Imperial_ReturnsBMI() {
        double result = BMICalculator.calculateBMI(5, 6.5, 152);

        assertEquals(24.2d, result);
    }

}