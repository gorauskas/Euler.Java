package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class Util {
    public static boolean verbose = false;
    public static int problem = 0;

    public static void version() {
        App o = new App();
        Package p = o.getClass().getPackage();

        System.out.println(
                String.format("%s - version %s.%s",
                        p.getSpecificationTitle(),
                        p.getSpecificationVersion(),
                        p.getImplementationVersion()));

        System.exit(0);
    }

    public static void usage(CmdLineParser p) {
        System.out.println("Project Euler problems & solutions written in Java 8");
        System.out.println("");
        System.out.println(" java -jar euler.jar [-v|-V|-?] -p <number>");
        System.out.println("");
        p.printUsage(System.out);
        System.out.println("");
        System.out.println(" Example:");
        System.out.println("  java -jar euler.jar -v -p 1");

        System.exit(0);
    }

    public static void parseOptions(String args[]) throws CmdLineException {
        Options opt = new Options();
        CmdLineParser p = new CmdLineParser(opt);

        try {
            p.parseArgument(args);

            verbose = opt.isVerbose();
            problem = opt.getProblem();

            if (opt.doShowVersion())
                version();

            if (opt.doShowUsage())
                usage(p);

        } catch (CmdLineException e) {
            if ("Option \"-p (--problem)\" is required".equals(e.getMessage())) {
                System.out.println("Please provide a Project Euler problem number ...");
                System.out.println("Enter java -jar euler.jar -? for usage information");
                System.exit(1);
            }

            throw e;
        }
    }

    public static boolean isPrime(long x) {
        return LongStream.rangeClosed(2, (long)(Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }

    public static boolean isPalindrome(long n) {
        return ((Long)n)
                .toString()
                .equals(new StringBuilder(((Long) n)
                        .toString())
                        .reverse()
                        .toString());
    }

    public static boolean isMultipleOf(int num, int multiple) {
        return (num == 0 || multiple == 0) ? false : num % multiple == 0;
    }

    public static boolean isMultipleOf(int num, IntStream multiples) {
        return multiples.allMatch(n -> isMultipleOf(num, n));
    }

    public static boolean isMultipleOf(long num, long multiple) {
        return (num == 0 || multiple == 0) ? false : num % multiple == 0;
    }

    public static boolean isMultipleOf(long num, LongStream multiples) {
        return multiples.allMatch(n -> isMultipleOf(num, n));
    }

    public static IntStream primeSequence(int max) {
        List<Integer> primes = new ArrayList<>(max);
        return IntStream.iterate(2, i -> i + 1)
                .filter(x -> {
                    for (int prime: primes)
                        if (x % prime == 0)
                            return false;
                    return true;
                })
                .limit(max);
    }

    public static IntStream primeSequence() {
        return primeSequence(Integer.MAX_VALUE);
    }

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

    public static int numberOfDivisors(int n) {
        if (n == 1)
            return 1;

        return (int)IntStream.rangeClosed(1, (int)Math.sqrt((double)n))
                .filter(x -> isMultipleOf(n, x))
                .count() * 2;
    }
}
