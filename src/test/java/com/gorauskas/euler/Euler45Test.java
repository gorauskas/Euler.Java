package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler45;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler45Test {

    @Test
    public void testSolve() {

        Euler45 e = new Euler45();
        assertEquals(e.Solve(), 1533776805.0, 0);

    }

}
