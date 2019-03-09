package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler52;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler52Test {

    @Test
    public void testSolve() {

        Euler52 e = new Euler52();
        assertEquals(e.Solve(), 142857.0, 0);

    }

}
