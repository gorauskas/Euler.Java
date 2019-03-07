package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Euler49 implements Euler {
    @Override
    public double Solve() {
        long x = 0, y = 0, z = 0;
        String str = "";

        for (var item : LongStream.rangeClosed(1000, 3000).boxed().collect(Collectors.toList())) {
            x = item;
            y = x + 3330;
            z = y + 3330;

            if (Util.isPrime(x) && Util.isPrime(y) && Util.isPrime(z)) {
                if (Util.sorted(String.valueOf(y)).equals(Util.sorted(String.valueOf(x))) &&
                        Util.sorted(String.valueOf(z)).equals(Util.sorted(String.valueOf(x)))) {

                    // if the numbers are permutations of one another then sorting them
                    // byt digit ascending makes them equal.
                    str = String.valueOf(x) + String.valueOf(y) + String.valueOf(z);

                }
            }
        }

        return Double.parseDouble(str);
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 49\n")
                .append("\n")
                .append("    The arithmetic sequence, 1487, 4817, 8147, in which each of the terms\n")
                .append("    increases by 3330, is unusual in two ways: (i) each of the three terms are\n")
                .append("    prime, and, (ii) each of the 4-digit numbers are permutations of one\n")
                .append("    another.\n")
                .append("\n")
                .append("    There are no arithmetic sequences made up of three 1-, 2-, or 3-digit\n")
                .append("    primes, exhibiting this property, but there is one other 4-digit increasing\n")
                .append("    sequence.\n")
                .append("\n")
                .append("    What 12-digit number do you form by concatenating the three terms in this\n")
                .append("    sequence?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The 12-digit number is %s", (long)this.Solve());
    }
}
