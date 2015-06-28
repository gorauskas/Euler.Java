package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

public class Euler5 implements Euler {

    @Override
    public double Solve() {
        int r = 0;

        for (int i = 1; i > 0; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i % j == 0) {
                    r++;
                }
            }

            if (r == 20) {
                return (double) i;
            }

            r = 0;
        }

        return 0;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 5:\n")
                .append("\n")
                .append("   2520 is the smallest number that can be divided by each of the \n")
                .append("   numbers from 1 to 10 without any remainder.\n")
                .append("\n")
                .append("   What is the smallest positive number that is evenly divisible \n")
                .append("   by all of the numbers from 1 to 20?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format(
                "The smallest positive number that is evenly divisible\n" +
                "by all of the numbers from 1 to 20 is: : %s"
                , (long)this.Solve());
        return s;
    }
}
