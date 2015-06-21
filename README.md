# Euler

Solutions to the Project Euler problems written in Java 8.

Clone this repo and then run the following from the command line:

    mvn clean package
    java -jar target/euler.jar -p <problem number>

## Usage

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

All `Euler#` classes are implemented using the `Euler` common interfacefor all
classes. This is the key construct that allows classes to be loaded and executed
dynamically.
