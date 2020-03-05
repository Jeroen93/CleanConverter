package nl.jaarts.cleanconverter.ui.temperature;

import androidx.lifecycle.ViewModel;

import nl.jaarts.cleanconverter.converter.TemperatureConverter;
import nl.jaarts.cleanconverter.enums.TemperatureUnit;
import nl.jaarts.cleanconverter.model.TemperatureValuesContainer;

public class TemperatureViewModel extends ViewModel {

    public TemperatureValuesContainer convertTemperatureValues(double sourceValue, TemperatureUnit sourceUnit) {

        TemperatureValuesContainer container;

        switch (sourceUnit) {
            case FAHRENHEIT:
                container = TemperatureConverter.convertFromFahrenheit(sourceValue);
                break;
            case CELSIUS:
                container = TemperatureConverter.convertFromCelsius(sourceValue);
                break;
            case KELVIN:
                container = TemperatureConverter.convertFromKelvin(sourceValue);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sourceUnit);
        }

        return container;
    }
}
