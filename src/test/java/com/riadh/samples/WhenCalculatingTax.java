/**
 * Copyright Manpower
 */
package com.riadh.samples;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WhenCalculatingTax {

    private double income;
    private double expectedTax;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0.00, 0.00 }, { 10000.00, 1250.00 }, { 14000.00, 1750.00 },
                { 14001.00, 1750.125 }, { 45000.00, 5625.00 }, { 48000.00, 6000.0 }, { 48001.00, 6000.125 },
                { 65238.00, 8154.75 }, { 70000.00, 8750.0 }, { 70001.00, 8750.125 }, { 80000.00, 10000.0 },
                { 100000.00, 12500.0 }, });
    }

    public WhenCalculatingTax(double income, double expectedTax) {
        super();
        this.income = income;
        this.expectedTax = expectedTax;
    }

    @Test
    public void shouldCalculateCorrectTax() {
        TaxCalculator calculator = new TaxCalculator();
        double calculatedTax = calculator.calculateTax(income);
        assertThat(calculatedTax, is(expectedTax));
    }
}
