package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler56 implements Euler {
    @Override
    public double Solve() {
        long ls = 0;

        for (Integer i : IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList())) {
            for (Integer j : IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList())) {
                BigInteger n = new BigInteger(i.toString()).pow(j);
                long s = n.toString().chars().mapToLong(x -> x - 48l).sum();

                if (s > ls) {
                    ls = s;
                }
            }
        }

        return ls;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 56\n")
                .append("\n")
                .append("    A googol (10^100) is a massive number: one followed by one-hundred zeros;\n")
                .append("    100^100 is almost unimaginably large: one followed by two-hundred\n")
                .append("    zeros. Despite their size, the sum of the digits in each number is only 1.\n")
                .append("\n")
                .append("    Considering natural numbers of the form, a^b, where a, b < 100, what is the\n")
                .append("    maximum digital sum?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The max digital sum is %s", (long)this.Solve());
    }
}
