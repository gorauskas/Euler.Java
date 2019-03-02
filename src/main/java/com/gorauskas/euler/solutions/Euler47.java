package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Euler47 implements Euler {
    @Override
    public double Solve() {
        var x = 210l;
        var y = 1;
        var nums = new ArrayList<Long>();

        while (y != 4) {
            x++;

            if (Util.factors(x)
                    .stream()
                    .filter(n -> Util.isPrime(n))
                    .collect(Collectors.toSet())
                    .size() == 4) {
                y++;
                nums.add(x);
            } else {
                y = 0;
                nums.clear();
            }
        }

        return nums.get(0);
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 47\n")
                .append("\n")
                .append("    The first two consecutive numbers to have two distinct prime factors are:\n")
                .append("\n")
                .append("      14 = 2 × 7\n")
                .append("      15 = 3 × 5\n")
                .append("\n")
                .append("    The first three consecutive numbers to have three distinct prime factors\n")
                .append("    are:\n")
                .append("\n")
                .append("      644 = 2² × 7 × 23\n")
                .append("      645 = 3 × 5 × 43\n")
                .append("      646 = 2 × 17 × 19\n")
                .append("\n")
                .append("    Find the first four consecutive integers to have four distinct prime\n")
                .append("    factors each. What is the first of these numbers?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The number is %s", (long)this.Solve());
    }
}
