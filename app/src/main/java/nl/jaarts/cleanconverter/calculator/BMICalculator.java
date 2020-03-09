package nl.jaarts.cleanconverter.calculator;

import nl.jaarts.cleanconverter.util.DoubleUtil;

public class BMICalculator {

    public static double calculateBMI(double cm, double kg) {
        if (isInvalid(cm) || isInvalid(kg)) {
            return Double.NaN;
        }

        double m = cm / 100d;
        double bmi = kg / (m * m);

        return DoubleUtil.round(bmi, 1);
    }

    public static double calculateBMI(double ft, double in, double lb) {
        double totalInch = ft * 12 + in;

        if (isInvalid(totalInch) || isInvalid(lb)) {
            return Double.NaN;
        }

        double bmi = (lb / (totalInch * totalInch)) * 703;

        return DoubleUtil.round(bmi, 1);
    }

    private static boolean isInvalid(double value) {
        return value == 0d || Double.isNaN(value);
    }
}
