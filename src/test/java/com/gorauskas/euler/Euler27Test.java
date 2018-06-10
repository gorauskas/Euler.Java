package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler27;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler27Test {
    @Test
    public void testSolve() {

        Euler27 e = new Euler27();
        assertEquals(e.Solve(), -59231.0, 0);

    }
}
