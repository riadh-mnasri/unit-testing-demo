package com.riadh.samples;

import static com.riadh.samples.MyMatchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WhenIUseMyCustomHamcrestMatchers {

    @Test
    public void thehasSizeMatcherShouldMatchACollectionWithExpectedSize() {
        List<String> items = new ArrayList<String>();
        items.add("java");
        assertThat("List size should be equal to 1 !", items, hasSize(is(new Integer(1))));
    }

}
