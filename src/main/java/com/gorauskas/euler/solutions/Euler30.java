package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.stream.IntStream;

/**
 * Find the bounds: Start at 2 because 1 is not a sum
 * 9^5 * 6 = 354294 = upper bound or the highest sum of 5th powers
 *   So we can cover 6 digit numbers up to that far and no further.
 *   With 7 digit numbers, the highest value is 413343,  So we only
 *   need to loop from 2 to 354294
 *
 * Create a list of int
 * Split each num into chars
 * Raise each digit to the 5th power and sum them
 * Does the result eaquals the initial number
 * sum the result
 */
public class Euler30 implements Euler {
    @Override
    public double Solve() {

        return IntStream.rangeClosed(2, 354294)
                .mapToObj(String::valueOf)
                .filter(x -> x.equals(String.valueOf(x.chars()
                        .map(c -> c - 48)
                        .map(y -> (int) Math.pow(y, 5))
                        .sum())))
                .mapToInt(Integer::parseInt)
                .sum();

    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 30\n")
                .append("\n")
                .append("    Surprisingly there are only three numbers that can be written as the sum of\n")
                .append("    fourth powers of their digits:\n")
                .append("\n")
                .append("        1634 = 1^4 + 6^4 + 3^4 + 4^4\n")
                .append("        8208 = 8^4 + 2^4 + 0^4 + 8^4\n")
                .append("        9474 = 9^4 + 4^4 + 7^4 + 4^4\n")
                .append("\n")
                .append("    As 1 = 1^4 is not a sum it is not included.\n")
                .append("\n")
                .append("    The sum of these numbers is 1634 + 8208 + 9474 = 19316.\n")
                .append("\n")
                .append("    Find the sum of all the numbers that can be written as the sum of fifth\n")
                .append("    powers of their digits.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all the numbers that can be written as the sum of\n" +
                "fifth powers of their digits is %s\n", (long)this.Solve());
    }
}
