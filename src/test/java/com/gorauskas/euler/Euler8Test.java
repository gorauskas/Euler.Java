package com.gorauskas.euler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.gorauskas.euler.solutions.Euler8;

public class Euler8Test {

    @Test
    public void testSolve() {

        Euler8 e = new Euler8();
        assertEquals(e.Solve(), 23514624000.0, 0);

    }

}

