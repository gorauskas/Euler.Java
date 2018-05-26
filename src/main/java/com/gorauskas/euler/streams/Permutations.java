package com.gorauskas.euler.streams;

import com.gorauskas.euler.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://dzone.com/articles/java-8-master-permutations
public final class Permutations {

    /**
     * Returns all the possible permutations of items in a list as a stream of a stream of T
     * @param items the list of items to permute on
     * @param <T> any
     * @return a stream of a stream of T
     */
    public static <T> Stream<Stream<T>> of(final List<T> items) {
        int s = items.size();
        return IntStream.range(0, Util.factorial(s))
                .mapToObj(i -> perm(i, items).stream());
    }

    /**
     * Permutations on a list
     * @param c count
     * @param i input
     * @param o output
     * @param <T> any
     * @return any
     */
    private static <T> List<T> perm(final int c, final LinkedList<T> i, final List<T> o) {
        if (i.isEmpty()) { return o; }

        int s = i.size() - 1;
        final int f = Util.factorial(s);
        o.add(i.remove(c / f));
        return perm(c % f, i, o);
    }

    /**
     * Permutations on a list
     * @param c count
     * @param i items
     * @param <T> any
     * @return any
     */
    private static <T> List<T> perm(final int c, final List<T> i) {
        return perm(c, new LinkedList<>(i), new ArrayList<>());
    }
}
