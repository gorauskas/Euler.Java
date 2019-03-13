package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Euler55 implements Euler {
    @Override
    public double Solve() {
        return IntStream.rangeClosed(1, 10000).filter(x -> isLychrel(x)).count();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 55\n")
                .append("\n")
                .append("    If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.\n")
                .append("    Not all numbers produce palindromes so quickly. For example,\n")
                .append("\n")
                .append("        349 + 943 = 1292,\n")
                .append("        1292 + 2921 = 4213\n")
                .append("        4213 + 3124 = 7337\n")
                .append("\n")
                .append("    That is, 349 took three iterations to arrive at a palindrome.\n")
                .append("    Although no one has proved it yet, it is thought that some numbers, like\n")
                .append("    196, never produce a palindrome. A number that never forms a palindrome\n")
                .append("    through the reverse and add process is called a Lychrel number. Due to the\n")
                .append("    theoretical nature of these numbers, and for the purpose of this problem,\n")
                .append("    we shall assume that a number is Lychrel until proven otherwise. In\n")
                .append("    addition you are given that for every number below ten-thousand, it will\n")
                .append("    either (i) become a palindrome in less than fifty iterations, or, (ii) no\n")
                .append("    one, with all the computing power that exists, has managed so far to map it\n")
                .append("    to a palindrome. In fact, 10677 is the first number to be shown to require\n")
                .append("    over fifty iterations before producing a palindrome:\n")
                .append("    4668731596684224866951378664 (53 iterations, 28-digits).\n")
                .append("\n")
                .append("    Surprisingly, there are palindromic numbers that are themselves Lychrel\n")
                .append("    numbers; the first example is 4994.\n")
                .append("\n")
                .append("    How many Lychrel numbers are there below ten-thousand?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %s Lychrel numbers below ten thousand.", (long)this.Solve());
    }

    private boolean isLychrel(long num) {
        long res;

        for (int i = 0; i < 30; i++) {
            res = reverseNumber(num);
            num = num + res;

            if (Util.isPalindrome(num)) {
                return false;
            }
        }

        return true;
    }

    private long reverseNumber(long num) {
        if (num < 0) {
            return num;
        }

        long res = 0;

        while (num != 0) {
            res = res * 10 + num % 10;
            num = num / 10;
        }

        return res;
    }
}
