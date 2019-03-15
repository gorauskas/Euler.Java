package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler57;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler57Test {

    @Test
    public void testSolve() {

        Euler57 e = new Euler57();
        assertEquals(e.Solve(), 153.0, 0);

    }

}
