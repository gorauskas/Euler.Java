package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.stream.Collectors;
import static com.gorauskas.euler.streams.StreamUtil.primeSequence;

public class Euler51 implements Euler {
    @Override
    public double Solve() {
        var primes = primeSequence(100000, 1000000).boxed().collect(Collectors.toList());

        for (var prime : primes) {
            var s = prime.toString();

            for (int x = 0; x < s.length(); x++) {
                var c = s.charAt(x);
                var count = 0;

                for (int y = 0; y < 10; y++) {
                    var i = Integer.parseInt(s.replace(c, String.valueOf(y).charAt(0)));

                    if (Util.isPrime(i) && i > 100000) {
                        count++;
                    }
                }

                if (count > 7) {
                    return Integer.parseInt(s);
                }
            }
        }

        return 0;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 51\n")
                .append("\n")
                .append("    By replacing the 1st digit of the 2-digit number *3, it turns out that six\n")
                .append("    of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.\n")
                .append("\n")
                .append("    By replacing the 3rd and 4th digits of 56**3 with the same digit, this\n")
                .append("    5-digit number is the first example having seven primes among the ten\n")
                .append("    generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,\n")
                .append("    56773, and 56993. Consequently 56003, being the first member of this\n")
                .append("    family, is the smallest prime with this property.\n")
                .append("\n")
                .append("    Find the smallest prime which, by replacing part of the number (not\n")
                .append("    necessarily adjacent digits) with the same digit, is part of an eight prime\n")
                .append("    value family.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The smallest prime which is part of an eight prime value family is %s", (long)this.Solve());
    }
}
