package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler32;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler32Test {

    @Test
    public void testSolve() {

        Euler32 e = new Euler32();
        assertEquals(e.Solve(), 45228.0, 0);

    }

}
