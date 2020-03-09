package nl.jaarts.cleanconverter.model;

public class BmiCalculationResult {
    private double bmi;
    private String category;

    public BmiCalculationResult() {
    }

    public BmiCalculationResult(double bmi, String category) {
        this.bmi = bmi;
        this.category = category;
    }

    public double getBmi() {
        return bmi;
    }

    public String getCategory() {
        return category;
    }
}
