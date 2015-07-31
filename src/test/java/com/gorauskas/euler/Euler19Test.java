package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler19;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler19Test {

    @Test
    public void testSolve() {

        Euler19 e = new Euler19();
        assertEquals(e.Solve(), 171.0, 0);

    }

}
