package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

public class Euler39 implements Euler {
    @Override
    public double Solve() {
        long result = 0;
        long resultSolutions = 0;

        for (long p = 2; p <= 1000; p += 2) {
            int numberOfSolutions = 0;

            for (long a = 2; a < (p / 3); a++) {
                if (p * (p - 2 * a) % (2 * (p - a)) == 0) {
                    numberOfSolutions++;
                }
            }

            if (numberOfSolutions > resultSolutions) {
                resultSolutions = numberOfSolutions;
                result = p;
            }
        }

        return result;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 39\n")
                .append("\n")
                .append("    If p is the perimeter of a right angle triangle with integral length sides,\n")
                .append("    {a,b,c}, there are exactly three solutions for p = 120.\n")
                .append("\n")
                .append("        {20,48,52}, {24,45,51}, {30,40,50}\n")
                .append("\n")
                .append("    For which value of p ≤ 1000, is the number of solutions maximised?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        return String.format("The number of solutions is maximized for %s", (long)this.Solve());
    }
}
