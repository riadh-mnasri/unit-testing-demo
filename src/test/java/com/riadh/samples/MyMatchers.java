/**
 * Copyright Manpower
 */
package com.riadh.samples;

import java.util.Collection;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class MyMatchers {

    @Factory
    public static Matcher<Collection<? extends Object>> hasSize(Matcher<Integer> matcher) {
        return new HasSizeMatcher(matcher);
    }
}
