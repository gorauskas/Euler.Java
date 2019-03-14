package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler56;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler56Test {

    @Test
    public void testSolve() {

        Euler56 e = new Euler56();
        assertEquals(e.Solve(), 972.0, 0);

    }

}
