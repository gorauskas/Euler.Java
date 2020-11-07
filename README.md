# Euler

![Build Euler.Java](https://github.com/gorauskas/Euler.Java/workflows/Java%20CI%20with%20Maven/badge.svg)

Solutions to the Project Euler problems written in Java 11.

Clone this repo and then run the following from the command line:

    mvn clean package
    java -jar target/euler.jar -p <problem number>

## Usage

    Project Euler problems & solutions written in Java 11

     java -jar euler.jar [-v|-V|-?] -p <number>

     -V               : Displays the version information and exits. (default: false)
     -h (--help, -?)  : Displays this help message and exits. (default: true)
     -p (--problem) N : Specify the problem/solution number you want to run.
                        (default: 0)
     -v               : Verbose outputs the problem statement and the solution.
                        (default: false)

     Example:
      java -jar euler.jar -v -p 1

## Tests

Alternatively, there is a full set of unit tests written with jUnit that can be
run by invoking maven at the root of the project, like so:

    mvn clean test

## How it works...

The main program in the `App` class will try to import one of the solution
classes from `com.gorauskas.euler.solutions` based on the problem number passed
in via the command line. From that package, it will load a class called `Euler#`
where `#` is for the problem number. If the user requests verbose output, the
program calls the `getProblem` method of the loaded `Euler#` class and then
calls the `getAnswer` method.

All `Euler#` classes are implemented using the `Euler` common interface for all
classes. This is the key construct that allows classes to be loaded and executed
dynamically.
