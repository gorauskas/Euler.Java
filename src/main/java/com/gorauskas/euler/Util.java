package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import java.util.function.Consumer;

public final class Util {
    public static boolean verbose = false;
    public static int problem = 0;

    private static Consumer<Object> _oln = System.out::println;
    private static Consumer<Object> _eln = System.err::println;

    public static void out(Object msg) {
        _oln.accept(msg);
    }

    public static void err(Object msg) {
        _eln.accept(msg);
    }

    public static void version() {
        App o = new App();
        Package p = o.getClass().getPackage();

        out(String.format("%s - version %s.%s",
                p.getSpecificationTitle(),
                p.getSpecificationVersion(),
                p.getImplementationVersion()));

        System.exit(0);
    }

    public static void usage(CmdLineParser p) {
        out("Project Euler problems & solutions written in Java 8");
        out("");
        out(" java -jar euler.jar [-v|-V|-?] -p <number>");
        out("");
        p.printUsage(System.out);
        out("");
        out(" Example:");
        out("  java -jar euler.jar -v -p 1");

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
                out("Please provide a Project Euler problem number ...");
                out("Enter java -jar euler.jar -? for usage information");
                System.exit(1);
            }

            throw e;
        }
    }

    public static boolean isPrime(long x) {
        return LongStream.rangeClosed(2, (long)(Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isEven(long n) {
        return n % 2 == 0;
    }

    public static boolean isEven(BigInteger n) {
        return n.mod(new BigInteger("2")).equals(BigInteger.ZERO);
    }

    public static boolean isPalindrome(long n) {
        return ((Long)n)
                .toString()
                .equals(new StringBuilder(((Long) n)
                        .toString())
                        .reverse()
                        .toString());
    }

    public static BigInteger factorial(long n) {
        BigInteger f = BigInteger.ONE;

        for (long i = n; i > 1; i--)
            f = f.multiply(BigInteger.valueOf(i));

        return f;
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

    public static int numberOfDivisors(int n) {
        if (n == 1)
            return 1;

        return (int)IntStream.rangeClosed(1, (int)Math.sqrt((double)n))
                .filter(x -> isMultipleOf(n, x))
                .count() * 2;
    }

    public static int sumOfDivisors(int n) {
        return IntStream.range(1, n)
                .filter(i -> n % i == 0)
                .sum();
    }
}
