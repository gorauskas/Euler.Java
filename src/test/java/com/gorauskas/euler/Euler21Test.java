package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler21;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler21Test {

    @Test
    public void testSolve() {

        Euler21 e = new Euler21();
        assertEquals(e.Solve(), 31626.0, 0);

    }

}
