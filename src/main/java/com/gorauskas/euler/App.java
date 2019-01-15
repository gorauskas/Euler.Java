package com.gorauskas.euler;

import org.kohsuke.args4j.CmdLineException;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static String EULER_PACKAGE = "com.gorauskas.euler.solutions.";
    private static String EULER_CLASS = "Euler";

    public static void main( String[] args ) {

        try {

            Util.parseOptions(args);
            ClassLoader cl = App.class.getClassLoader();
            Euler euler = (Euler) cl
                    .loadClass(App.EULER_PACKAGE + App.EULER_CLASS + Util.problem)
                    .getDeclaredConstructor()
                    .newInstance();

            if (Util.verbose) {
                Util.out(euler.getProblem());
            }

            Util.out(euler.getAnswer());

        } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {

            Util.err("Unable to load Euler Problem class.");
            Util.err("Enter java -jar euler.jar -? for usage information");
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
            System.exit(1);

        } catch (CmdLineException ex) {

            Util.err("Unable to parse command line parameters.");
            Util.err("Enter java -jar euler.jar -? for usage information");
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);

        }

    }
}
