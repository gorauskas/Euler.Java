package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler59;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler59Test {

    @Test
    public void testSolve() {

        Euler59 e = new Euler59();
        assertEquals(e.Solve(), 129448.0, 0);

    }

}
