package com.gorauskas.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.gorauskas.euler.solutions.Euler3;

public class Euler3Test {

    @Test
    public void testSolve() {

        Euler3 e = new Euler3();
        assertEquals(6857.0, e.Solve(), 0);

    }
}
