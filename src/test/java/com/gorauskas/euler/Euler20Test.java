package com.gorauskas.euler;


import com.gorauskas.euler.solutions.Euler20;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler20Test {

    @Test
    public void testSolve() {

        Euler20 e = new Euler20();
        assertEquals(e.Solve(), 648.0, 0);

    }

}
