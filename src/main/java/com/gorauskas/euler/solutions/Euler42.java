package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.gorauskas.euler.streams.StreamUtil;

public class Euler42 implements Euler {

    @Override
    public double Solve() {
        var count = 0;
        var triangleNums = StreamUtil.triangleNumberSequence(100).boxed().collect(Collectors.toList());

        try {
            var uri = getClass().getResource("/p042_words.txt").toURI();
            var data = Util.getDataFromFile(uri);

            var words = Stream.of(data.split(","))
                    .map(item -> new String(item))
                    .map(item -> item.replace("\"", ""))
                    .collect(Collectors.toList());

            for (var word : words) {
                if (triangleNums.contains(this.getWordScore(word))) {
                    count++;
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 42\n")
                .append("\n")
                .append("    The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:\n")
                .append("\n")
                .append("        1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...\n")
                .append("\n")
                .append("    By converting each letter in a word to a number corresponding to its alphabetical position and adding these values\n")
                .append("    we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a\n")
                .append("    triangle number then we shall call the word a triangle word.\n")
                .append("\n")
                .append("    Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common\n")
                .append("    English words, how many are triangle words?\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("There are %s triangle words in the file.", (long)this.Solve());
    }

    private int getWordScore(String word) {
        return word.chars()
                .mapToObj(c -> (char)c)
                .mapToInt(i -> i - 64)
                .sum();
    }
}
