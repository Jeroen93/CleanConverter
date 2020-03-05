package nl.jaarts.cleanconverter.converter;

import nl.jaarts.cleanconverter.model.WeightValuesContainer;

public class WeightConverter {

    private static final double FACTOR_GRAM_KILOGRAM = 1000d;
    private static final double FACTOR_KILOGRAM_STONE = 6.35029318d;
    private static final double FACTOR_KILOGRAM_POUND = 0.45359237d;
    private static final double FACTOR_KILOGRAM_OUNCE = 0.02834952d;
    private static final double FACTOR_POUND_STONE = 14d;
    private static final double FACTOR_OUNCE_POUND = 16d;

    public static WeightValuesContainer convertFromGram(double gram) {
        double kilogram = gram / FACTOR_GRAM_KILOGRAM;
        double stones = gram / (FACTOR_KILOGRAM_STONE * FACTOR_GRAM_KILOGRAM);
        double pounds = gram / (FACTOR_KILOGRAM_POUND * FACTOR_GRAM_KILOGRAM);
        double ounces = gram / (FACTOR_KILOGRAM_OUNCE * FACTOR_GRAM_KILOGRAM);

        return new WeightValuesContainer(gram, kilogram, stones, pounds, ounces);
    }

    public static WeightValuesContainer convertFromKilogram(double kilogram) {
        double gram = kilogram * FACTOR_GRAM_KILOGRAM;
        double stones = kilogram / FACTOR_KILOGRAM_STONE;
        double pounds = kilogram / FACTOR_KILOGRAM_POUND;
        double ounces = kilogram / FACTOR_KILOGRAM_OUNCE;

        return new WeightValuesContainer(gram, kilogram, stones, pounds, ounces);
    }

    public static WeightValuesContainer convertFromStones(double stones) {
        double gram = stones * FACTOR_KILOGRAM_STONE * FACTOR_GRAM_KILOGRAM;
        double kilogram = stones * FACTOR_KILOGRAM_STONE;
        double pounds = stones * FACTOR_POUND_STONE;
        double ounces = stones * FACTOR_POUND_STONE * FACTOR_OUNCE_POUND;

        return new WeightValuesContainer(gram, kilogram, stones, pounds, ounces);
    }

    public static WeightValuesContainer convertFromPounds(double pounds) {
        double gram = pounds * FACTOR_KILOGRAM_POUND * FACTOR_GRAM_KILOGRAM;
        double kilogram = pounds * FACTOR_KILOGRAM_POUND;
        double stones = pounds / FACTOR_POUND_STONE;
        double ounces = pounds * FACTOR_OUNCE_POUND;

        return new WeightValuesContainer(gram, kilogram, stones, pounds, ounces);
    }

    public static WeightValuesContainer convertFromOunces(double ounces) {
        double gram = ounces * FACTOR_KILOGRAM_OUNCE * FACTOR_GRAM_KILOGRAM;
        double kilogram = ounces * FACTOR_KILOGRAM_OUNCE;
        double stones = ounces / (FACTOR_POUND_STONE * FACTOR_OUNCE_POUND);
        double pounds = ounces / FACTOR_OUNCE_POUND;

        return new WeightValuesContainer(gram, kilogram, stones, pounds, ounces);
    }

    private WeightConverter() {
        // Don't instantiate me
    }
}
