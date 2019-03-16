package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler58;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler58Test {

    @Test
    public void testSolve() {

        Euler58 e = new Euler58();
        assertEquals(e.Solve(), 26241.0, 0);

    }

}
