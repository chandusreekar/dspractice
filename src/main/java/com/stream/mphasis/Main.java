package com.stream.mphasis;

import java.util.Arrays; // Import Arrays utility class
import java.util.List; // Import List interface
import java.util.stream.Collectors; // Import Collectors for joining

class Main { // Define the class
    public static void main(String[] args) { // Main method
        String[] input = {"one", "2wo", "Thr3e", "4our", "Five"}; // Input array

        List<Integer> numbers = Arrays.stream(input) // Create a stream from the array
            .map(s -> s.replaceAll("\\D", "")) // Replace all non-digit characters with empty string
            .filter(s -> !s.isEmpty()) // Filter out empty strings
            .map(Integer::parseInt) // Convert string to integer
            .collect(Collectors.toList()); // Collect results into a list

        System.out.println(numbers); // Output: [2, 3, 4]
    } // End of main method
} // End of class