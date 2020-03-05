package nl.jaarts.cleanconverter.converter;

import nl.jaarts.cleanconverter.model.TemperatureValuesContainer;

public class TemperatureConverter {

    private static final double OFFSET_CELSIUS_KELVIN = 273.15d;
    private static final double OFFSET_CELSIUS_FAHRENHEIT = 32d;
    private static final double OFFSET_KELVIN_FAHRENHEIT = 459.67d;
    private static final double FACTOR_FAHRENHEIT = 1.8d;

    public static TemperatureValuesContainer convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - OFFSET_CELSIUS_FAHRENHEIT) / FACTOR_FAHRENHEIT;
        double kelvin = (fahrenheit + OFFSET_KELVIN_FAHRENHEIT) / FACTOR_FAHRENHEIT;

        return new TemperatureValuesContainer(fahrenheit, celsius, kelvin);
    }

    public static TemperatureValuesContainer convertFromCelsius(double celsius) {
        double fahrenheit = celsius * FACTOR_FAHRENHEIT + OFFSET_CELSIUS_FAHRENHEIT;
        double kelvin = celsius + OFFSET_CELSIUS_KELVIN;

        return new TemperatureValuesContainer(fahrenheit, celsius, kelvin);
    }

    public static TemperatureValuesContainer convertFromKelvin(double kelvin) {
        double celsius = kelvin - OFFSET_CELSIUS_KELVIN;
        double fahrenheit = kelvin * FACTOR_FAHRENHEIT - OFFSET_KELVIN_FAHRENHEIT;

        return new TemperatureValuesContainer(fahrenheit, celsius, kelvin);
    }

    private TemperatureConverter() {
        // Don't instantiate me
    }
}
