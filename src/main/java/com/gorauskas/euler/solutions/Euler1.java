package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

public class Euler1 implements Euler {
    @Override
    public double Solve() {
        double sum = 0;

        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0) {
                sum += i;
                continue;
            } else if (i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 1:\n")
                .append("\n")
                .append("   If we list all the natural numbers below 10 that are\n")
                .append("   multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of\n")
                .append("   these multiples is 23.\n")
                .append("\n")
                .append("   Find the sum of all the multiples of 3 or 5 below 1000.\n")
                .toString();

        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The sum of all the multiples of 3 or 5 below 1000 is: %s"
                , this.Solve());
        return s;
    }
}
