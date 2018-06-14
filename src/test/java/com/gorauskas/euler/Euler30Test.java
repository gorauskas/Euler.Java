package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler30;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler30Test {

    @Test
    public void testSolve() {

        Euler30 e = new Euler30();
        assertEquals(e.Solve(), 443839.0, 0);

    }

}
