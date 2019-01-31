package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.util.stream.DoubleStream;
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
        if ((x & 1) == 0) {
            if (x == 2) {
                return true;
            } else {
                return false;
            }
        }

        for (long k = 3; (k * k) <= x; k += 2) {
            if ((x % k) == 0) {
                return false;
            }
        }

        return x != 1;
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

    public static int factorial(int n) {
        return IntStream.rangeClosed(2, n)
                .reduce(1, (x, y) -> x * y);
    }

    public static long factorial(long n) {
        return LongStream.rangeClosed(2, n)
                .reduce(1, (x, y) -> x * y);
    }

    public static double factorial(double n) {
        return DoubleStream.of(LongStream.rangeClosed(2, (long)n).mapToDouble(i -> (double)i).toArray())
                .reduce(1, (x, y) -> x * y);
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger f = BigInteger.ONE;

        for (long i = n.longValue(); i > 1; i--) {
            f = f.multiply(BigInteger.valueOf(i));
        }

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

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static boolean isPanDigital(long i) {
        int digits = 0;
        int count = 0;
        int tmp;

        while(i > 0) {
            tmp = digits;
            digits = digits | 1 << (int)((i % 10) - 1);

            if (tmp == digits) {
                return false;
            }

            count++;
            i /= 10;
        }

        return digits == (1 << count) - 1;
    }

    public static boolean isPanDigital(String bignum) {
        return isPanDigital(bignum, 9);
    }

    public static boolean isPanDigital(String bignum, int len) {
        if (bignum.length() != len) {
            return false;
        }

        return IntStream
                .iterate(1, n -> n + 1)
                .takeWhile(n -> n <= len)
                .mapToObj(String::valueOf)
                .allMatch(bignum::contains);
    }

    public static long concatNumbers(long a, long b) {
        long c = b;

        while (c > 0) {
            a *= 10;
            c /= 10;
        }

        return a + b;
    }

    public static String listToString(List<Long> l) {
        StringBuilder sb = new StringBuilder("[");

        for (Long item : l) {
            sb.append(item);
            sb.append(", ");
        }

        sb.append("]");
        return sb.toString().replace(", ]", "]");
    }

    public static <T> String concatListAsString(Collection<T> collection) {
        StringBuilder sb = new StringBuilder();

        for (T item : collection) {
            sb.append(item.toString());
        }

        return sb.toString();
    }

    public static String getDataFromFile(URI uri) {
        String data = "";

        try {

            FileSystem fs;
            Path path;
            Map<String, String> env = new HashMap<>();

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

            data = Files.readAllLines(path).get(0);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return data;
    }
}
