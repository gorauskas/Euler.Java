package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler36;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler36Test {

    @Test
    public void testSolve() {

        Euler36 e = new Euler36();
        assertEquals(e.Solve(), 872187.0, 0);

    }

}
