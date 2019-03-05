package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler50;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler50Test {

    @Test
    public void testSolve() {

        Euler50 e = new Euler50();
        assertEquals(e.Solve(), 997651.0, 0);

    }

}
