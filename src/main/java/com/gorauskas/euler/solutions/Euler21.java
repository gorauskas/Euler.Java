package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;


public class Euler21 implements Euler {
    @Override
    public double Solve() {
        double ansum = 0;

        for (int i = 1; i < 9999; i++) {
            if (Util.sumOfDivisors(Util.sumOfDivisors(i)) == i && i != Util.sumOfDivisors(i)) {
                ansum += i;
            }
        }

        return ansum;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 21:\n")
                .append("\n")
                .append("  Let d(n) be defined as the sum of proper divisors of n (numbers less than n which\n")
                .append("  divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a and b are an\n")
                .append("  amicable pair and each of a and b are called amicable numbers.\n")
                .append("\n")
                .append("  For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and\n")
                .append("  110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142;\n")
                .append("  so d(284) = 220.\n")
                .append("\n")
                .append("  Evaluate the sum of all the amicable numbers under 10000.\n")
                .append("\n")
                .toString();

        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The sum of all the amicable numbers under 10000 is %s"
                , (int)this.Solve());
        return s;
    }
}
