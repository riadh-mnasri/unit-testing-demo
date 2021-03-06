package com.riadh.samples;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.riadh.samples.exo2.RegExpValidator;

/**
 * @author Riadh MNASRI
 * 
 */
public class WhenValidatingStringBehindARegularExpression {

    private RegExpValidator regExpValidator;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        regExpValidator = new RegExpValidator();
    }

    @After
    public void tearDown() throws Exception {
        regExpValidator = null;
    }

    @Test
    public void shouldRegExpValidationOperationWorkProperly() throws Exception {
        // Given ( Prepare the test data ("arrange"))
        regExpValidator.setRegexp("[a-zA-Z][0-9]");
        regExpValidator.setText("Test1234");

        // When (Do what you are testing ("act"))
        boolean isMatching = regExpValidator.getMatcher().find();

        // Then (Check the results ("assert"))
        // assertEquals(expectedResult, proccessedResult);
        Assert.assertTrue("The string provided doesn't match the regular expression", isMatching);
    }

    @Test
    public void shouldRegExpValidationOperationThrowExceptionWhenNullArguments() throws Exception {
        // Given ( Prepare the test data ("arrange"))
        regExpValidator.setRegexp("[a-zA-Z][0-9]");
        regExpValidator.setText("Test1234");

        // When (Do what you are testing ("act"))
        boolean isMatching = regExpValidator.getMatcher().find();

        // Then (Check the results ("assert"))
        // assertEquals(expectedResult, proccessedResult);
        Assert.assertTrue("The string provided doesn't match the regular expression", isMatching);
    }
}
