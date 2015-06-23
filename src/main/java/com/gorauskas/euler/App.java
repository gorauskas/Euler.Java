package com.gorauskas.euler;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.args4j.CmdLineException;

public class App {

    private static String EULER_PACKAGE = "com.gorauskas.euler.solutions.";
    private static String EULER_CLASS = "Euler";

    public static void main( String[] args ) {

        try {

            Util.parseOptions(args);
            ClassLoader cl = App.class.getClassLoader();
            Euler euler = (Euler) cl
                    .loadClass(App.EULER_PACKAGE + App.EULER_CLASS + Util.problem)
                    .newInstance();

            if (Util.verbose) {
                System.out.println(euler.getProblem());
            }

            System.out.println(euler.getAnswer());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

            System.err.println("Unable to load Euler Problem class.");
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
            System.exit(1);

        } catch (CmdLineException ex) {

            System.err.println("Unable to parse command line parameters.");
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);

        }

    }
}
