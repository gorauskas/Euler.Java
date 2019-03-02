package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler47;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler47Test {
    @Test
    public void testSolve() {

        Euler47 e = new Euler47();
        assertEquals(e.Solve(), 134043.0, 0);

    }
}
