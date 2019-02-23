package com.gorauskas.euler.solutions;

import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gorauskas.euler.Euler;
import com.gorauskas.euler.Util;

public class Euler22 implements Euler {
    @Override
    public double Solve() {
        
        var result = 0;
       
        try {
            var uri = getClass().getResource("/p022_names.txt").toURI();
            var data = Util.getDataFromFile(uri);
            var pos = 1;
            
            var names = Stream.of(data.split(","))
                    .map(i -> new String(i))                 
                    .map(i -> i.replace("\"", ""))           
                    .sorted()                                
                    .collect(Collectors.toList());           

            for (var name: names) {
                result += this.getNameScore(name, pos);
                pos++;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
            
        return result;
        
    }
    
    private int getNameScore(String name, int pos) {
        return pos * name.chars()
                .mapToObj(i -> (char)i)
                .mapToInt(i -> i - 64)
                .sum();
    }
    
    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 22\n")
                .append("\n")
                .append("    Using names.txt (right click and 'Save Link/Target As...'), a 46K text\n")
                .append("    file containing over five-thousand first names, begin by sorting it\n")
                .append("    into alphabetical order. Then working out the alphabetical value for\n")
                .append("    each name, multiply this value by its alphabetical position in the list\n")
                .append("    to obtain a name score.\n")
                .append("\n")
                .append("    For example, when the list is sorted into alphabetical order, COLIN, which\n")
                .append("    is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN\n")
                .append("    would obtain a score of 938 × 53 = 49714.\n")
                .append("\n")
                .append("    What is the total of all the name scores in the file?\n")
                .toString();
    }
    
    @Override
    public String getAnswer() {
        return String.format("The total of all the name scores in the file is %s"
                , (long)this.Solve());
    }
}
