package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Collectors;

import com.gorauskas.euler.streams.Permutations;

public class Euler43 implements Euler {

    // 1. there are only 3,628,800 (10!) 0 to 9 pandigital numbers, so there's no need
    //    to examine all 10 billion 10-digit numbers.
    // 2. consider only numbers whose last 3 digits divide by 17
    // 3. now only check the permutations of the 7 remaining digits
    // 4. this can be reduced further by considering the division by 13 and so on
    @Override
    public double Solve() {

        double sum = 0;

        List<LongStream> permuted_items = Permutations.of(LongStream.rangeClosed(0, 9)
                .boxed()
                .collect(Collectors.toList()))
                .map(i -> i.mapToLong(j -> j))
                .collect(Collectors.toList());

        for (LongStream item : permuted_items) {
            long[] l = item.toArray();

            if (F7.apply(l) && F6.apply(l) && F5.apply(l) && F4.apply(l) && F3.apply(l) && F2.apply(l) && F1.apply(l)) {

                sum += Util.concatListAsNumber(Arrays.stream(l).boxed().collect(Collectors.toList()));

            }
        }

        return sum;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 43\n")
                .append("\n")
                .append("    The number, 1406357289, is a 0 to 9 pandigital number because it is made up\n")
                .append("    of each of the digits 0 to 9 in some order, but it also has a rather interesting\n")
                .append("    sub-string divisibility property.\n")
                .append("\n")
                .append("    Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note\n")
                .append("    the following:\n")
                .append("\n")
                .append("      d2d3d4=406 is divisible by 2\n")
                .append("      d3d4d5=063 is divisible by 3\n")
                .append("      d4d5d6=635 is divisible by 5\n")
                .append("      d5d6d7=357 is divisible by 7\n")
                .append("      d6d7d8=572 is divisible by 11\n")
                .append("      d7d8d9=728 is divisible by 13\n")
                .append("      d8d9d10=289 is divisible by 17\n")
                .append("\n")
                .append("    Find the sum of all 0 to 9 pandigital numbers with this property.\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all 0 to 9 pandigital numbers with the property is %s", (long)this.Solve());
    }

    private Function<long[], Boolean> F1 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 1, 4)).boxed().collect(Collectors.toList())) % 2) == 0;
    private Function<long[], Boolean> F2 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 2, 5)).boxed().collect(Collectors.toList())) % 3) == 0;
    private Function<long[], Boolean> F3 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 3, 6)).boxed().collect(Collectors.toList())) % 5) == 0;
    private Function<long[], Boolean> F4 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 4, 7)).boxed().collect(Collectors.toList())) % 7) == 0;
    private Function<long[], Boolean> F5 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 5, 8)).boxed().collect(Collectors.toList())) % 11) == 0;
    private Function<long[], Boolean> F6 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 6, 9)).boxed().collect(Collectors.toList())) % 13) == 0;
    private Function<long[], Boolean> F7 = x -> (Util.concatListAsNumber(Arrays.stream(Arrays.copyOfRange(x, 7, x.length)).boxed().collect(Collectors.toList())) % 17) == 0;

}