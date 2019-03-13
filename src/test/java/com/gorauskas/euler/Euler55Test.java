package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler55;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler55Test {

    @Test
    public void testSolve() {

        Euler55 e = new Euler55();
        assertEquals(e.Solve(), 249.0, 0);

    }

}
