package nl.jaarts.cleanconverter.ui.bmi;

import androidx.lifecycle.ViewModel;

import nl.jaarts.cleanconverter.R;
import nl.jaarts.cleanconverter.calculator.BMICalculator;
import nl.jaarts.cleanconverter.model.BmiCalculationResult;
import nl.jaarts.cleanconverter.util.ResourceProvider;

public class BmiViewModel extends ViewModel {

    private ResourceProvider resourceProvider;

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
            return resourceProvider.getString(R.string.lblUnderweight);
        } else if (bmi <= 24.9) {
            return resourceProvider.getString(R.string.lblNormalWeight);
        } else if (bmi <= 29.9) {
            return resourceProvider.getString(R.string.lblOverweight);
        } else if (bmi <= 34.9) {
            return resourceProvider.getString(R.string.lblModeratelyObese);
        } else if (bmi <= 39.9) {
            return resourceProvider.getString(R.string.lblSeverelyObese);
        } else {
            return resourceProvider.getString(R.string.lblVerySeverelyObese);
        }
    }

    public void setResourceProvider(ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }
}
