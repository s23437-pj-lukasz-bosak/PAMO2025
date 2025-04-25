package com.example.myapplication;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test jednostkowy dla obliczania BMI.
 */
public class BmiCalculatorTest {

    /**
     * Pomocnicza metoda do obliczenia BMI.
     *
     * @param weight waga w kg
     * @param height wzrost w cm
     * @return BMI jako float
     */
    private float calculateBMI(float weight, float height) {
        float heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }

    @Test
    public void testNormalBMI() {
        float bmi = calculateBMI(70f, 175f); // ≈ 22.86
        assertEquals(22.86f, bmi, 0.01f);
    }

    @Test
    public void testUnderweightBMI() {
        float bmi = calculateBMI(45f, 165f); // ≈ 16.53
        assertTrue(bmi < 18.5f);
    }

    @Test
    public void testOverweightBMI() {
        float bmi = calculateBMI(80f, 170f); // ≈ 27.68
        assertTrue(bmi > 25f && bmi < 30f);
    }

    @Test
    public void testObesityBMI() {
        float bmi = calculateBMI(105f, 170f); // ≈ 36.33
        assertTrue(bmi >= 30f);
    }
}
