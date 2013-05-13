package com.riadh.samples;

public class TaxCalculator {

    private static final double RATE = 0.125;

    public double calculateTax(double income) {
        return income * RATE;
    }
}
