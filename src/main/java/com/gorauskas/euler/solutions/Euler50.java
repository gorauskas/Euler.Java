package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;
import com.gorauskas.euler.streams.StreamUtil;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler50 implements Euler {
    @Override
    public double Solve() {
        var primes = StreamUtil.primeSequence(1000000)
                .boxed()
                .collect(Collectors.toList());

        var l = IntStream.rangeClosed(1, 547).boxed().collect(Collectors.toList());
        Collections.reverse(l);

        for (var ub : l) {  // upper bound
            int lb = 0;     // lower bound
            long s = primes.stream().mapToLong(x -> x).skip(lb).limit(lb + ub).sum();

            while (s < 1000000) {
                if (Util.isPrime(s)) {
                    return s;
                }

                lb++;
                s = primes.stream().mapToLong(x -> x).skip(lb).limit(lb + ub).sum();
            }
        }

        return 0;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 50\n")
                .append("\n")
                .append("    The prime 41, can be written as the sum of six consecutive primes:\n")
                .append("\n")
                .append("        41 = 2 + 3 + 5 + 7 + 11 + 13\n")
                .append("\n")
                .append("    This is the longest sum of consecutive primes that adds to a prime below\n")
                .append("    one-hundred.\n")
                .append("\n")
                .append("    The longest sum of consecutive primes below one-thousand that adds to a\n")
                .append("    prime, contains 21 terms, and is equal to 953.\n")
                .append("\n")
                .append("    Which prime, below one-million, can be written as the sum of the most\n")
                .append("    consecutive primes?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The prime number is %s", (long)this.Solve());
    }
}
