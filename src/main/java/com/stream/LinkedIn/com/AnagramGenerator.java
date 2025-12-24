package com.stream.LinkedIn.com;
public class AnagramGenerator {

    public static void main(String[] args) {
        String str = " cat ";
        String st = str.stripTrailing();
        System.out.println(st);
//        System.out.println(str.substring(3));
        System.out.println("All anagrams of '" + str + "':");
        generateAnagrams("", str);
    }

    // Recursive function to generate permutations
    private static void generateAnagrams(String prefix, String remaining) {
        int n = remaining.length();

        // Base case: if nothing left to permute
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                // Take one char and permute the rest
                generateAnagrams(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1));
            }
        }
    }
}
