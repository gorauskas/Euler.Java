package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.stream.LongStream;

public class Euler3 implements Euler {

    @Override
    public double Solve() {
        var n = 600851475143l;
        return LongStream.rangeClosed(2, 775164)
                .filter(i -> n % i == 0 && Util.isPrime(i))
                .max()
                .getAsLong();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 3:\n")
                .append("\n")
                .append("  The prime factors of 13195 are 5, 7, 13 and 29.\n")
                .append("\n")
                .append("  What is the largest prime factor of the number 600851475143 ?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The largest prime factor of the number 600851475143 is: %s"
                , this.Solve());
    }
}
