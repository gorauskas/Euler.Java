package com.gorauskas.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.gorauskas.euler.solutions.Euler2;

public class Euler2Test {

    @Test
    public void testSolve() {

        Euler2 e = new Euler2();
        assertEquals(e.Solve(), 4613732.0, 0);

    }

}
