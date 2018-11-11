package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler31 implements Euler {

    private final int TARGET = 200;

    @Override
    public double Solve() {
        int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };
        int[] ways = new int[201];
        ways[0] = 1;

        for (int coin: coins) {
            for (int i: IntStream.rangeClosed(coin, TARGET).boxed().collect(Collectors.toList())) {
                ways[i] += ways[i - coin];
            }
        }

        return ways[TARGET];
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 31\n")
                .append("\n")
                .append("    In England the currency is made up of pound, \302\243, and pence, p, and\n")
                .append("    there are eight coins in general circulation:\n")
                .append("\n")
                .append("        1p, 2p, 5p, 10p, 20p, 50p, \302\2431 (100p) and \302\2432 (200p).\n")
                .append("\n")
                .append("    It is possible to make \302\2432 in the following way:\n")
                .append("\n")
                .append("        1\303\227\302\2431 + 1\303\22750p + 2\303\22720p + 1\303\2275p + 1\303\2272p + 3\303\2271p\n")
                .append("\n")
                .append("    How many different ways can \302\2432 be made using any number of coins?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %s different ways to get \302\2432 using any number of coins.\n", (long)this.Solve());
    }
}
