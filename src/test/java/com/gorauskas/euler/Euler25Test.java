package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler25;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler25Test {

    @Test
    public void testSolve() {

        Euler25 e = new Euler25();
        assertEquals(e.Solve(), 4782.0, 0);

    }
}
