package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler17;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler17Test {

    @Test
    public void testSolve() {

        Euler17 e = new Euler17();
        assertEquals(e.Solve(), 21124.0, 0);

    }

}
