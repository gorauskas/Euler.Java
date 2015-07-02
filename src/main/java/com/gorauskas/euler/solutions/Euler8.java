package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.List;
import java.util.function.LongBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Euler8 implements Euler {

    @Override
    public double Solve() {
        List<Long> nums = this.getNums();
        long greatest = 0, i = 0;
        LongBinaryOperator ibo = (a, b) -> a * b;

        while (i + 13 <= nums.size()) {
            long x = nums
                    .stream()
                    .mapToLong(Long::intValue)
                    .skip(i)
                    .limit(13)
                    .reduce(ibo)
                    .getAsLong();

            if (greatest < x)
                greatest = x;

            i++;
        }

        return (double)greatest;
    }

    @Override
    public String getProblem() {
        String s = new StringBuilder()
                .append("The four adjacent digits in the 1000-digit number that have the greatest\n")
                .append("product are 9 × 9 × 8 × 9 = 5832.\n")
                .append("\n")
                .append(this.getStringNums())
                .append("\n")
                .append("Find the thirteen adjacent digits in the 1000-digit number that have \n")
                .append("the greatest product. What is the value of this product?\n")
                .toString();
        return s;
    }

    @Override
    public String getAnswer() {
        String s = String.format("The value of the product of 13 adjacent numbers with greatest\n" +
                "product is %s", (long)this.Solve());
        return s;
    }

    private List<Long> getNums() {
        return LongStream.of(new StringBuilder()
                    .append(this.getStringNums())
                    .toString()
                    .replace(" ", "")
                    .replace("\n", "")
                    .chars()
                    .map(c -> c - 48)
                    .asLongStream()
                    .toArray())
                .boxed()
                .collect(Collectors.toList());
    }

    private String getStringNums() {
        return new StringBuilder()
                .append("73167176531330624919225119674426574742355349194934\n")
                .append("96983520312774506326239578318016984801869478851843\n")
                .append("85861560789112949495459501737958331952853208805511\n")
                .append("12540698747158523863050715693290963295227443043557\n")
                .append("66896648950445244523161731856403098711121722383113\n")
                .append("62229893423380308135336276614282806444486645238749\n")
                .append("30358907296290491560440772390713810515859307960866\n")
                .append("70172427121883998797908792274921901699720888093776\n")
                .append("65727333001053367881220235421809751254540594752243\n")
                .append("52584907711670556013604839586446706324415722155397\n")
                .append("53697817977846174064955149290862569321978468622482\n")
                .append("83972241375657056057490261407972968652414535100474\n")
                .append("82166370484403199890008895243450658541227588666881\n")
                .append("16427171479924442928230863465674813919123162824586\n")
                .append("17866458359124566529476545682848912883142607690042\n")
                .append("24219022671055626321111109370544217506941658960408\n")
                .append("07198403850962455444362981230987879927244284909188\n")
                .append("84580156166097919133875499200524063689912560717606\n")
                .append("05886116467109405077541002256983155200055935729725\n")
                .append("71636269561882670428252483600823257530420752963450\n")
                .toString();
    }
}
