package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Util {
    public static boolean verbose = false;
    public static int problem = 0;

    public static void version() {
        System.out.println("Version!");
        System.exit(0);
    }

    public static void usage() {
        System.out.println("Usage!");
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
                usage();

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
}
