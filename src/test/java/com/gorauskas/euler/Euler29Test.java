package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler29;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler29Test {

    @Test
    public void testSolve() {

        Euler29 e = new Euler29();
        assertEquals(e.Solve(), 9183.0, 0);

    }

}
