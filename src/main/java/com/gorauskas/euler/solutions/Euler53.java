package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.math.BigInteger;

public class Euler53 implements Euler {
    @Override
    public double Solve() {
        int x = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                if (BigInteger.valueOf(1000000).compareTo(combinatorics(i, j)) < 0) {
                    x++;
                }
            }
        }

        return x;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 53\n")
                .append("\n")
                .append("    There are exactly ten ways of selecting three from five, 12345:\n")
                .append("\n")
                .append("      123, 124, 125, 134, 135, 145, 234, 235, 245, and 345\n")
                .append("\n")
                .append("                                           5\n")
                .append("    In combinatorics, we use the notation,  C = 10.\n")
                .append("                                             3\n")
                .append("\n")
                .append("    In general,\n")
                .append("\n")
                .append("     n         n!\n")
                .append("      C  = ----------   where r <= n, n! = n*(n−1)*...*3*2*1, and 0! = 1.\n")
                .append("       r    r!(n−r)!\n")
                .append("\n")
                .append("                                                              23\n")
                .append("    It is not until n = 23, that a value exceeds one-million:   C   = 1144066.\n")
                .append("                                                                 10\n")
                .append("\n")
                .append("                                                  n\n")
                .append("    How many, not necessarily distinct, values of  C , for 1 <= n <= 100,\n")
                .append("                                                    r\n")
                .append("\n")
                .append("    are greater than one-million?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %s values greater than one million.", (long)this.Solve());
    }

    private BigInteger combinatorics(long i, long j) {
        BigInteger I = BigInteger.valueOf(i);
        BigInteger J = BigInteger.valueOf(j);

        if (j <= i) {
            return Util.factorial(I)
                    .divide((Util.factorial(J)
                            .multiply(Util.factorial(I.subtract(J)))));
        } else {
            return BigInteger.ZERO;
        }
    }
}
