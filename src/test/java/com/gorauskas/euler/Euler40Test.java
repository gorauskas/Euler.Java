package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler40;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler40Test {

    @Test
    public void testSolve() {

        Euler40 e = new Euler40();
        assertEquals(e.Solve(), 210.0, 0);

    }

}
