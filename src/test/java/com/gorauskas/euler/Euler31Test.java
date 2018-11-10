package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler31;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler31Test {

    @Test
    public void testSolve() {

        Euler31 e = new Euler31();
        assertEquals(e.Solve(), 73682.0, 0);

    }

}




