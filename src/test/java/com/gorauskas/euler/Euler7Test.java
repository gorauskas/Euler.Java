package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler7;

public class Euler7Test {

    @Test
    public void testSolve() {

        Euler7 e = new Euler7();
        assertEquals(e.Solve(), 104743.0, 0);

    }

}

