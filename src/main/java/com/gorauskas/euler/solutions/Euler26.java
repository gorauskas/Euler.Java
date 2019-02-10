package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import static com.gorauskas.euler.streams.StreamUtil.primeSequence;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repeating decimal Totient Rule = https://en.wikipedia.org/wiki/Repeating_decimal#Totient_rule
 * Primitive root modulo n = https://en.wikipedia.org/wiki/Primitive_root_modulo_n
 * Euler's totient function = https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * Full reptend prime = https://en.wikipedia.org/wiki/Full_reptend_prime
 */
public class Euler26 implements Euler {

    @Override
    public double Solve() {
        List<Long> ps = primeSequence(1000).boxed().collect(Collectors.toList());
        Collections.reverse(ps);
        int seqlen = 0;

        for (Long p: ps) {
            if (seqlen >= p)
                break;

            int[] rems = new int[p.intValue()];
            int val = 1;
            int pos = 0;

            while (rems[val] == 0 && val != 0) {
                rems[val] = pos;
                val *= 10;
                val %= p.intValue();
                pos++;
            }

            if (pos - rems[val] > seqlen)
                seqlen = pos - rems[val];
        }

        return seqlen + 1;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 26\n")
                .append("\n")
                .append("    A unit fraction contains 1 in the numerator. The decimal representation of\n")
                .append("    the unit fractions with denominators 2 to 10 are given:\n")
                .append("\n")
                .append("    1/2 =  0.5\n")
                .append("    1/3 =  0.(3)\n")
                .append("    1/4 =  0.25\n")
                .append("    1/5 =  0.2\n")
                .append("    1/6 =  0.1(6)\n")
                .append("    1/7 =  0.(142857)\n")
                .append("    1/8 =  0.125\n")
                .append("    1/9 =  0.(1)\n")
                .append("    1/10 =  0.1\n")
                .append("\n")
                .append("    Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can\n")
                .append("    be seen that 1/7 has a 6-digit recurring cycle.\n")
                .append("\n")
                .append("    Find the value of d < 1000 for which 1/d contains the longest recurring\n")
                .append("    cycle in its decimal fraction part.\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The value of d > 1000 for which 1/d contains the longest recurring \n" +
                        "cycle in its decimal fraction part is %s\n", (long)this.Solve());
        return s;
    }
}
