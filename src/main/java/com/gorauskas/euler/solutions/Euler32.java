package com.gorauskas.euler.solutions;

import java.util.ArrayList;
import java.util.List;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler32 implements Euler {
    @Override
    public double Solve() {
        List<Long> prods = new ArrayList<>();
        long sum = 0;
        long p, comp;

        for (long m = 2; m < 100; m++) {
            long nbegin = (m > 9) ? 123 : 1234;
            long nend = 10000 / m + 1;
            for (long n = nbegin; n < nend; n++) {
                p = m * n;
                comp = Util.concatNumbers(Util.concatNumbers(p, n), m);

                if (comp >= 1E8 && comp < 1E9 && Util.isPanDigital(comp)) {
                    if (!prods.contains(p)) {
                        prods.add(p);
                    }
                } 
            }
        }

        for (int i = 0; i < prods.size(); i++) {
            sum += prods.get(i);
        }

        return (double)sum;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 32:\n")
                .append("\n")
                .append("    We shall say that an n-digit number is pandigital if it makes use of all the\n")
                .append("    digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1\n")
                .append("    through 5 pandigital.\n")
                .append("    \n")
                .append("    The product 7254 is unusual, as the identity, 39 \303\227 186 = 7254, containing\n")
                .append("    multiplicand, multiplier, and product is 1 through 9 pandigital.\n")
                .append("    \n")
                .append("    Find the sum of all products whose multiplicand/multiplier/product identity can\n")
                .append("    be written as a 1 through 9 pandigital.\n")
                .append("    \n")
                .append("    HINT: Some products can be obtained in more than one way so be sure to only\n")
                .append("    include it once in your sum.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all products whose multiplicand/multiplier/product\n" +
                "identity can be written as a 1 through 9 pandigital is %s\n", (long)this.Solve());
    }
}

