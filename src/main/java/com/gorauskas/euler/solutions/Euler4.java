package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler4 implements Euler {

    @Override
    public double Solve() {
        long x = 0;
        long y = 0;

        for (int i=999; i > 99; i--) {
            for (int j = i; j > 99; j--) {
                x = i * j;

                if (Util.isPalindrome(x)) {
                    if (x > y) {
                        y = x;
                    }
                }
            }
        }

        return (double) y;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 4:\n")
                .append("\n")
                .append("   A palindromic number reads the same both ways. The largest palindrome made\n")
                .append("   from the product of two 2-digit numbers is 9009 = 91  99.\n")
                .append("\n")
                .append("   Find the largest palindrome made from the product of two 3-digit numbers.\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The largest palindrome made of the product of two 3 digit numbers is %s"
                , this.Solve());
        return s;
    }
}
