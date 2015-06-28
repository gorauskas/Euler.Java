package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler5;

public class Euler5Test {

    @Test
    public void testSolve() {

        Euler5 e = new Euler5();
        assertEquals(e.Solve(), 232792560.0, 0);

    }

}

