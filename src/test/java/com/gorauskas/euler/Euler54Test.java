package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler54;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler54Test {

    @Test
    public void testSolve() {

        Euler54 e = new Euler54();
        assertEquals(e.Solve(), 376.0, 0);

    }

}
