package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler57 implements Euler {
    @Override
    public double Solve() {
        int res = 0;
        BigInteger n, d, t;

        for (Integer x : IntStream.rangeClosed(2, 1000).boxed().collect(Collectors.toList())) {
            n = BigInteger.ONE;
            d = BigInteger.TWO;

            for (Integer y : IntStream.rangeClosed(1, x).boxed().collect(Collectors.toList())) {
                n = (BigInteger.TWO.multiply(d)).add(n);

                t = d;
                d = n;
                n = t;
            }

            n = n.add(d);

            if (n.toString().length() > d.toString().length()) {
                res++;
            }
        }

        return res;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 57\n")
                .append("\n")
                .append("    It is possible to show that the square root of two can be expressed as an\n")
                .append("    infinite continued fraction.\n")
                .append("\n")
                .append("      √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...\n")
                .append("\n")
                .append("    By expanding this for the first four iterations, we get:\n")
                .append("\n")
                .append("      1 + 1/2 = 3/2 = 1.5\n")
                .append("      1 + 1/(2 + 1/2) = 7/5 = 1.4\n")
                .append("      1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...\n")
                .append("      1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...\n")
                .append("\n")
                .append("    The next three expansions are 99/70, 239/169, and 577/408, but the eighth\n")
                .append("    expansion, 1393/985, is the first example where the number of digits in the\n")
                .append("    numerator exceeds the number of digits in the denominator.\n")
                .append("\n")
                .append("    In the first one-thousand expansions, how many fractions contain a\n")
                .append("    numerator with more digits than denominator?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %s fractions whose numerators have more digits than then denominator.",
                (long)this.Solve());
    }
}
