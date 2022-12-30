package nl.jaarts.cleanconverter.model;

public class LengthValuesContainer {

    private double centimeters;
    private double feet;
    private double inches;
    private double kilometers;
    private double meters;
    private double miles;
    private double yards;

    public LengthValuesContainer(double centimeters, double feet, double inches, double kilometers, double meters, double miles, double yards) {
        this.centimeters = centimeters;
        this.feet = feet;
        this.inches = inches;
        this.kilometers = kilometers;
        this.meters = meters;
        this.miles = miles;
        this.yards = yards;
    }

    public double getCentimeters() {
        return centimeters;
    }

    public double getFeet() {
        return feet;
    }

    public double getInches() {
        return inches;
    }

    public double getKilometers() {
        return kilometers;
    }

    public double getMeters() {
        return meters;
    }

    public double getMiles() {
        return miles;
    }

    public double getYards() {
        return yards;
    }
}
