package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler23 implements Euler {

    /**
     * According to Wolfram Mathworld’s discussion on Abundant Numbers
     * [http://mathworld.wolfram.com/AbundantNumber.html]: "Every number
     * greater than 20161 can be expressed as a sum of two abundant numbers."
     * So our upper bound lowered to 20161 (+1) from 28123.
     */
    private static final int EULER23_MAX = 20162;

    @Override
    public double Solve() {

        Set<Integer> iset = calcSumsOfTwoAbundants(IntStream.range(1, EULER23_MAX)
                .filter(i -> Util.sumOfDivisors(i) > i));

        return IntStream.range(1, EULER23_MAX)
                .filter(x -> !iset.contains(x))
                .sum();

    }

    private Set<Integer> calcSumsOfTwoAbundants(IntStream abundants) {

        int[] arr = abundants.toArray();

        return IntStream.range(0, arr.length - 2)
                .flatMap(i -> IntStream.range(i, arr.length - 1)
                        .map(j -> arr[i] + arr[j])
                        .filter(s -> s <= EULER23_MAX))
                .boxed()
                .collect(Collectors.toSet());

    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 23\n")
                .append("\n")
                .append("    A perfect number is a number for which the sum of its proper divisors is\n")
                .append("    exactly equal to the number. For example, the sum of the proper divisors\n")
                .append("    of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect\n") 
                .append("    number.\n") 
                .append("\n") 
                .append("    A number n is called deficient if the sum of its proper divisors is less\n") 
                .append("    than n and it is called abundant if this sum exceeds n.\n") 
                .append("\n") 
                .append("    As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest\n") 
                .append("    number that can be written as the sum of two abundant numbers is 24. By\n") 
                .append("    mathematical analysis, it can be shown that all integers greater than 28123\n") 
                .append("    can be written as the sum of two abundant numbers. However, this upper limit\n") 
                .append("    cannot be reduced any further by analysis even though it is known that the\n") 
                .append("    greatest number that cannot be expressed as the sum of two abundant numbers\n") 
                .append("    is less than this limit.\n") 
                .append("\n") 
                .append("    Find the sum of all the positive integers which cannot be written as the sum\n") 
                .append("    of two abundant numbers.\n") 
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The sum of all the positive integers which cannot be written as the sum of two\n"
                + "abundant numbers is %s"
                , (long)this.Solve());
        return s;
    }

}
