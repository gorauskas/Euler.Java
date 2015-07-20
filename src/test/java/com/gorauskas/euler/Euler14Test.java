package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler14;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler14Test {

    @Test
    public void testSolve() {

        Euler14 e = new Euler14();
        assertEquals(e.Solve(), 837799.0, 0);

    }

}

