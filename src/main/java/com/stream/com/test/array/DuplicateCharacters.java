package com.stream.com.test.array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String s1 = "I'm learning Stream Api in Java";

        List<Character> duplicateChars = s1.replaceAll("[^a-zA-Z]", "") // remove non-letters
            .toLowerCase()
            .chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        System.out.println("Duplicate characters: " + duplicateChars);
        
        var obj = Arrays.stream(s1.split("")).map(e -> e.replaceAll("[^a-zA-Z]", " ").toLowerCase())
        		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
        		.stream().filter(e->e.getValue()>1).map(v -> v.getKey()).skip(1).collect(Collectors.toList());
        System.out.println("Duplicate characters: " + obj);
        
        
        var duplicateWords1 =   Arrays.stream(s1.split(" ")).map(x -> x.toLowerCase()).collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue()==1).map(Map.Entry :: getKey).collect(Collectors.toList());
                System.out.println("duplicateWords1 "+ duplicateWords1);
                
        List<String> duplicateWords = Arrays.stream(s1.split("\\s+"))
                        .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase()) // remove punctuation and normalize
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

                    System.out.println("Duplicate words: " + duplicateWords);
        
    }
}
