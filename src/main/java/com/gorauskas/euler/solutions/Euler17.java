package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Euler17 implements Euler {
    private Map<Long, String> table;

    @Override
    public double Solve() {
        this.table = getLookupTable();
        StringBuilder res = new StringBuilder();
        for (Long x : LongStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList())) {
            res.append(this.spellNumberOut(x));
        }
        return res.toString().length();
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 17:\n")
                .append("\n")
                .append("    If the numbers 1 to 5 are written out in words: one, two, three, four, \n")
                .append("    five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\n")
                .append("\n")
                .append("    If all the numbers from 1 to 1000 (one thousand) inclusive were written \n")
                .append("    out in words, how many letters would be used?\n")
                .append("\n")
                .append("    NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and \n")
                .append("    forty-two) contains 23 letters and 115 (one hundred and fifteen) contains \n")
                .append("    20 letters. The use of 'and' when writing out numbers is in compliance \n")
                .append("    with British usage.\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The numbers from 1 to 1000, when written out in words, have %s letters.",
                (long)this.Solve());
        return s;
    }

    private Map<Long, String> getLookupTable() {
        Map<Long, String> table = new HashMap<>();
        table.put(1L, "one"); table.put(2L, "two"); table.put(3L, "three"); table.put(4L, "four"); table.put(5L, "five");
        table.put(6L, "six"); table.put(7L, "seven"); table.put(8L, "eight"); table.put(9L, "nine"); table.put(10L, "ten");
        table.put(11L, "eleven"); table.put(12L, "twelve"); table.put(13L, "thirteen"); table.put(14L, "fourteen"); table.put(15L, "fifteen");
        table.put(16L, "sixteen"); table.put(17L, "seventeen"); table.put(18L, "eighteen"); table.put(19L, "nineteen"); table.put(20L, "twenty");
        table.put(30L, "thirty"); table.put(40L, "forty"); table.put(50L, "fifty"); table.put(60L, "sixty"); table.put(70L, "seventy");
        table.put(80L, "eighty"); table.put(90L, "ninety"); table.put(100L, "hundred"); table.put(1000L, "thousand"); //table.put(0L, "zero");
        return table;
    }

    private String spellNumberOut(Long num) {
        StringBuilder buff = new StringBuilder();
        long dec_post_val = 99L;
        List<Long> nums = LongStream.of(
                new StringBuilder(num.toString())
                        .reverse()
                        .chars()
                        .map(c -> c - 48)
                        .asLongStream()
                        .toArray())
                .boxed()
                .collect(Collectors.toList());

        if (nums.size() == 4 && nums.get(3) != 0) {
            buff.append(this.table.get(nums.get(3)) + " thousand");
        }

        if (nums.size() >= 3 && nums.get(2) != 0) {
            buff.append(this.table.get(nums.get(2)) + " hundred");

            if (nums.size() >= 2 && nums.get(1) != 0) {
                buff.append(" and");
            } else if (nums.size() >= 1 && nums.get(0) != 0) {
                buff.append(" and");
            }
        }

        if (nums.size() >= 2 && nums.get(1) != 0) {
            dec_post_val = nums.get(1) * 10 + nums.get(0);
            if (dec_post_val <= 20) {
                buff.append(" " + this.table.get(dec_post_val));
            } else {
                buff.append(" " + this.table.get(nums.get(1) * 10));
            }
        }

        if (nums.size() >= 1 && nums.get(0) != 0 && dec_post_val > 20) {
            buff.append(" " + this.table.get(nums.get(0)));
        }

        return buff.toString().replace(" ", "");
    }
}
