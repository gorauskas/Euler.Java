package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler42;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler42Test {

    @Test
    public void testSolve() {

        Euler42 e = new Euler42();
        assertEquals(e.Solve(), 162.0, 0);

    }

}
