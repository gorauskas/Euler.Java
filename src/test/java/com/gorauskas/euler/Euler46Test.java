package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler46;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler46Test {

    @Test
    public void testSolve() {

        Euler46 e = new Euler46();
        assertEquals(e.Solve(), 5777.0, 0);

    }

}
