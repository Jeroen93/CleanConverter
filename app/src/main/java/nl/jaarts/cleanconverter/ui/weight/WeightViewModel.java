package nl.jaarts.cleanconverter.ui.weight;

import androidx.lifecycle.ViewModel;

import nl.jaarts.cleanconverter.enums.WeightUnit;
import nl.jaarts.cleanconverter.model.WeightValuesContainer;
import nl.jaarts.cleanconverter.converter.WeightConverter;

public class WeightViewModel extends ViewModel {

    WeightValuesContainer convertWeightValues(double sourceValue, WeightUnit sourceUnit) {

        WeightValuesContainer container;

        switch (sourceUnit) {
            case GRAM:
                container = WeightConverter.convertFromGram(sourceValue);
                break;
            case KILOGRAM:
                container = WeightConverter.convertFromKilogram(sourceValue);
                break;
            case STONES:
                container = WeightConverter.convertFromStones(sourceValue);
                break;
            case POUNDS:
                container = WeightConverter.convertFromPounds(sourceValue);
                break;
            case OUNCES:
                container = WeightConverter.convertFromOunces(sourceValue);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sourceUnit);
        }

        return container;
    }
}
