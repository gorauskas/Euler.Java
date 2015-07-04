package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler10;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler10Test {

    @Test
    public void testSolve() {

        Euler10 e = new Euler10();
        assertEquals(e.Solve(), 142913828922.0, 0);

    }

}

