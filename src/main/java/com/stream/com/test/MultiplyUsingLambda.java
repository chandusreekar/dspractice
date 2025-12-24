package com.stream.com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MultiplyUsingLambda {
	public static void main(String[] args) {
		 BiFunction<Integer, Integer, Integer> multiply = (x, y) -> x * y;
		 int result = multiply.apply(10, 20);
		 System.out.println(result);
		 
		 Addition addition = (x, y) -> x + y;
		 int res = addition.add(10, 20);
		 System.out.println(res);
		 
		 
		 String s1 = "I'm learning Stream Api in Java Stream Java"; 
		 var obj1 = Arrays.stream(s1.split(" ")).map(e1 -> e1.replaceAll("[^a-zA-Z]", "").toLowerCase()).sorted(Comparator.comparing(String::length).reversed())
				 .skip(1).findFirst().orElse("Nothing to Print");
		 System.out.println(obj1);
		 
		 var obj2 = Arrays.stream(s1.split(" ")).map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase()).collect(Collectors.groupingBy(f -> f, Collectors.counting()))
				 .entrySet().stream().filter(value -> value.getValue() > 1).map(key -> key.getKey()).collect(Collectors.toList());
		 System.out.println(obj2);
		 
		 var obj3 = Arrays.stream(s1.split("")).map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase()).collect(Collectors.groupingBy(f->f, TreeMap::new, Collectors.counting()));
//		 .entrySet().stream().collect(Collectors.toMap());
		 System.out.println(obj3);
		 
		 var obj4 = s1.replaceAll("[^a-zA-Z]", "").toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(f->f, TreeMap::new, Collectors.counting()));
		 System.out.println(obj4);
		 
		 var obj5 = obj4.entrySet().stream().filter(v -> v.getValue() > 1).map(k -> k.getKey()).collect(Collectors.toList());
		 System.out.println(obj5);
		 
		 
	}
}

@FunctionalInterface
interface Addition{
	abstract int add(int x, int y);
	
}