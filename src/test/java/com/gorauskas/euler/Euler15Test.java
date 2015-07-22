package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler15;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler15Test {

    @Test
    public void testSolve() {

        Euler15 e = new Euler15();
        assertEquals(e.Solve(), 137846528820.0, 0);

    }

}

