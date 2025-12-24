package com.stream.com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 
 */
public class Multiply {
    public static void main(String[] args) {
    	
    	String s1 = "I'm learning Stream Api in Java";
    	
    	var res = Arrays.stream(s1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().orElse("No Value Present");
    	var res1 = Arrays.stream(s1.split(" ")).collect(Collectors.groupingBy(f->f, Collectors.counting()));
    	var res2 = res1.entrySet().stream().filter(value -> value.getValue() == 1).filter(k -> k.getKey().equalsIgnoreCase("Java")).collect(Collectors.toList());
    	
    	
//    	int multiply = multiply(2,5);
//    	BiFunction<Integer, Integer, Integer> mu = (x, y) -> x*y;
//    	int res = mu.apply(2,5);
        System.out.println(res1);
        System.out.println(res2);
        
        List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
//        list.stream().filter(e -> Collections.frequency(list, e) > 1).forEach(System.out::println);
       var response =  list.stream().collect(Collectors.groupingBy(f->f, TreeMap::new, Collectors.counting()));
       System.out.println(response);
      var out =  response.entrySet().stream().filter(v-> v.getValue() > 1).map(k -> k.getKey().concat("M")).collect(Collectors.toList());
       System.out.println(out);
       
       int[] arr1 = {1,2,3,4,5,6,7,8};
       int n =4;
       int[] nArr = new int[arr1.length];
       
       System.arraycopy(arr1, n, nArr, 0, arr1.length - n);
       
       System.arraycopy(arr1, 0, nArr, arr1.length - n, n);
       System.out.println("Result "+ Arrays.toString(nArr));
       
    }
    
    public static int multiply(int i, int j) {
		return i*j;
	}
    
   
}
