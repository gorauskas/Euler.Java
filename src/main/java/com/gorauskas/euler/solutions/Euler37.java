package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.gorauskas.euler.streams.StreamUtil;

public class Euler37 implements Euler {
    @Override
    public double Solve() {
        List<Long> L = new ArrayList<>();

        List<Long> primes = StreamUtil.primeSequence(10, 1000000)
                .boxed()
                .collect(Collectors.toList());

        for (Long prime : primes) {
            if (IsTruncatable(prime)) {
                L.add(prime);
            }

            if (L.size() == 11) {
                break;
            }
        }

        return L.stream().mapToLong(x -> x).sum();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 37:\n")
                .append("\n")
                .append("    The number 3797 has an interesting property. Being prime itself, it is\n")
                .append("    possible to continuously remove digits from left to right, and remain prime\n")
                .append("    at each stage: 3797, 797, 97, and 7. Similarly we can work from right to\n")
                .append("    left: 3797, 379, 37, and 3.\n")
                .append("\n")
                .append("    Find the sum of the only eleven primes that are both truncatable from left\n")
                .append("    to right and right to left.\n")
                .append("\n")
                .append("    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of the only eleven primes that are both truncatable left\n" +
                "and right is %d\n", (long)this.Solve());
    }

    private boolean IsTruncatable(long n) {
        long m = n;
        while (m > 0) {          // truncate right - divide by 10
            if (!Util.isPrime(m)) {
                return false;
            }

            m /= 10;
        }

        long k = 10;             // truncate left - mod by 10, 100, 1000, n
        for (int x = 0; x < String.valueOf(n).length(); x++) {
            if (!Util.isPrime(n % k)) {
                return false;
            }

            k *= 10;
        }

        return true;
    }
}


