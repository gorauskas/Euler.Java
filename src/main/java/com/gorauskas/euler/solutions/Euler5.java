package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class Euler5 implements Euler {

    /**
     * Solve a simpler version of the problem. The lowest common multiple (LCM) of
     * two numbers x and y, usually denoted as lcm(x, y), is the smallest positive
     * number that is divisible by both x and y. You can do this by using the greatest
     * common divisor (GCD) function per the following formula:
     *
     *                |x . y|
     *   lcm(x, y) = ---------
     *               gcd(x, y)
     *
     * Above we transform the problem of computing the LCM into the problem of
     * computing the GCD. Next, observe that lcm(x,y,z) = lcm(lcm(x,y),z), thus
     * we can use reduce to apply LCM to the number from 1 to 20 and get to our
     * result.
     *
     * @return double
     */
    @Override
    public double Solve() {
        LongBinaryOperator lbo = (x, y) -> x * y / Util.gcd(x, y);
        return LongStream.rangeClosed(1, 20).reduce(lbo).getAsLong();

        //return loopStrategy();
    }

    /**
     * This original nested loop implementation takes 25 seconds to run.
     * @return double
     */
    public double loopStrategy() {
        int r = 0;

        for (int i = 1; i > 0; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i % j == 0) {
                    r++;
                }
            }

            if (r == 20) {
                return (double) i;
            }

            r = 0;
        }

        return 0;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 5:\n")
                .append("\n")
                .append("   2520 is the smallest number that can be divided by each of the \n")
                .append("   numbers from 1 to 10 without any remainder.\n")
                .append("\n")
                .append("   What is the smallest positive number that is evenly divisible \n")
                .append("   by all of the numbers from 1 to 20?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format(
                "The smallest positive number that is evenly divisible\n" +
                "by all of the numbers from 1 to 20 is: : %s"
                , (long)this.Solve());
    }
}
