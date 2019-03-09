package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler52 implements Euler {
    @Override
    public double Solve() {
        int n = 99999;

        while (!(Util.sorted(String.valueOf(n)).equals(Util.sorted(String.valueOf(n * 2))) &&
                Util.sorted(String.valueOf(n)).equals(Util.sorted(String.valueOf(n * 3))) &&
                Util.sorted(String.valueOf(n)).equals(Util.sorted(String.valueOf(n * 4))) &&
                Util.sorted(String.valueOf(n)).equals(Util.sorted(String.valueOf(n * 5))) &&
                Util.sorted(String.valueOf(n)).equals(Util.sorted(String.valueOf(n * 6))))) {

            n += 9;

        }

        return n;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 52\n")
                .append("\n")
                .append("    It can be seen that the number, 125874, and its double, 251748, contain\n")
                .append("    exactly the same digits, but in a different order.\n")
                .append("\n")
                .append("    Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,\n")
                .append("    contain the same digits.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The smallest positive integer is %s", (long)this.Solve());
    }
}
