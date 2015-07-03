package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler9;

public class Euler9Test {

    @Test
    public void testSolve() {

        Euler9 e = new Euler9();
        assertEquals(e.Solve(), 31875000.0, 0);

    }

}

