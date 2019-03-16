package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler58 implements Euler {
    @Override
    public double Solve() {
        int sl = 3;  // side length
        int dc = 5;  // diagonal count
        int pc = 0;  // prime count

        while (true) {
            int l = sl - 1;  // limit

            for (int c = sl * sl, i = 0; i < 4; i++, c -= l) {
                if (Util.isPrime(c)) {
                    pc++;
                }
            }

            sl += 2;
            dc += 4;

            if (dc > 10 * pc) {
                break;
            }
        }

        return sl;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 58\n")
                .append("\n")
                .append("    Starting with 1 and spiralling anticlockwise in the following way, a square\n")
                .append("    spiral with side length 7 is formed.\n")
                .append("\n")
                .append("        37 36 35 34 33 32 31\n")
                .append("        38 17 16 15 14 13 30\n")
                .append("        39 18  5  4  3 12 29\n")
                .append("        40 19  6  1  2 11 28\n")
                .append("        41 20  7  8  9 10 27\n")
                .append("        42 21 22 23 24 25 26\n")
                .append("        43 44 45 46 47 48 49\n")
                .append("\n")
                .append("    It is interesting to note that the odd squares lie along the bottom right\n")
                .append("    diagonal, but what is more interesting is that 8 out of the 13 numbers\n")
                .append("    lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.\n")
                .append("\n")
                .append("    If one complete new layer is wrapped around the spiral above, a square\n")
                .append("    spiral with side length 9 will be formed. If this process is continued,\n")
                .append("    what is the side length of the square spiral for which the ratio of primes\n")
                .append("    along both diagonals first falls below 10%?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The side length of the square spiral is %s", (long)this.Solve());
    }
}
