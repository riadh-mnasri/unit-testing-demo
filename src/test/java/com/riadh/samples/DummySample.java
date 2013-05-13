/**
 * Copyright Manpower
 */
package com.riadh.samples;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DummySample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldColorBeBlue() throws Exception {
        String color = "blue";// red
        assertThat(color, is("blue"));
    }

    @Test
    public void shouldColorBeYellow() throws Exception {
        String[] colors = new String[] { "red", "green", "blue" };
        String color = "yellow";
        assertThat(color, not(isIn(colors)));
    }

    @Test
    public void shouldColorBeManyPossibilities() throws Exception {
        String color = "red";
        assertThat(color, isOneOf("red", "blue", "green"));

        List<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        assertThat(colors, hasItem("blue"));
        assertThat(colors, hasItems("red", "green"));
        assertThat(colors, hasItem(anyOf(is("red"), is("green"), is("blue"))));
    }

    @Test
    public void shouldBeTheSamePerson() {
        Person me = new Person("Riadh");
        Person theOther = new Person("Riadh");
        assertThat(me, is(theOther));
    }

    @Test
    public void shouldBeTheSamePersonV2() {
        Person me = new Person("Riadh");
        Person theOther = new Person("Riadh");
        assertThat(me, equalTo(theOther));
    }

    @Test
    public void shouldHaveFixedSizeNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(numbers.size(), is(equalTo(5)));
    }

    @Test
    public void shouldHaveOnlyEvenNumbers() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        assertThat(numbers, is(AreEvenNumbers.evenNumbers()));
    }

    @Test
    public void shouldNotHaveOddNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 8, 10);
        assertThat(numbers, not(AreEvenNumbers.evenNumbers()));
    }
}
