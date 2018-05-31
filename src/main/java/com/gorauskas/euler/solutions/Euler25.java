package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import static java.lang.Math.sqrt;
import static java.lang.Math.log10;
import static java.lang.Math.ceil;

public class Euler25 implements Euler {

    /**
     * Solving this problem simply comes down to knowing Binet’s formula for finding the nth Fibonacci
     * term and using logs to determine its magnitude.
     *
     * Wikipedia shows us that the nth Fibonacci number is  F_n = [\frac{\varphi^n}{\sqrt{5}}], n\ge0 ,
     * so we define an inequality that we will use to solve for n for the first Fibonacci number that
     * exceeds d digits. In the case of 1000 digits it would be 10999 or 1 followed by 999 zeros; a
     * thousand digits
     *
     * @see <a href="http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html">http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html</a>
     * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number#Computation_by_rounding">https://en.wikipedia.org/wiki/Fibonacci_number#Computation_by_rounding</a>
     */
    @Override
    public double Solve() {
        double phi = (1 + sqrt(5)) / 2;
        return ceil((log10(5) / 2 + 1000 - 1) / log10(phi));
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 25\n")
                .append("\n")
                .append("    The Fibonacci sequence is defined by the recurrence relation:\n")
                .append("\n")
                .append("        Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.\n")
                .append("\n")
                .append("    Hence the first 12 terms will be:\n")
                .append("\n")
                .append("        F1 = 1    \n")
                .append("        F2 = 1    \n")
                .append("        F3 = 2    \n")
                .append("        F4 = 3    \n")
                .append("        F5 = 5    \n")
                .append("        F6 = 8    \n")
                .append("        F7 = 13   \n")
                .append("        F8 = 21   \n")
                .append("        F9 = 34   \n")
                .append("        F10 = 55  \n")
                .append("        F11 = 89  \n")
                .append("        F12 = 144 \n")
                .append("\n")
                .append("    The 12th term, F12, is the first term to contain three digits.\n")
                .append("\n")
                .append("    What is the first term in the Fibonacci sequence to contain 1000 digits?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The first number in the Fibonacci sequence to contain 1000 digits is %s\n"
                , (long)this.Solve());
        return s;
    }
}
