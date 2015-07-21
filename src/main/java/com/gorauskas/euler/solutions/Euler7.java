package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.streams.StreamUtil;

public class Euler7 implements Euler {

    @Override
    public double Solve() {
        return (double) StreamUtil.primeSequence(10001).reduce((a, b) -> b).getAsLong();

        //return loopStrategy();
    }

    public double loopStrategy() {
        long n = 0, p = 1;

        while (p < 10000) {
            ++n;
            for (int i = 2; i <= (long)Math.sqrt(n) && n % i != 0; i++) {
                if (i == (int)Math.sqrt(n)) {
                    p++;
                }
            }
        }

        return n;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 7:\n")
                .append("\n")
                .append("   By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,\n")
                .append("   we can see that the 6th prime is 13.\n")
                .append("\n")
                .append("   What is the 10001st prime number?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("Prime 10001 is %s"
                , this.Solve());
        return s;
    }
}
