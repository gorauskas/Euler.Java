package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.math.BigInteger;

public class Euler20 implements Euler {
    @Override
    public double Solve() {
        return Util.factorial(BigInteger.valueOf(100))
                .toString()
                .chars()
                .map(c -> c - 48)
                .sum();
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 20\n")
                .append("\n")
                .append("    n! means n × (n − 1) × ... × 3 × 2 × 1\n")
                .append("\n")
                .append("    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,\n")
                .append("    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.\n")
                .append("\n")
                .append("    Find the sum of the digits in the number 100!\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The sum of the digits in the number 100! is %s"
                , (long)this.Solve());
        return s;
    }
}
