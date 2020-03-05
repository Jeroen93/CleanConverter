package nl.jaarts.cleanconverter.ui.length;

import androidx.lifecycle.ViewModel;

import nl.jaarts.cleanconverter.converter.LengthConverter;
import nl.jaarts.cleanconverter.enums.LengthUnit;
import nl.jaarts.cleanconverter.model.LengthValuesContainer;

public class LengthViewModel extends ViewModel {

    public LengthValuesContainer convertLengthValues(double sourceValue, LengthUnit sourceUnit) {
        LengthValuesContainer container;

        switch (sourceUnit) {

            case CENTIMETERS:
                container = LengthConverter.convertFromCentimeters(sourceValue);
                break;
            case FEET:
                container = LengthConverter.convertFromFeet(sourceValue);
                break;
            case INCHES:
                container = LengthConverter.convertFromInches(sourceValue);
                break;
            case KILOMETERS:
                container = LengthConverter.convertFromKilometers(sourceValue);
                break;
            case METERS:
                container = LengthConverter.convertFromMeters(sourceValue);
                break;
            case MILES:
                container = LengthConverter.convertFromMiles(sourceValue);
                break;
            case YARDS:
                container = LengthConverter.convertFromYards(sourceValue);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sourceUnit);
        }

        return container;
    }
}
