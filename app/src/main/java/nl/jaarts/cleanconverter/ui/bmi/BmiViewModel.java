package nl.jaarts.cleanconverter.ui.bmi;

import androidx.lifecycle.ViewModel;

import nl.jaarts.cleanconverter.calculator.BMICalculator;
import nl.jaarts.cleanconverter.model.BmiCalculationResult;

public class BmiViewModel extends ViewModel {

    public BmiCalculationResult calculateMetricBMI(double cm, double kg) {
        double bmi = BMICalculator.calculateBMI(cm, kg);

        return new BmiCalculationResult(bmi, "", "");
    }

    public BmiCalculationResult calculateImperialBMI(double ft, double in, double lb) {
        double bmi = BMICalculator.calculateBMI(ft, in, lb);

        return new BmiCalculationResult(bmi, "", "");
    }
}
