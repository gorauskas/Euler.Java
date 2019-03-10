package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler53;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler53Test {

    @Test
    public void testSolve() {

        Euler53 e = new Euler53();
        assertEquals(e.Solve(), 4075.0, 0);

    }

}
