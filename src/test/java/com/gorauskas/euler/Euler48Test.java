package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler48;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler48Test {

    @Test
    public void testSolve() {

        Euler48 e = new Euler48();
        assertEquals(e.Solve(), 9110846700.0, 0);

    }

}
