package nl.jaarts.cleanconverter.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMICalculator {

    public static double calculateBMI(double cm, double kg) {
        if (isInvalid(cm) || isInvalid(kg)) {
            return Double.NaN;
        }

        double m = cm / 100d;
        double bmi = kg / (m * m);

        return round(bmi, 1);
    }

    public static double calculateBMI(double ft, double in, double lb) {
        double totalInch = ft * 12 + in;

        if (isInvalid(totalInch) || isInvalid(lb)) {
            return Double.NaN;
        }

        double bmi = (lb / (totalInch * totalInch)) * 703;

        return round(bmi, 1);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    private static boolean isInvalid(double value) {
        return value == 0d || Double.isNaN(value);
    }
}
