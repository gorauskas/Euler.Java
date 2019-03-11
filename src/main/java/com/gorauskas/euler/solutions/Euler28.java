package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import static java.lang.Math.pow;

public class Euler28 implements Euler {

    /**
     * You don't have to actually construct the spiral to solve this problem.
     * This is a simple summation problem and therefore the result can be expressed
     * by a formula which is presented below
     */
    @Override
    public double Solve() {
        var n = 500;
        return (long)(((16 * pow(n, 3) + 26 * n) / 3 + 10 * pow(n, 2)) + 1);
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 28\n")
                .append("\n")
                .append("    Starting with the number 1 and moving to the right in a clockwise direction\n")
                .append("    a 5 by 5 spiral is formed as follows:\n")
                .append("\n")
                .append("        21 22 23 24 25\n")
                .append("        20  7  8  9 10\n")
                .append("        19  6  1  2 11\n")
                .append("        18  5  4  3 12\n")
                .append("        17 16 15 14 13\n")
                .append("\n")
                .append("    It can be verified that the sum of the numbers on the diagonals is 101.\n")
                .append("\n")
                .append("    What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral\n")
                .append("    formed in the same way?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of the numbers on the diagonals in a 1001 by 1001 spiral is %s\n"
                , (long)this.Solve());
    }
}
