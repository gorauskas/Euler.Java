package com.gorauskas.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.gorauskas.euler.solutions.Euler1;

public class Euler1Test {

    @Test
    public void testSolve() {

        Euler1 e = new Euler1();
        assertEquals(e.Solve(), 233168.0, 0);

    }

}

