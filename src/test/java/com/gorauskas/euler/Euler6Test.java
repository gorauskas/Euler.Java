package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler6;

public class Euler6Test {

    @Test
    public void testSolve() {

        Euler6 e = new Euler6();
        assertEquals(e.Solve(), 25164150.0, 0);

    }

}

