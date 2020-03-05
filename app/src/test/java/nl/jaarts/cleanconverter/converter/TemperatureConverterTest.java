package nl.jaarts.cleanconverter.converter;

import org.junit.jupiter.api.Test;

import nl.jaarts.cleanconverter.model.TemperatureValuesContainer;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void convertFromFahrenheit() {
        TemperatureValuesContainer result = TemperatureConverter.convertFromFahrenheit(100d);

        assertEquals(37.778d, result.getCelsius(), 0.001d);
        assertEquals(100d, result.getFahrenheit());
        assertEquals(310.93d, result.getKelvin(), 0.01d);
    }

    @Test
    void convertFromCelsius() {
        TemperatureValuesContainer result = TemperatureConverter.convertFromCelsius(250d);

        assertEquals(250d, result.getCelsius());
        assertEquals(482d, result.getFahrenheit());
        assertEquals(523.15d, result.getKelvin());
    }

    @Test
    void convertFromKelvin() {
        TemperatureValuesContainer result = TemperatureConverter.convertFromKelvin(113d);

        assertEquals(-160.15d, result.getCelsius(), 0.01d);
        assertEquals(-256.27, result.getFahrenheit());
        assertEquals(113d, result.getKelvin());
    }
}