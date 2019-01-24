package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler38 implements Euler {
    @Override
    public double Solve() {
        List<BigInteger> lbi = new ArrayList<>();

        for (int n : IntStream.rangeClosed(1, 9999).boxed().collect(Collectors.toList())) {
            for (int m : IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList())) {
                BigInteger bi = concatenatedProduct(n, m);

                if (Util.isPanDigital(bi.toString())) {
                    lbi.add(bi);
                }
            }
        }

        return lbi.stream().map(x -> x.longValue()).max(Comparator.naturalOrder()).get();
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 38\n")
                .append("\n")
                .append("    Take the number 192 and multiply it by each of 1, 2, and 3:\n")
                .append("\n")
                .append("      192 * 3 = 576\n")
                .append("      192 * 1 = 192\n")
                .append("      192 * 2 = 384\n")
                .append("\n")
                .append("    By concatenating each product we get the 1 to 9 pandigital, 192384576. We\n")
                .append("    will call 192384576 the concatenated product of 192 and (1,2,3)\n")
                .append("    The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,\n")
                .append("    and 5, giving the pandigital, 918273645, which is the concatenated product\n")
                .append("    of 9 and (1,2,3,4,5).\n")
                .append("\n")
                .append("    What is the largest 1 to 9 pandigital 9-digit number that can be formed as\n")
                .append("    the concatenated product of an integer with (1,2, ... , n) where n > 1?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        return String.format("The largest 1 to 9 pandigital 9-digit number is %s", (long)this.Solve());
    }

    private BigInteger concatenatedProduct(int n, int m) {
        List<String> ls = new ArrayList<>();

        for (int i : IntStream.rangeClosed(1, m + 1).boxed().collect(Collectors.toList())) {
            ls.add(String.valueOf(n * i));
        }

        return new BigInteger(String.join("", ls));
    }
}
