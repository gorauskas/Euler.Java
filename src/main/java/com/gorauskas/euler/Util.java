package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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


}
