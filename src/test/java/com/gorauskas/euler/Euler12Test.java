package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler12;

public class Euler12Test {

    @Test
    public void testSolve() {

        Euler12 e = new Euler12();
        assertEquals(e.Solve(), 76576500.0, 0);

    }

}

