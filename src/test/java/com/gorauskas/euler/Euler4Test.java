package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler4;

public class Euler4Test {

    @Test
    public void testSolve() {

        Euler4 e = new Euler4();
        assertEquals(e.Solve(), 906609.0, 0);

    }

}

