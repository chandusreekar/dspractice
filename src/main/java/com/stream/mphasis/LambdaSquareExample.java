package com.stream.mphasis;

import java.util.function.Function; // Import the Function interface

public class LambdaSquareExample { // Define the class
    public static void main(String[] args) { // Main method
        Function<Integer, Integer> square = n -> n * n; // Lambda to return square of a number

        int result = square.apply(5); // Apply lambda to number 5
        System.out.println(result); // Print the result (output: 25)
    } // End of main method
} // End of class