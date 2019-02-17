package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.gorauskas.euler.streams.StreamUtil.primeSequence;

public class Euler46 implements Euler {
    @Override
    public double Solve() {
        List<Long> primes = primeSequence(10000).boxed().collect(Collectors.toList());
        long r = 1;
        boolean nf = true;

        while (nf) {
            r += 2;
            int j = 0;
            nf = false;

            while (r >= primes.get(j)) {
                if (twiceSquare.apply(r - primes.get(j))) {
                    nf = true;
                    break;
                }

                j++;
            }
        }

        return r;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 46\n")
                .append("\n")
                .append("    It was proposed by Christian Goldbach that every odd composite number can\n")
                .append("    be written as the sum of a prime and twice a square.\n")
                .append("\n")
                .append("      9 = 7 + 2×12\n")
                .append("      15 = 7 + 2×22\n")
                .append("      21 = 3 + 2×32\n")
                .append("      25 = 7 + 2×32\n")
                .append("      27 = 19 + 2×22\n")
                .append("      33 = 31 + 2×12\n")
                .append("\n")
                .append("    It turns out that the conjecture was false.\n")
                .append("\n")
                .append("    What is the smallest odd composite that cannot be written as the sum of a\n")
                .append("    prime and twice a square?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format(" %s", (long)this.Solve());
    }

    private Function<Long, Boolean> twiceSquare = x -> Math.sqrt(x / 2.0) % 1.0 == 0;
    
}
