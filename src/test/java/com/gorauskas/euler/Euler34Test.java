package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler34;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler34Test {

    @Test
    public void testSolve() {

        Euler34 e = new Euler34();
        assertEquals(e.Solve(), 40730.0, 0);

    }

}
