package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.util.stream.LongStream;

public class Euler3 implements Euler {

    @Override
    public double Solve() {
        long n = 600851475143l;
        return LongStream.rangeClosed(2, 775164)
                .filter(i -> n % i == 0 && Util.isPrime(i))
                .max()
                .getAsLong();

        //return loopStrategy();
    }

//    public double loopStrategy() {
//        long n = 600851475143l;
//        ArrayList<Long> all = new ArrayList<>();
//
//        for (long i = 2; i <= 775164; i++) {
//            if (n % i == 0 && Util.isPrime(i)) {
//                all.add(i);
//            }
//        }
//
//        return all.get(all.size() - 1);
//    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("Project Euler Problem 3:\n")
                .append("\n")
                .append("  The prime factors of 13195 are 5, 7, 13 and 29.\n")
                .append("\n")
                .append("  What is the largest prime factor of the number 600851475143 ?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The largest prime factor of the number 600851475143 is: %s"
                , this.Solve());
        return s;
    }
}
