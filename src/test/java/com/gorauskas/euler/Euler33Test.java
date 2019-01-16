package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler33;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler33Test {

    @Test
    public void testSolve() {

        Euler33 e = new Euler33();
        assertEquals(e.Solve(), 100.0, 0);

    }

}