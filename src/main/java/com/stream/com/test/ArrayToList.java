package com.stream.com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayToList {
    public static void main(String[] args) {
        int[] array = {1, 2, 8, 3, 2, 2, 2, 5, 1};
        
        // Convert the array to a List using streams
        List<Integer> list = Arrays.stream(array) // IntStream
            .boxed() // Convert to Integer objects
            .collect(Collectors.toList()); // Collect as List
        Map<Integer, Long> list1 = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        // Now you can work with 'list'
        System.out.println(list1);
    }
}
