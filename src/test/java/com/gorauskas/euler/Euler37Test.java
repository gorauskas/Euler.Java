package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler37;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler37Test {

    @Test
    public void testSolve() {

        Euler37 e = new Euler37();
        assertEquals(e.Solve(), 748317.0, 0);

    }

}
