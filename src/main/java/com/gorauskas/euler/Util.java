package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
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
        var o = new App();
        var p = o.getClass().getPackage();

        out(String.format("%s - version %s.%s",
                p.getSpecificationTitle(),
                p.getSpecificationVersion(),
                p.getImplementationVersion()));

        System.exit(0);
    }

    public static void usage(CmdLineParser p) {
        out("Project Euler problems & solutions written in Java 11");
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
        var opt = new Options();
        var p = new CmdLineParser(opt);

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
        var f = BigInteger.ONE;

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
        var digits = 0;
        var count = 0;
        var tmp = 0;

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
        var c = b;

        while (c > 0) {
            a *= 10;
            c /= 10;
        }

        return a + b;
    }

    public static <T> String listToString(Collection<T> collection) {
        var sb = new StringBuilder("[");

        for (T item : collection) {
            sb.append(item);
            sb.append(", ");
        }

        sb.append("]");
        return sb.toString().replace(", ]", "]");
    }

    public static <T> String concatListAsString(Collection<T> collection) {
        return concatListAsString(collection, "");
    }

    public static <T> String concatListAsString(Collection<T> collection, String concatenator) {
        var sb = new StringBuilder();

        for (T item : collection) {
            sb.append(item.toString()).append(concatenator);
        }

        return sb.toString();
    }

    public static <T> long concatListAsNumber(Collection<T> collection) {
        return Long.parseLong(concatListAsString(collection));
    }

    public static Map<String, Integer> enumerate(int start, List<String> list) {
        int x = start;
        var msi = new HashMap<String, Integer>();

        for (var item : list) {
            msi.put(item, x);
            x++;
        }

        return msi;
    }

    public static String getDataFromFile(URI uri) {
        var data = "";

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

            data = concatListAsString(Files.readAllLines(path), "\n");

        } catch (IOException e) {

            e.printStackTrace();

        }

        return data;
    }

    public static List<Long> factors(long l) {
        var ll = new ArrayList<Long>();

        for (long factor = 1; factor * factor <= l; factor++) {
            if (l % factor == 0) {
                ll.add(factor);

                if (factor * factor != l) {
                    ll.add(l / factor);
                }
            }
        }

        return ll;
    }

    public static String sorted(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static List<String> toList(String s) {
        var rs = new ArrayList<String>();

        for (char c : s.toCharArray()) {
            rs.add(Character.toString(c));
        }

        return rs;
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> uMap, final boolean order) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(uMap.entrySet());

        //sort the list by value
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));

        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> b, LinkedHashMap::new));
    }
}
