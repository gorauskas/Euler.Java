package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.math.BigInteger;

public class Euler16 implements Euler {

    @Override
    public double Solve() {
        return BigInteger.ONE.shiftLeft(1000).toString().chars().map(c -> c - 48).sum();
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 16:\n")
                .append("\n")
                .append("    2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n")
                .append("\n")
                .append("    What is the sum of the digits of the number 2^1000?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The sum of the digits of the number 2^1000 is %s"
                , (long)this.Solve());
        return s;
    }
}
