package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler15 implements Euler {

    @Override
    public double Solve() {
        return Util.factorial(40).divide(Util.factorial(20).multiply(Util.factorial(20))).doubleValue();
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 15:\n")
                .append("\n")
                .append("    Starting in the top left corner of a 2x2 grid, there are 6 routes\n")
                .append("    (without backtracking) to the bottom right corner.\n")
                .append("\n")
                .append("    How many routes are there through a 20x20 grid?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("There are %s routes through a 20x20 grid"
                , (long)this.Solve());
        return s;
    }
}
