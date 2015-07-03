package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

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

    public static boolean isPrime(double x) {
        for (double i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(long n) {
        long x = 0, y = n;

        while (y != 0) {
            x = (x * 10) + y % 10;
            y /= 10;
        }

        return (x == n);
    }

    public static boolean isMultipleOf(int num, int multiple) {
        if (num == 0 || multiple == 0)
            return false;

        return num % multiple == 0;
    }

    public static boolean isMultipleOf(int num, IntStream multiples) {
        return multiples.allMatch(n -> isMultipleOf(num, n));
    }

    public static boolean isMultipleOf(long num, long multiple) {
        if (num == 0 || multiple == 0)
            return false;

        return num % multiple == 0;
    }

    public static boolean isMultipleOf(long num, LongStream multiples) {
        return multiples.allMatch(n -> isMultipleOf(num, n));
    }
}
