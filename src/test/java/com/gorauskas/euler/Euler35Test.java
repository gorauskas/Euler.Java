package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler35;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler35Test {

    @Test
    public void testSolve() {

        Euler35 e = new Euler35();
        assertEquals(e.Solve(), 55.0, 0);

    }

}
