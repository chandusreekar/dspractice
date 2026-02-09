package com.stream.mphasis;

import java.util.Arrays; // Import Arrays utility class
import java.util.stream.Collectors; // Import Collectors for joining

class ReverseWordsWithStreams { // Define the class
    public static void main(String[] args) { // Main method
        String input = "Java Program is Good"; // Input string

        String result = Arrays.stream(input.split(" ")) // Split input into words and create a stream
            .map(word -> new StringBuilder(word).reverse().toString()) // Reverse each word
            .collect(Collectors.joining(" ")); // Join reversed words with space

        System.out.println(result); // Output: avaJ margorP si dooG
    } // End of main method
} // End of class