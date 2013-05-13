package com.riadh.samples.exercices.exo1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.riadh.samples.BadArgumentsException;
import com.riadh.samples.exo1.Calculator;
import com.riadh.samples.exo1.CalculatorImpl;

/**
 * @author Riadh MNASRI
 * 
 */
public class WhenPerformingAddOperation {

    private Calculator calculator;

    @Before
    public void init() throws Exception {
        calculator = new CalculatorImpl();
    }

    @After
    public void clean() throws Exception {
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
        assertThat(proccessedResult, is(equalTo(expectedResult)));
    }

    @Test
    @Ignore
    public void shouldAddOperationWithNullArgumentsThrowException() throws Exception {
        // Given ( Prepare the test data ("arrange"))
        try {
            Integer x = null;
            Integer y = new Integer(7);

            // When (Do what you are testing ("act"))
            calculator.add(x, y);

            // Then (Check the results ("assert"))
            // assertEquals(expectedResult, proccessedResult);
            fail();
        } catch (BadArgumentsException e) {
            e.printStackTrace();
            Assert.assertTrue(true);
        }

    }

    @Test(expected = BadArgumentsException.class)
    public void shouldAddOperationWithNullArgumentsThrowExceptionV2() throws Exception {
        // Given ( Prepare the test data ("arrange"))

        Integer x = null;
        Integer y = new Integer(7);

        // When (Do what you are testing ("act"))
        calculator.add(x, y);
    }
}
