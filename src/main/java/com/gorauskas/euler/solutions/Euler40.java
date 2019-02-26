package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler40 implements Euler {
    @Override
    public double Solve() {
        var L = IntStream.rangeClosed(0, 1000000).boxed().collect(Collectors.toList());
        var LS = Util.concatListAsString(L);

        return Integer.parseInt(Character.toString(LS.charAt(1))) *
                Integer.parseInt(Character.toString(LS.charAt(10))) *
                Integer.parseInt(Character.toString(LS.charAt(100))) *
                Integer.parseInt(Character.toString(LS.charAt(1000))) *
                Integer.parseInt(Character.toString(LS.charAt(10000))) *
                Integer.parseInt(Character.toString(LS.charAt(100000))) *
                Integer.parseInt(Character.toString(LS.charAt(1000000)));
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 40\n")
                .append("\n")
                .append("    An irrational decimal fraction is created by concatenating the positive\n")
                .append("    integers:\n")
                .append("\n")
                .append("        0.123456789101112131415161718192021...\n")
                .append("                     ^\n")
                .append("\n")
                .append("    It can be seen that the 12th digit of the fractional part is 1.\n")
                .append("\n")
                .append("    If dn represents the nth digit of the fractional part, find the value of\n")
                .append("    the following expression.\n")
                .append("\n")
                .append("        d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The value is %s", (long)this.Solve());
    }
}

