package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler26;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler26Test {

    @Test
    public void testSolve() {

        Euler26 e = new Euler26();
        assertEquals(e.Solve(), 983.0, 0);

    }

}
