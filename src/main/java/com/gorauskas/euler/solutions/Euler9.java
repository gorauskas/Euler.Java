package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

public class Euler9 implements Euler {

    @Override
    public double Solve() {
        int r = 0;

        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                for (int c = b + 1; c < 1000; c++) {
                    if ((a + b + c == 1000) && ((a*a) + (b*b) == (c*c))) {
                        r = a * b * c;
                        break;
                    }
                }
            }
        }

        return r;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 9:\n")
                .append("\n")
                .append("   A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n")
                .append("\n")
                .append("    a^2 + b^2 = c^2\n")
                .append("    For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.\n")
                .append("\n")
                .append("   There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n")
                .append("   Find the product abc.\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The product of the pythagorean triple whose\n" +
                "sum equals 1000 is: %s"
                , (long)this.Solve());
        return s;
    }
}
