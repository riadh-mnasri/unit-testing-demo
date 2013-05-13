/**
 * Copyright Manpower
 */
package com.riadh.samples;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.riadh.samples.exo1.Calculator;
import com.riadh.samples.exo1.CalculatorImpl;

public class WhenDoingCalculatingOperations {

    private Calculator calculator;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        calculator = new CalculatorImpl();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void shouldAddOperationWorkProperly() throws Exception {
        // Given ( Prepare the test data ("arrange"))
        Integer x = new Integer(5);
        Integer y = new Integer(7);
        Integer expectedResult = new Integer(12);

        // When (Do what you are testing ("act"))
        Integer proccessedResult = calculator.add(x, y);

        // Then (Check the results ("assert"))
        // assertEquals(expectedResult, proccessedResult);
        assertThat(proccessedResult, is(expectedResult));
    }
}
