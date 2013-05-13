package com.riadh.samples.exo1;

import com.riadh.samples.BadArgumentsException;

/**
 * @author Riadh MNASRI
 * 
 */
public class CalculatorImpl implements Calculator {

    public CalculatorImpl() {
        // TODO Auto-generated constructor stub
    }

    public Integer add(Integer a, Integer b) throws BadArgumentsException {
        if (a == null || b == null) {
            throw new BadArgumentsException("Add operation could not have null arguments");
        }
        return a + b;
    }
}
