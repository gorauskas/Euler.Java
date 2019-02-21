package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler15 implements Euler {

    /**
     * This is a combinations problem. on a 20x20 grid to get from top-left to
     * bottom-right there are 40 moves (20 down and 20 right). The problem can be
     * solved by applying the formula for the central binomial coefficient
     * (http://en.wikipedia.org/wiki/Central_binomial_coefficient):
     *
     *                x!
     *   C(x,y) = -----------
     *            y! * (x-y)!
     *
     * @return double
     */
    @Override
    public double Solve() {
        var moves = 40.0;
        var dirs = 20.0;

        return Util.factorial(moves) / (Util.factorial(moves - dirs) * Util.factorial(dirs));
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 15:\n")
                .append("\n")
                .append("    Starting in the top left corner of a 2x2 grid, there are 6 routes\n")
                .append("    (without backtracking) to the bottom right corner.\n")
                .append("\n")
                .append("    How many routes are there through a 20x20 grid?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %s routes through a 20x20 grid"
                , (long)this.Solve());
    }
}
