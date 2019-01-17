package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Euler34 implements Euler {


    @Override
    public double Solve() {
        //pre - calculated factorials from 1 to 9
        List<Integer> fact = Arrays.asList(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880);
        List<Integer> range = IntStream.rangeClosed(10, 49989).boxed().collect(Collectors.toList());
        long r = 0;

        for (int n : range) {
            long x = String.valueOf(n)
                    .chars()
                    .mapToLong(c -> c - 48)
                    .map(i -> fact.get((int)i))
                    .sum();

            if (n == x) {
                r += n;
            }
        }

        return r;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 34:\n")
                .append("\n")
                .append("    145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.\n")
                .append("\n")
                .append("    Find the sum of all numbers which are equal to the sum of the\n")
                .append("    factorial of their digits.\n")
                .append("\n")
                .append("    Note: as 1! = 1 and 2! = 2 are not sums they are not included.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all numbers which are equal to the sum of the factorial of\n" +
                "their digits is %s", (long)this.Solve());
    }
}

