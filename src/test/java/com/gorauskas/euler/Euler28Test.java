package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler28;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler28Test {

    @Test
    public void testSolve() {

        Euler28 e = new Euler28();
        assertEquals(e.Solve(), 669171001.0, 0);

    }

}
