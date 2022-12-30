package nl.jaarts.cleanconverter.model;

public class WeightValuesContainer {

    private double grams;
    private double kilograms;
    private double stones;
    private double pounds;
    private double ounces;

    public WeightValuesContainer(double grams, double kilograms, double stones, double pounds, double ounces) {
        this.grams = grams;
        this.kilograms = kilograms;
        this.stones = stones;
        this.pounds = pounds;
        this.ounces = ounces;
    }

    public double getGrams() {
        return grams;
    }

    public double getKilograms() {
        return kilograms;
    }

    public double getStones() {
        return stones;
    }

    public double getPounds() {
        return pounds;
    }

    public double getOunces() {
        return ounces;
    }
}
