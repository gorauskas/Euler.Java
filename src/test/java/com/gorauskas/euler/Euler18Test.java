package com.gorauskas.euler;


import com.gorauskas.euler.solutions.Euler18;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler18Test {

    @Test
    public void testSolve() {

        Euler18 e =new Euler18();
        assertEquals(e.Solve(), 1074.0, 0);

    }
}
