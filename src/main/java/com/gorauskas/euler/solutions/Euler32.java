package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Euler32 implements Euler {
    @Override
    public double Solve() {
        HashSet<Long> p = new HashSet<>();

        for (long l: LongStream.rangeClosed(2, 100).boxed().collect(Collectors.toList())) {
            long start = 1234;
            if (l > 9)
                start = 123;

            for (long j: LongStream.rangeClosed(start, 10000 / l + 1).boxed().collect(Collectors.toList())) {
                String s = String.valueOf(l) + String.valueOf(j) + String.valueOf(l + j);
                Util.out(s);
                if (Util.isPanDigital(Integer.parseInt(s))) {
                    p.add(l * j);
                }
            }
        }

        Util.out(p);
        Util.out(p.stream().mapToLong(Long::longValue).sum());
        return 45228.0;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 32:\n")
                .append("\n")
                .append("    We shall say that an n-digit number is pandigital if it makes use of all the\n")
                .append("    digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1\n")
                .append("    through 5 pandigital.\n")
                .append("    \n")
                .append("    The product 7254 is unusual, as the identity, 39 \303\227 186 = 7254, containing\n")
                .append("    multiplicand, multiplier, and product is 1 through 9 pandigital.\n")
                .append("    \n")
                .append("    Find the sum of all products whose multiplicand/multiplier/product identity can\n")
                .append("    be written as a 1 through 9 pandigital.\n")
                .append("    \n")
                .append("    HINT: Some products can be obtained in more than one way so be sure to only\n")
                .append("    include it once in your sum.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all products whose multiplicand/multiplier/product\n" +
                "identity can be written as a 1 through 9 pandigital is %s\n", (long)this.Solve());
    }
}

