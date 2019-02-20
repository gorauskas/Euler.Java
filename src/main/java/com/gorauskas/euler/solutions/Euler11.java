package com.gorauskas.euler.solutions;

import com.gorauskas.euler.Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Euler11 implements Euler {

    @Override
    public double Solve() {
        StringMatrix sm = new StringMatrix(this.getStringMatrix());
        return (double)sm.getProduct();
    }

    @Override
    public String getProblem() {
        return new StringBuilder()
                    .append("Project Euler Problem 11:\n")
                    .append("\n")
                    .append("    In the 20x20 grid below, four numbers along a diagonal line have been \n")
                    .append("    marked in red.\n")
                    .append("    \n")
                    .append("    08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n")
                    .append("    49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n")
                    .append("    81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n")
                    .append("    52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n")
                    .append("    22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n")
                    .append("    24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n")
                    .append("    32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n")
                    .append("    67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n")
                    .append("    24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n")
                    .append("    21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n")
                    .append("    78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n")
                    .append("    16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n")
                    .append("    86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n")
                    .append("    19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n")
                    .append("    04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n")
                    .append("    88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n")
                    .append("    04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n")
                    .append("    20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n")
                    .append("    20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n")
                    .append("    01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48\n")
                    .append("    \n")
                    .append("    The product of these numbers is 26 x 63 x 78 x 14 = 1788696.\n")
                    .append("    \n")
                    .append("    What is the greatest product of four adjacent numbers in any direction \n")
                    .append("    (up, down, left, right, or diagonally) in the 20x20 grid?\n")
                    .toString();
    }

    @Override
    public String getAnswer() {
        StringMatrix sm = new StringMatrix(this.getStringMatrix());
        return String.format("The greatest product of four adjacent numbers in the grid is:\n" +
                "P: %s; Loc: %s,%s; Seq: %s\n", sm.getProduct(), sm.getX(), sm.getY(), sm.getSequence());
    }

    class StringMatrix {
        private int[][] int_matrix = new int[20][20];
        private String str_matrix = "";

        private int product;
        private int x;
        private int y;
        private List<Integer> seq;

        public StringMatrix(String matrix) {
            this.str_matrix = matrix;
            this.calculateIntMatrix();
            this.calculateGreatestProductOfFourAdjacentNumbers();
        }

        private List<Integer> getAdjacentList(Orientation orient, int x, int y) {
            List<Integer> l = new ArrayList<>();

            switch (orient) {
                case down:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y + 1][x]);
                    l.add(this.int_matrix[y + 2][x]);
                    l.add(this.int_matrix[y + 3][x]);
                    break;
                case downLeft:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y + 1][x - 1]);
                    l.add(this.int_matrix[y + 2][x - 2]);
                    l.add(this.int_matrix[y + 3][x - 3]);
                    break;
                case downRight:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y + 1][x + 1]);
                    l.add(this.int_matrix[y + 2][x + 2]);
                    l.add(this.int_matrix[y + 3][x + 3]);
                    break;
                case left:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y][x - 1]);
                    l.add(this.int_matrix[y][x - 2]);
                    l.add(this.int_matrix[y][x - 3]);
                    break;
                case right:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y][x + 1]);
                    l.add(this.int_matrix[y][x + 2]);
                    l.add(this.int_matrix[y][x + 3]);
                    break;
                case up:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y - 1][x]);
                    l.add(this.int_matrix[y - 2][x]);
                    l.add(this.int_matrix[y - 3][x]);
                    break;
                case upLeft:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y - 1][x - 1]);
                    l.add(this.int_matrix[y - 2][x - 2]);
                    l.add(this.int_matrix[y - 3][x - 3]);
                    break;
                case upRight:
                    l.add(this.int_matrix[y][x]);
                    l.add(this.int_matrix[y - 1][x + 1]);
                    l.add(this.int_matrix[y - 2][x + 2]);
                    l.add(this.int_matrix[y - 3][x + 3]);
                    break;
            }

            return l;
        }

        private void calculateIntMatrix() {
            String[] numbers = str_matrix.split("[ \\n]");
            int i = 0, j = 0;

            for (String number: numbers) {
                this.int_matrix[i][j] = Integer.parseInt(number);
                j++;
                if (j == 20) {
                    j = 0;
                    i++;
                }
            }
        }

        private void calculateGreatestProductOfFourAdjacentNumbers() {
            var js = IntStream.range(3, 17).boxed().collect(Collectors.toList());
            var ks = IntStream.range(3, 17).boxed().collect(Collectors.toList());
            IntBinaryOperator ibo = (a, b) -> a * b;

            for (int j: js) {
                for (int k: ks) {
                    for (Orientation o: Arrays.asList(Orientation.values())) {
                        var l = this.getAdjacentList(o, j, k);
                        if (l.stream().mapToInt(Integer::valueOf).reduce(ibo).getAsInt() > this.product) {
                            this.product = l.stream().mapToInt(Integer::valueOf).reduce(ibo).getAsInt();
                            this.seq = l;
                            this.x = j;
                            this.y = k;
                        }
                    }
                }
            }
        }

        public int getProduct() {
            return this.product;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public List<Integer> getSequence() {
            return this.seq;
        }
    }

    public enum Orientation {
        up, down, left, right, upLeft, upRight, downLeft, downRight
    }

    private String getStringMatrix() {
        return new StringBuilder()
                    .append("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n")
                    .append("49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n")
                    .append("81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n")
                    .append("52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n")
                    .append("22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n")
                    .append("24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n")
                    .append("32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n")
                    .append("67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n")
                    .append("24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n")
                    .append("21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n")
                    .append("78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n")
                    .append("16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n")
                    .append("86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n")
                    .append("19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n")
                    .append("04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n")
                    .append("88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n")
                    .append("04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n")
                    .append("20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n")
                    .append("20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n")
                    .append("01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48\n")
                    .toString();
    }
}
