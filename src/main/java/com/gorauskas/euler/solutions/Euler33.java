package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

public class Euler33 implements Euler {

    @Override
    public double Solve() {
        var d = 1.0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 1; k < j; k++) {
                    int ki = k * 10 + i;
                    float ij = (float)(i * 10 + j);

                    if (k * ij == ki * j) {
                        d *= ij / ki;
                    }
                }
            }
        }

        return d;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 33:")
                .append("\n")
                .append("    The fraction 49/98 is a curious fraction, as an inexperienced mathematician\n")
                .append("    in attempting to simplify it may incorrectly believe that 49/98 = 4/8,\n")
                .append("    which is correct, is obtained by cancelling the 9s.\n")
                .append("\n")
                .append("    We shall consider fractions like, 30/50 = 3/5, to be trivial examples.\n")
                .append("\n")
                .append("    There are exactly four non-trivial examples of this type of fraction, less\n")
                .append("    than one in value, and containing two digits in the numerator and\n")
                .append("    denominator.\n")
                .append("\n")
                .append("    If the product of these four fractions is given in its lowest common terms,\n")
                .append("    find the value of the denominator.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The value of the denominator is: %s\n", (long)this.Solve());
    }
}