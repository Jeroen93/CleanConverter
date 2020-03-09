package nl.jaarts.cleanconverter.ui.bmi;

import androidx.lifecycle.ViewModel;

import nl.jaarts.cleanconverter.calculator.BMICalculator;
import nl.jaarts.cleanconverter.model.BmiCalculationResult;

public class BmiViewModel extends ViewModel {

    public BmiCalculationResult calculateMetricBMI(double cm, double kg) {
        double bmi = BMICalculator.calculateBMI(cm, kg);
        String category = getCategoryForBMI(bmi);

        return new BmiCalculationResult(bmi, category);
    }

    public BmiCalculationResult calculateImperialBMI(double ft, double in, double lb) {
        double bmi = BMICalculator.calculateBMI(ft, in, lb);
        String category = getCategoryForBMI(bmi);

        return new BmiCalculationResult(bmi, category);
    }

    private String getCategoryForBMI(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal weight";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else if (bmi <= 34.9) {
            return "Moderately obese";
        } else if (bmi <= 39.9) {
            return "Severely obese";
        } else {
            return "Very severely obese";
        }
    }
}
