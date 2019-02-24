package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler27 implements Euler {
    @Override
    public double Solve() {

        var max = 0;
        var res = 0;

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                var done = false;
                var count = 0;

                while (!done) {
                    var num = count * count + x * count + y;

                    if (num > 0 && Util.isPrime(num)) {
                        count++;
                    } else {
                        done = true;
                    }

                    if (count > max) {
                        max = count;
                        res = x * y;
                    }
                }
            }
        }

        return res;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 27\n")
                .append("\n")
                .append("    Euler discovered the remarkable quadratic formula:\n")
                .append("\n")
                .append("        n2+n+41\n")
                .append("\n")
                .append("    It turns out that the formula will produce 40 primes for the consecutive\n")
                .append("    integer values 0≤n≤39. However, when n=40,402+40+41=40(40+1)+41 is divisible by\n")
                .append("    41, and certainly when n=41,412+41+41 is clearly divisible by 41.\n")
                .append("\n")
                .append("    The incredible formula n2−79n+1601 was discovered, which produces 80 primes for\n")
                .append("    the consecutive values 0≤n≤79. The product of the coefficients, −79 and 1601,\n")
                .append("    is −126479.\n")
                .append("\n")
                .append("    Considering quadratics of the form:\n")
                .append("\n")
                .append("        n2+an+b, where |a|<1000 and |b|≤1000\n")
                .append("\n")
                .append("        where |n| is the modulus/absolute value of n\n")
                .append("\n")
                .append("        e.g. |11|=11 and |−4|=4\n")
                .append("\n")
                .append("    Find the product of the coefficients, a and b, for the quadratic expression\n")
                .append("    that produces the maximum number of primes for consecutive values of n,\n")
                .append("    starting with n=0.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The product of the coefficients, a and b, for the quadratic expression that produces\n" +
                "the maximum number of primes for consecutive values of n is %s\n", (long)this.Solve());
    }
}
