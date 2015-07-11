package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler13;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler13Test {

    @Test
    public void testSolve() {

        Euler13 e = new Euler13();
        assertEquals(e.Solve(), 5537376230.0, 0);

    }

}

