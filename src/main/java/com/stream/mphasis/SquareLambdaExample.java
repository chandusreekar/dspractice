package com.stream.mphasis;

@FunctionalInterface
interface SquareCalculator { // Functional interface with one abstract method
    int calculate(int number); // Method to calculate square
}

public class SquareLambdaExample { // Main class
    public static void main(String[] args) { // Main method
        SquareCalculator square = n -> n * n; // Lambda expression to calculate square

        int input = 3; // Example input
        int result = square.calculate(input); // Calculate square of input
        System.out.println("Square of " + input + " is: " + result); // Print the result
    } // End of main method
} // End of class