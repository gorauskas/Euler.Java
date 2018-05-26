package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler24;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler24Test {

    @Test
    public void testSolve() {

        Euler24 e = new Euler24();
        assertEquals(e.Solve(), 2783915460.0, 0);

    }

}
