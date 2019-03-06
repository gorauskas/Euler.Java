package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler51;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler51Test {

    @Test
    public void testSolve() {

        Euler51 e = new Euler51();
        assertEquals(e.Solve(), 121313.0, 0);

    }

}
