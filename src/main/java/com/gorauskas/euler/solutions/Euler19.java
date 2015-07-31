package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.stream.LongStream;

public class Euler19 implements Euler {

    @Override
    public double Solve() {
        return LongStream.rangeClosed(1901, 2000)
                .flatMap(y -> LongStream.rangeClosed(1, 12)
                        .filter(m -> dayOfWeek(y, m, 1) == 0))
                .count();
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 19:\n")
                .append("\n")
                .append("    You are given the following information, but you may prefer to do some research for yourself.\n")
                .append("\n")
                .append("    - 1 Jan 1900 was a Monday.\n")
                .append("    - Thirty days has September, April, June and November.\n")
                .append("    - All the rest have thirty-one, saving February alone, which has twenty-eight, rain or shine.\n")
                .append("    - And on leap years, twenty-nine.\n")
                .append("    - A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.\n")
                .append("\n")
                .append("    How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("There were %s Sundays falling on the first of the month in the twentieth century."
                , (long)this.Solve());
        return s;
    }

    /**
     * Zeller's congruence - https://en.wikipedia.org/wiki/Zeller%27s_congruence
     * @param year - The Year
     * @param month - The Month
     * @param day - The Day
     * @return A number from 0 to 6 representing the day of the week; 0 = Sunday
     */
    private long dayOfWeek(long year, long month, long day) {
        long m = mod(month - 3, 48000);
        long y = mod(year + m / 12, 400);
        m %= 12;
        return (int)((y + y / 4 - y / 100 + (13 * m + 2) / 5 + day + 2) % 7);
    }

    /**
     * The formulas rely on the mathematician's definition of modulo division, which means that −2 mod 7 is equal to
     * positive 5. Unfortunately, the way most computer languages implement the remainder function, −2 mod 7 returns a
     * result of −2.
     * @param i The first operand
     * @param j The second operand
     * @return The remainder
     */
    private long mod(long i, long j) {
        i %= j;

        if (j > 0 && i < 0 || j < 0 && i > 0) {
            i += j;
        }

        return i;
    }


}
