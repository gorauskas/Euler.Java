package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Euler18 implements Euler {
    @Override
    public double Solve() {
        return this.findMaxSum(this.getTriangle(this.getData()));
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                .append("Project Euler Problem 18:\n")
                .append("\n")
                .append("    By starting at the top of the triangle below and moving to adjacent numbers \n")
                .append("    on the row below, the maximum total from top to bottom is 23.\n")
                .append("\n")
                .append("       3\n")
                .append("      7 4\n")
                .append("     2 4 6\n")
                .append("    8 5 9 3\n")
                .append("\n")
                .append("    That is, 3 + 7 + 4 + 9 = 23.\n")
                .append("\n")
                .append("    Find the maximum total from top to bottom of the triangle below:\n")
                .append("\n")
                .append("                  75\n")
                .append("                 95 64\n")
                .append("                17 47 82\n")
                .append("               18 35 87 10\n")
                .append("              20 04 82 47 65\n")
                .append("             19 01 23 75 03 34\n")
                .append("            88 02 77 73 07 63 67\n")
                .append("           99 65 04 28 06 16 70 92\n")
                .append("          41 41 26 56 83 40 80 70 33\n")
                .append("         41 48 72 33 47 32 37 16 94 29\n")
                .append("        53 71 44 65 25 43 91 52 97 51 14\n")
                .append("       70 11 33 28 77 73 17 78 39 68 17 57\n")
                .append("      91 71 52 38 17 14 91 43 58 50 27 29 48\n")
                .append("     63 66 04 68 89 53 67 30 73 16 69 87 40 31\n")
                .append("    04 62 98 27 23 09 70 98 73 93 38 53 60 04 23\n")
                .toString();
    }

    @Override
    public String getAnswer() {
        return String.format("The maximum sum travelling from the top of the triangle to the base is: %s"
                , (long) this.Solve());
    }

    private String getData() {
        return new StringBuilder()
                .append("75\n")
                .append("95 64\n")
                .append("17 47 82\n")
                .append("18 35 87 10\n")
                .append("20 04 82 47 65\n")
                .append("19 01 23 75 03 34\n")
                .append("88 02 77 73 07 63 67\n")
                .append("99 65 04 28 06 16 70 92\n")
                .append("41 41 26 56 83 40 80 70 33\n")
                .append("41 48 72 33 47 32 37 16 94 29\n")
                .append("53 71 44 65 25 43 91 52 97 51 14\n")
                .append("70 11 33 28 77 73 17 78 39 68 17 57\n")
                .append("91 71 52 38 17 14 91 43 58 50 27 29 48\n")
                .append("63 66 04 68 89 53 67 30 73 16 69 87 40 31\n")
                .append("04 62 98 27 23 09 70 98 73 93 38 53 60 04 23")
                .toString();
    }

    /**
     * I want to represent the data as a List of a List of Integer,
     * so i break the data down by line and then by space and convert
     * it to Integer and return the data structure
     *
     * @param data - The String data to parse
     * @return A List of List of Integer
     */
    private List<List<Integer>> getTriangle(String data) {
        var y = Arrays.asList(data.split("\n"));
        List<List<Integer>> lli = new ArrayList<>();

        for (String ys : y) {
            List<Integer> li = new ArrayList<>();
            var x = Arrays.asList(ys.split(" "));

            for (String xs : x)
                li.add(Integer.valueOf(xs));

            lli.add(li);
        }

        return lli;
    }

    /**
     * We keep accumulating and reducing the triangle until there is only one item left
     * and that's our result.
     * @param triangle - the triangle data
     * @return The max sum of the trip from the top
     */
    private int findMaxSum(List<List<Integer>> triangle) {
        var t = triangle;

        while (t.size() > 1)
            t = reduceTriangle(t);

        return t.get(0).get(0);
    }

    /**
     * The strategy if the algorithm is to treat the data from the bottom up.
     * Here are the steps:
     * 1. Get the last row of the triangle
     * 2. Get the next to the last row of the triangle
     * 3. Loop through the items from step 2 above
     * 4. Find the 2 adjacent items under the item in step 3 above
     * 5. Select the largest of the 2 items in step 4 above
     * 6. Replace the item in step 3 above with the sum of the item in step
     *    5 and its original value
     * 7. remove tha last row from the triangle
     * This is a form of reduction because, when the function returns, the last row
     * contain the accumulation of the values after each iteration of the loop in
     * findMaxSum() above.
     * @param triangle - The triangle data to operate on
     * @return a new triangle data structure with one less row.
     */
    private List<List<Integer>> reduceTriangle(List<List<Integer>> triangle) {
        for (int i = 0; i < triangle.get(triangle.size() - 2).size(); i++) {
            triangle.get(triangle.size() - 2).set(i,
                    triangle.get(triangle.size() - 2).get(i) +
                            Math.max(triangle.get(triangle.size() - 1).get(i),
                                    triangle.get(triangle.size() - 1).get(i + 1)));
        }

        triangle.remove(triangle.size() - 1);
        return triangle;
    }
}
