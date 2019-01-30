package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler41 implements Euler {
    @Override
    public double Solve() {
        long n = 7654321;

        while (!(Util.isPrime(n) && Util.isPanDigital(String.valueOf(n), 7))) {
            n -= 2;
        }

        return n;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 40\n")
                .append("\n")
                .append("    We shall say that an n-digit number is pandigital if it makes use of all\n")
                .append("    the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital\n")
                .append("    and is also prime.\n")
                .append("\n")
                .append("    What is the largest n-digit pandigital prime that exists?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The largest n-digit pandigital prime that exists is %s", (long)this.Solve());
    }
}
