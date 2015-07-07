package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler11;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler11Test {

    @Test
    public void testSolve() {

        Euler11 e = new Euler11();
        assertEquals(e.Solve(), 70600674.0, 0);

    }

}

