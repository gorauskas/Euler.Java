package com.gorauskas.euler.solutions;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gorauskas.euler.Euler;

public class Euler22 implements Euler {
    @Override
    public double Solve() {
        
        double result = 0;
       
        try {
            FileSystem fs;
            Path path;
            Map<String, String> env = new HashMap<>();
            URI uri = getClass().getResource("/p022_names.txt").toURI();
            
            // The data file provided is packaged in the JAR with the application by Maven,
            //   and therefore we have to switch between the 2 strategies below for opening it.
            //   One for the tests that run unpackaged, another for running within the packaged jar.
            if (uri.toString().contains("!")) {
                String[] p = uri.toString().split("!");
                fs = FileSystems.newFileSystem(URI.create(p[0]), env);
                path = fs.getPath(p[1]);
            } else {
                path = Paths.get(uri);
            }
            
            String data = Files.readAllLines(path).get(0);
            int pos = 1;
            
            List<String> names = Stream.of(data.split(","))  
                    .map(i -> new String(i))                 
                    .map(i -> i.replace("\"", ""))           
                    .sorted()                                
                    .collect(Collectors.toList());           

            for (String name: names) {
                result += this.getNameScore(name, pos);
                pos++;
            }
        } catch (IOException | URISyntaxException e) {
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
        String s = new StringBuilder()
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
        return s;
    }
    
    @Override
    public String getAnswer() {
        String s = String.format("The total of all the name scores in the file is %s"
                , (long)this.Solve());
        return s;
    }
}
