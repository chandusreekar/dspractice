package com.stream.com.test;

public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder merged = new StringBuilder(len1 + len2);

        int i = 0;
        int j = 0;

        while (i < len1 || j < len2) {
            if (i < len1) {
                merged.append(word1.charAt(i));
                i++;
            }
            if (j < len2) {
                merged.append(word2.charAt(j));
                j++;
            }
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "defgh";
        String merged = mergeAlternately(word1, word2);
        System.out.println(merged); // Output: "adbcefgh"
    }
}

