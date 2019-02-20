package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import com.gorauskas.euler.streams.StreamUtil;

public class Euler10 implements Euler {

    @Override
    public double Solve() {
        return StreamUtil.primeSequence(2000000).sum();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 10:\n")
                .append("\n")
                .append("   The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n")
                .append("\n")
                .append("   Find the sum of all the primes below two million.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all the primes below two million is: %s"
                , (long)this.Solve());
    }

}
