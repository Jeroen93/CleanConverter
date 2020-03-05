package nl.jaarts.cleanconverter.model;

public class BmiCalculationResult {
    private double bmi;
    private String category;
    private String risk;

    public BmiCalculationResult(double bmi, String category, String risk) {
        this.bmi = bmi;
        this.category = category;
        this.risk = risk;
    }

    public double getBmi() {
        return bmi;
    }

    public String getCategory() {
        return category;
    }

    public String getRisk() {
        return risk;
    }
}
