package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler22;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler22Test {

    @Test
    public void testSolve() {
        
        Euler22 e = new Euler22();
        assertEquals(e.Solve(), 871198282.0, 0);
        
    }
    
}
