package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Euler36 implements Euler {

    @Override
    public double Solve() {
        var L = new ArrayList<Long>();

        for (var num : LongStream.rangeClosed(1, 999999).boxed().collect(Collectors.toList())) {
            Long rev = Long.parseLong(new StringBuilder(num.toString()).reverse().toString());
            if (num.toString().equals(rev.toString())) {
                var revbstr = new StringBuilder(Long.toBinaryString(num)).reverse().toString();
                if (Long.toBinaryString(num).equals(revbstr)) {
                    L.add(num);
                }
            }
        }

        return L.stream().mapToLong(l -> l).sum();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 36:\n")
                .append("\n")
                .append("    The decimal number, 585 = 1001001001v2 (binary), is palindromic in both\n")
                .append("    bases.\n")
                .append("\n")
                .append("    Find the sum of all numbers, less than one million, which are palindromic\n")
                .append("    in base 10 and base 2.\n")
                .append("\n")
                .append("    (Please note that the palindromic number, in either base, may not include\n")
                .append("    leading zeros.)\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The sum of all palindromic numbers in base 10 and 2 is %d\n", (long)this.Solve());
    }
}



