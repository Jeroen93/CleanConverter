package nl.jaarts.cleanconverter.converter;

import org.junit.jupiter.api.Test;

import nl.jaarts.cleanconverter.model.WeightValuesContainer;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {

    @Test
    void convertFromGram() {
        WeightValuesContainer result = WeightConverter.convertFromGram(1250d);

        assertEquals(1250d, result.getGrams());
        assertEquals(1.25d, result.getKilograms());
        assertEquals(0.19684d, result.getStones(), 1e-5d);
        assertEquals(2.755778d, result.getPounds(), 1e-5d);
        assertEquals(44.09245d, result.getOunces(), 1e-5d);
    }

    @Test
    void convertFromKilograms() {
        WeightValuesContainer result = WeightConverter.convertFromKilogram(600d);

        assertEquals(600000d, result.getGrams());
        assertEquals(600d, result.getKilograms());
        assertEquals(94.48383d, result.getStones(), 1e-5d);
        assertEquals(1322.774d, result.getPounds(), 0.001d);
        assertEquals(21164.38d, result.getOunces(), 0.01d);
    }

    @Test
    void convertFromStones() {
        WeightValuesContainer result = WeightConverter.convertFromStones(100d);

        assertEquals(635029.318d, result.getGrams());
        assertEquals(635.029318d, result.getKilograms());
        assertEquals(100d, result.getStones());
        assertEquals(1400d, result.getPounds());
        assertEquals(22400d, result.getOunces());
    }

    @Test
    void convertFromPounds() {
        WeightValuesContainer result = WeightConverter.convertFromPounds(-69.5d);

        assertEquals(-31524.67d, result.getGrams(), 0.01d);
        assertEquals(-31.52467d, result.getKilograms(), 1e-5d);
        assertEquals(-4.964286d, result.getStones(), 1e-6d);
        assertEquals(-69.5d, result.getPounds());
        assertEquals(-1112d, result.getOunces());
    }

    @Test
    void convertFromOunces() {
        WeightValuesContainer result = WeightConverter.convertFromOunces(21.3d);

        assertEquals(603.8448d, result.getGrams(), 0.001d);
        assertEquals(0.6038d, result.getKilograms(), 1e-4d);
        assertEquals(0.09508d, result.getStones(), 1e-5d);
        assertEquals(1.33125d, result.getPounds());
        assertEquals(21.3d, result.getOunces());
    }

}