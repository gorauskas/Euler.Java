package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.stream.LongStream;

public class Euler14 implements Euler {

    @Override
    public double Solve() {
        return LongStream.range(2, 1000000)
                .mapToObj(n -> new collatzLen(n, calcLen(n)))
                .sorted((o1, o2) -> Long.compare(o2.len, o1.len))  // sort descending
                .findFirst()
                .get()
                .key;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 14:\n")
                .append("\n")
                .append("    The following iterative sequence is defined for the n of positive \n")
                .append("    integers:\n")
                .append("\n")
                .append("    n -> n/2      (n is even)\n")
                .append("    n -> 3n + 1   (n is odd)\n")
                .append("\n")
                .append("    Using the rule above and starting with 13, we generate the following \n")
                .append("    sequence:\n")
                .append("\n")
                .append("    13  40  20  10  5  16  8  4  2  1\n")
                .append("    \n")
                .append("    It can be seen that this sequence (starting at 13 and finishing at 1) \n")
                .append("    contains 10 terms. Although it has not been proved yet (Collatz Problem), \n")
                .append("    it is thought that all starting numbers finish at 1.\n")
                .append("\n")
                .append("    Which starting number, under one million, produces the longest chain?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The starting number, under one million, produces the longest chain is %s"
                , this.Solve());
        return s;
    }

    private static long calcLen(long n) {
        return Util.collatzSequence(n).size();
    }

    class collatzLen {
        long key = 0;
        long len = 0;

        public collatzLen(long key, long len) {
            this.key = key;
            this.len = len;
        }
    }
}
