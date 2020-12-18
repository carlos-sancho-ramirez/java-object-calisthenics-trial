# Object Calisthenics Trial
Short Java project created with the intention to use the Object Calisthenics rules

## About Object calisthenics

Object Calisthenics is a programming exercise where the developer is requested
to follow a set of 9 rules defined. The aim of those rules is ensuring good
practises when developing in object oriented programming, enforcing readability,
encapsulation, reusability and so on.

This is the list of all 9 rules that Object calisthenics mentions:
 1. Use only one level of indentation per method.
 2. Don’t use the else keyword.
 3. Wrap all primitives and strings.
 4. First class collections.
 5. One dot per line.
 6. Don’t Abbreviate.
 7. Keep all entities small.
 8. No classes with more than two instance variables.
 9. No getters/setters/properties.

## About this project

In this example, some comma-separated-values tables are provided as resource files.
The Java source read those resources and dump its data in different ways through
the standard output.

This project tries to focus on this programming paradigm.
Because of that, I tried to reduce dependencies to libraries as much as possible.

## How to run

This project requires at least Java 11. So the JDK for that version or higher must be installed.

This project uses Gradle as build tool. Just download the source and run the following command from the run of the repo:

    ./gradlew run
