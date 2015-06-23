package com.gorauskas.euler;

import org.kohsuke.args4j.Option;

public class Options {
    @Option(name = "-V", usage = "Displays the version information and exits.")
    private boolean showVersion;

    @Option(name = "-h", aliases = {"--help", "-?"}, usage = "Displays this help message and exits.")
    private boolean showUsage;

    @Option(name = "-v", usage = "Verbose outputs the problem statement and the solution.")
    private boolean verbose;

    @Option(name = "-p", aliases = {"--problem"}, usage = "Specify the problem/solution number you want to run.")
    private int problem;

    public int getProblem() {
        return problem;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public boolean doShowVersion() {
        return showVersion;
    }

    public boolean doShowUsage() {
        return showUsage;
    }
}
