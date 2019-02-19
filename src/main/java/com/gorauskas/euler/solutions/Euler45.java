package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Euler45 implements Euler {
    @Override
    public double Solve() {
        List<Long> tlist = LongStream.rangeClosed(1, 99999).map(x -> fnTri.apply(x)).boxed().collect(Collectors.toList());
        Set<Long> pset = LongStream.rangeClosed(1, 99999).map(x -> fnPenta.apply(x)).boxed().collect(Collectors.toSet());
        Set<Long> hset = LongStream.rangeClosed(1, 99999).map(x -> fnHex.apply(x)).boxed().collect(Collectors.toSet());

        for (long item : tlist) {
            if (pset.contains(item) && hset.contains(item)) {
                if (item > 40755) {
                    return item;
                }
            }
        }

        return 0;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 45\n")
                .append("\n")
                .append("    Triangle, pentagonal, and hexagonal numbers are generated by the following\n")
                .append("    formulae:\n")
                .append("\n")
                .append("        Triangle    Tn=n(n+1)/2    1, 3, 6, 10, 15, ...\n")
                .append("        Pentagonal  Pn=n(3n−1)/2   1, 5, 12, 22, 35, ...\n")
                .append("        Hexagonal   Hn=n(2n−1)     1, 6, 15, 28, 45, ...\n")
                .append("\n")
                .append("    It can be verified that T285 = P165 = H143 = 40755.\n")
                .append("\n")
                .append("    Find the next triangle number that is also pentagonal and hexagonal.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The next triangle number that is also pentagonal and hexagonal is %s\n",
                (long)this.Solve());
    }

    private Function<Long, Long> fnTri = x -> x * (x + 1) / 2;
    private Function<Long, Long> fnPenta = x -> x * (3 * x - 1) / 2;
    private Function<Long, Long> fnHex = x -> x * (2 * x - 1);
}