package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler16;

public class Euler16Test {

    @Test
    public void testSolve() {

        Euler16 e = new Euler16();
        assertEquals(e.Solve(), 1366.0, 0);

    }

}

