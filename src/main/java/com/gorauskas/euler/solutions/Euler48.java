package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Euler48 implements Euler {
    @Override
    public double Solve() {
        String s = IntStream.rangeClosed(1, 1000)
                .mapToObj(String::valueOf)
                .map(BigInteger::new)
                .map(bi -> bi.pow(bi.intValue()))
                .reduce(BigInteger::add)
                .get()
                .toString();

        return Double.parseDouble(s.substring(s.length() - 10));
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 48\n")
                .append("\n")
                .append("    The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.\n")
                .append("\n")
                .append("    Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The last ten digits of the series are %s", (long)this.Solve());
    }
}
