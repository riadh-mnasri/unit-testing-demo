package com.riadh.samples.exo1;

import com.riadh.samples.BadArgumentsException;

/**
 * @author Riadh MNASRI
 * 
 */
public interface Calculator {

    Integer add(Integer a, Integer b) throws BadArgumentsException;
}
