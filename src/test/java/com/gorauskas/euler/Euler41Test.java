package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler41;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler41Test {

    @Test
    public void testSolve() {

        Euler41 e = new Euler41();
        assertEquals(e.Solve(), 7652413.0, 0);

    }

}
