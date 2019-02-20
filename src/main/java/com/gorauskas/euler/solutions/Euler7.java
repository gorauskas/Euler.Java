package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.streams.StreamUtil;

import java.util.stream.Collectors;

public class Euler7 implements Euler {

    @Override
    public double Solve() {
        return (double) StreamUtil.primeSequence(105000)
                .boxed()
                .collect(Collectors.toList())
                .get(10000); // index is 0 based
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 7:\n")
                .append("\n")
                .append("   By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,\n")
                .append("   we can see that the 6th prime is 13.\n")
                .append("\n")
                .append("   What is the 10001st prime number?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("Prime 10001 is %s"
                , this.Solve());
    }
}
