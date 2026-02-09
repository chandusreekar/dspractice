package com.stream.com.practice;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LastWordLength {
    public static void main(String[] args) {
        String str = "Pro gra mmin gm";

         var list= Arrays.stream(str.split(" ")).collect(Collectors.toList());
         int n = list.get(list.size() -1).length();
        
        
        int length = Arrays.stream(str.trim().split("\\s+"))
                .filter(s -> !s.isEmpty())       // remove any empty parts
                .reduce((first, second) -> second) // get the last word
                .map(String::length)
                .orElse(0);

        System.out.println("Length of last word: " + length);
    }
}
