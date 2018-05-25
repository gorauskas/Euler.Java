package com.gorauskas.euler;

import com.gorauskas.euler.solutions.Euler23;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Euler23Test {
    
    @Test
    public void testSolve() {
        
        Euler23 e = new Euler23();
        assertEquals(e.Solve(), 4179871.0, 0);
        
    }

}
