package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.stream.IntStream;

public class Euler1 implements Euler {
    @Override
    public double Solve() {
        return IntStream.range(1, 1000)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();

        //return loopStrategy();
    }

    public double loopStrategy() {
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
        return new StringBuilder()
                .append("Project Euler Problem 1:\n")
                .append("\n")
                .append("   If we list all the natural numbers below 10 that are\n")
                .append("   multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of\n")
                .append("   these multiples is 23.\n")
                .append("\n")
                .append("   Find the sum of all the multiples of 3 or 5 below 1000.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all the multiples of 3 or 5 below 1000 is: %s"
                , this.Solve());
    }
}
