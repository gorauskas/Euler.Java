package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler49;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler49Test {

    @Test
    public void testSolve() {

        Euler49 e = new Euler49();
        assertEquals(e.Solve(), 296962999629.0, 0);

    }

}
