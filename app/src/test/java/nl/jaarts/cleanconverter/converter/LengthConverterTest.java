package nl.jaarts.cleanconverter.converter;

import org.junit.jupiter.api.Test;

import nl.jaarts.cleanconverter.model.LengthValuesContainer;

import static org.junit.jupiter.api.Assertions.*;

class LengthConverterTest {

    @Test
    void convertFromCentimeters() {
        LengthValuesContainer result = LengthConverter.convertFromCentimeters(17d);

        assertEquals(17d, result.getCentimeters());
        assertEquals(0.55774d, result.getFeet(), 0.00001d);
        assertEquals(6.69291d, result.getInches(), 0.00001d);
        assertEquals(0.00017d, result.getKilometers());
        assertEquals(0.17d, result.getMeters());
        assertEquals(1.056e-4d, result.getMiles(), 1e-7d);
        assertEquals(0.18591426, result.getYards(), 1e-8d);
    }

    @Test
    void convertFromFeet() {
        LengthValuesContainer result = LengthConverter.convertFromFeet(6d);

        assertEquals(182.8800d, result.getCentimeters(), 0.0001d);
        assertEquals(6d, result.getFeet());
        assertEquals(72d, result.getInches());
        assertEquals(0.0018288d, result.getKilometers(), 1e-6d);
        assertEquals(1.82882d, result.getMeters(), 1e-4d);
        assertEquals(6/5280d, result.getMiles());
        assertEquals(2d, result.getYards());
    }

    @Test
    void convertFromInches() {
        LengthValuesContainer result = LengthConverter.convertFromInches(633.6d);

        assertEquals(1609.344, result.getCentimeters(), 0.001d);
        assertEquals(52.8d, result.getFeet(), 0.01d);
        assertEquals(633.6d, result.getInches());
        assertEquals(0.01609d, result.getKilometers(), 1e-5d);
        assertEquals(16.0934d, result.getMeters(), 1e-4d);
        assertEquals(0.01d, result.getMiles());
        assertEquals(17.6d, result.getYards());
    }

    @Test
    void convertFromKilometers() {
        LengthValuesContainer result = LengthConverter.convertFromKilometers(234d);

        assertEquals(2.34e7d, result.getCentimeters());
        assertEquals(767716.535d, result.getFeet(), 0.001d);
        assertEquals(9212598.4251d, result.getInches(), 0.0001d);
        assertEquals(234d, result.getKilometers());
        assertEquals(2.34e5d, result.getMeters());
        assertEquals(145.4d, result.getMiles(), 0.01d);
        assertEquals(255905.5117d, result.getYards(), 0.0001d);
    }

    @Test
    void convertFromMeters() {
        LengthValuesContainer result = LengthConverter.convertFromMeters(-128d);

        assertEquals(-12800d, result.getCentimeters());
        assertEquals(-419.9475d, result.getFeet(), 0.0001d);
        assertEquals(-5039.370d, result.getInches(), 0.0001d);
        assertEquals(-0.128d, result.getKilometers());
        assertEquals(-128d, result.getMeters());
        assertEquals(-0.07953536d, result.getMiles());
        assertEquals(-139.9825d, result.getYards(), 0.00001d);
    }

    @Test
    void convertFromMiles() {
        LengthValuesContainer result = LengthConverter.convertFromMiles(6.5d);

        assertEquals(1046075.6071d, result.getCentimeters(), 0.0001d);
        assertEquals(34320d, result.getFeet());
        assertEquals(411840d, result.getInches());
        assertEquals(10.46075d, result.getKilometers(), 0.00001d);
        assertEquals(10460.7561d, result.getMeters(), 0.0001d);
        assertEquals(6.5d, result.getMiles());
        assertEquals(11440d, result.getYards());
    }

    @Test
    void convertFromYards() {
        LengthValuesContainer result = LengthConverter.convertFromYards(150d);

        assertEquals(13716d, result.getCentimeters(), 1e-5d);
        assertEquals(450d, result.getFeet());
        assertEquals(5400d, result.getInches());
        assertEquals(0.13716d, result.getKilometers(), 1e-10d);
        assertEquals(137.16d, result.getMeters(), 1e-7d);
        assertEquals(0.08522727d, result.getMiles(), 1e-8d);
        assertEquals(150d, result.getYards());
    }
}