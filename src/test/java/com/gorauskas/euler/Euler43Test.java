package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler43;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler43Test {

    @Test
    public void testSolve() {

        Euler43 e = new Euler43();
        assertEquals(e.Solve(), 16695334890.0d, 0);

    }

}
