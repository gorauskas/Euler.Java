package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler39;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler39Test {

    @Test
    public void testSolve() {

        Euler39 e = new Euler39();
        assertEquals(e.Solve(), 840.0, 0);

    }

}
