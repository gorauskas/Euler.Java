package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.gorauskas.euler.streams.StreamUtil;

public class Euler35 implements Euler {
    @Override
    public double Solve() {
        // resulting list of circular primes
        List<Long> L = new ArrayList<>();
        // all primes less than 1 million
        List<Long> primes = StreamUtil.primeSequence(1000000)
                .boxed()
                .collect(Collectors.toList());

        for (long prime : primes) {
            if (checkRotations(String.valueOf(prime)
                    .chars()
                    .mapToLong(x -> x - 48)
                    .boxed()
                    .collect(Collectors.toList())
                    , prime)) {

                L.add(prime);
            }
        }

        return L.size();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 35:\n")
                .append("\n")
                .append("    The number, 197, is called a circular prime because all rotations of the digits:\n")
                .append("    197, 971, and 719, are themselves prime.\n")
                .append("\n")
                .append("    There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,\n")
                .append("    73, 79, and 97.\n")
                .append("\n")
                .append("    How many circular primes are there below one million?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %d circular primes below 1 million.\n", (long)this.Solve());
    }

    // Checks the circular rotations of each prime number for primes
    // True if all rotations are also prime, false otherwise
    //   l = a list of digits that makes up the prime nunber n
    //   n = The prime number to check
    private boolean checkRotations(List<Long> l, long n) {
        long k = 0L;

        while (n != k) {
            // as in Lisp car and cdr
            List<Long> cdr = l.stream().skip(1).limit(l.size() - 1).collect(Collectors.toList());  // the rest of the list
            long car = l.get(0);  // the first item

            cdr.add(car); // add first item to the end to rotate

            k = Long.parseLong(String.join("", cdr.stream().map(Object::toString).collect(Collectors.toList())));

            if (!Util.isPrime(k)) {
                return false;
            }

            l = cdr;
        }

        return true;
    }
}
