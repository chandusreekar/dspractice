package com.stream.com.practice;
public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        String s = "aabaadddcd";
        
        int maxLen = 1;        // stores longest substring length
        int currLen = 1;       // tracks current substring length
        char maxChar = s.charAt(0);  // tracks which character formed the longest substring
        
        // Loop through string
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLen++;  // same as previous char → continue streak
            } else {
                currLen = 1; // new char → reset count
            }

            // if current streak is longer than max, update max
            if (currLen > maxLen) {
                maxLen = currLen;
                maxChar = s.charAt(i);
            }
        }
        
        
        int min = 1; int max = 1;
        for(int i = 1; i<s.length(); i++) {
        	if(s.charAt(i)== s.charAt(i-1)) {
        		min++;
        	}
        	else {
        		min = 1;
        	}
        	if(max < min) {
        		max = min;
        		maxChar  =  s.charAt(i);
        	}
        }
        
        String lstr = String.valueOf(maxChar).repeat(max);
        System.out.println(lstr);
        
        // Build the longest substring
        String longestSubstring = String.valueOf(maxChar).repeat(maxLen);
         
        System.out.println("Longest substring = " + longestSubstring);
        
        
    }
}
