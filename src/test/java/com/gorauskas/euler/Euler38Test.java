package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler38;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler38Test {

    @Test
    public void testSolve() {

        Euler38 e = new Euler38();
        assertEquals(e.Solve(), 932718654.0, 0);

    }

}
