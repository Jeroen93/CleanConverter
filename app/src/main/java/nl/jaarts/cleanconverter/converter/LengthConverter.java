package nl.jaarts.cleanconverter.converter;

import nl.jaarts.cleanconverter.model.LengthValuesContainer;

public class LengthConverter {

    private static final double FACTOR_CENTIMETER_METER = 100d;
    private static final double FACTOR_METER_KILOMETER = 1000d;
    private static final double FACTOR_METER_FOOT = 3.280839895d;
    private static final double FACTOR_METER_INCH = 39.37007874d;
    private static final double FACTOR_METER_MILE = 0.00062137d;
    private static final double FACTOR_METER_YARD = 1.093613298d;
    private static final double FACTOR_FOOT_INCH = 12d;
    private static final double FACTOR_FOOT_MILE = 5280d;
    private static final double FACTOR_FOOT_YARD = 3d;
    private static final double FACTOR_MILE_INCH = 63360d;
    private static final double FACTOR_MILE_YARD = 1760d;

    public static LengthValuesContainer convertFromCentimeters(double centimeters) {
        double feet = centimeters * (FACTOR_METER_FOOT / FACTOR_CENTIMETER_METER);
        double inches = centimeters * (FACTOR_METER_INCH / FACTOR_CENTIMETER_METER);
        double kilometers = centimeters / (FACTOR_CENTIMETER_METER * FACTOR_METER_KILOMETER);
        double meters = centimeters / FACTOR_CENTIMETER_METER;
        double miles = centimeters * (FACTOR_METER_MILE / FACTOR_CENTIMETER_METER);
        double yards = centimeters * (FACTOR_METER_YARD / FACTOR_CENTIMETER_METER);

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    public static LengthValuesContainer convertFromFeet(double feet) {
        double centimeters = feet / (FACTOR_METER_FOOT / FACTOR_CENTIMETER_METER);
        double inches = feet * FACTOR_FOOT_INCH;
        double kilometers = feet / (FACTOR_METER_FOOT * FACTOR_METER_KILOMETER);
        double meters = feet / FACTOR_METER_FOOT;
        double miles = feet / FACTOR_FOOT_MILE;
        double yards = feet / FACTOR_FOOT_YARD;

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    public static LengthValuesContainer convertFromInches(double inches) {
        double centimeters = inches / (FACTOR_METER_INCH / FACTOR_CENTIMETER_METER);
        double feet = inches / FACTOR_FOOT_INCH;
        double kilometers = inches / (FACTOR_METER_INCH * FACTOR_METER_KILOMETER);
        double meters = inches / FACTOR_METER_INCH;
        double miles = inches / FACTOR_MILE_INCH;
        double yards = inches / (FACTOR_FOOT_INCH * FACTOR_FOOT_YARD);

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    public static LengthValuesContainer convertFromKilometers(double kilometers) {
        double centimeters = kilometers * FACTOR_METER_KILOMETER * FACTOR_CENTIMETER_METER;
        double feet = kilometers * FACTOR_METER_FOOT * FACTOR_METER_KILOMETER;
        double inches = kilometers * FACTOR_METER_INCH * FACTOR_METER_KILOMETER;
        double meters = kilometers * FACTOR_METER_KILOMETER;
        double miles = kilometers * FACTOR_METER_MILE * FACTOR_METER_KILOMETER;
        double yards = kilometers * FACTOR_METER_YARD * FACTOR_METER_KILOMETER;

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    public static LengthValuesContainer convertFromMeters(double meters) {
        double centimeters = meters * FACTOR_CENTIMETER_METER;
        double feet = meters * FACTOR_METER_FOOT;
        double inches = meters * FACTOR_METER_INCH;
        double kilometers = meters / FACTOR_METER_KILOMETER;
        double miles = meters * FACTOR_METER_MILE;
        double yards = meters * FACTOR_METER_YARD;

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    public static LengthValuesContainer convertFromMiles(double miles) {
        double centimeters = miles / (FACTOR_METER_MILE / FACTOR_CENTIMETER_METER);
        double feet = miles * FACTOR_FOOT_MILE;
        double inches = miles * FACTOR_MILE_INCH;
        double kilometers = miles / (FACTOR_METER_MILE * FACTOR_METER_KILOMETER);
        double meters = miles / FACTOR_METER_MILE;
        double yards = miles * FACTOR_MILE_YARD;

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    public static LengthValuesContainer convertFromYards(double yards) {
        double centimeters = yards / (FACTOR_METER_YARD / FACTOR_CENTIMETER_METER);
        double feet = yards * FACTOR_FOOT_YARD;
        double inches = yards * FACTOR_FOOT_YARD * FACTOR_FOOT_INCH;
        double kilometers = yards / (FACTOR_METER_YARD * FACTOR_METER_KILOMETER);
        double meters = yards / FACTOR_METER_YARD;
        double miles = yards / FACTOR_MILE_YARD;

        return new LengthValuesContainer(centimeters, feet, inches, kilometers, meters, miles, yards);
    }

    private LengthConverter() {
        // Don't instantiate me
    }
}
