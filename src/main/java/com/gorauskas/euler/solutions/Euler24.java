package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.streams.Permutations;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler24 implements Euler {
    @Override
    public double Solve() {
        return Double.parseDouble(Permutations.of(IntStream.rangeClosed(0, 9)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList())
                .get(999999)
                .map(i -> i.toString())
                .collect(Collectors.joining("")));

    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 24\n")
                .append("\n")
                .append("    A permutation is an ordered arrangement of objects. For example,\n")
                .append("    3124 is one possible permutation of the digits 1, 2, 3 and 4. If\n")
                .append("    all of the permutations are listed numerically or alphabetically,\n")
                .append("    we call it lexicographic order. The lexicographic permutations of\n")
                .append("    0, 1 and 2 are:\n")
                .append("\n")
                .append("        012   021   102   120   201   210\n")
                .append("\n")
                .append("    What is the millionth lexicographic permutation of the digits\n")
                .append("    0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The millionth lexicographic permutation of the digits 0 through 9 is %s\n"
                , (long)this.Solve());
        return s;
    }
}
