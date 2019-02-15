package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler44;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler44Test {

    @Test
    public void testSolve() {

        Euler44 e = new Euler44();
        assertEquals(e.Solve(), 5482660.0, 0);

    }

}
