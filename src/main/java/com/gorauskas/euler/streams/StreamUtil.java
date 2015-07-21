package com.gorauskas.euler.streams;

import com.gorauskas.euler.Util;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.*;

public final class StreamUtil {
    public static <T> Stream<T> takeWhile(Stream<T> source, Predicate<T> condition) {
        return StreamSupport.stream(TakeWhileSpliterator.over(source.spliterator(), condition), false);
    }

    public static LongStream primeSequence(long max) {
        return LongStream.iterate(2, i -> i + 1)
                .filter(x -> Util.isPrime(x))
                .limit(max);
    }

    public static LongStream primeSequence() { return primeSequence(Long.MAX_VALUE); }

    public static Stream<BigInteger> fibonacciSequence(long max) {
        BigInteger bi = new BigInteger("1");
        return Stream.iterate(new BigInteger[]{bi, bi}, f -> new BigInteger[]{f[1], f[0].add(f[1])})
                .map(f -> f[0])
                .limit(max);
    }

    public static Stream<BigInteger> fibonacciSequence() { return fibonacciSequence(Long.MAX_VALUE); }

    public static IntStream triangleNumberSequence(int max) {
        return IntStream.iterate(1, i -> i + 1)
                .map(n -> (n * n + n) / 2)
                .limit(max);
    }

    public static IntStream triangleNumberSequence() {
        return triangleNumberSequence(Integer.MAX_VALUE);
    }

    public static List<Long> collatzSequence(long seed) {
        Stream<Long> sl = Stream.iterate(seed, n -> n > 0 && n % 2 == 0 ? n / 2 : 3 * n + 1);
        List<Long> ll = takeWhile(sl, i -> i > 1).collect(Collectors.toList());
        ll.add(1l);
        return ll;
    }
}
