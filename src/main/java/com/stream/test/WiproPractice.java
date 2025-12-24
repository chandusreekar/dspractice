package com.stream.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WiproPractice {

	public static void main(String[] args) {
		
//		String name = "Chandra";
//		int age = 28;
//		String message = STR."My name is \{name} and I'm \{age} years old.";
		
		String str = "Programming";
		
		var ch = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
		System.out.println("Maxmum Character "+ch);
		
		var resp2 = Arrays.stream(str.split("")).map(String::stripTrailing).collect(Collectors.groupingBy(f -> f, Collectors.counting())); System.out.println(resp2);
		
		String str1 = str.replace("ram", "");
		System.out.println(str1);
		
		var result = str1.toLowerCase().chars().mapToObj(c -> (char)c).filter(c -> c != ' ').collect(Collectors.toList());
		Collections.reverse(result);
		 System.out.println(result);
		var res3 = result.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println(res3);
		int[] arr = {5, 8, 10, 9, 6};
		var res1  = IntStream.rangeClosed(Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()).sum()
				- Arrays.stream(arr).sum();
		System.out.println(res1);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		var res2 = numbers.stream().collect(Collectors.partitioningBy(e -> e % 2== 0));
		System.out.println(res2.get(true)); System.out.println(res2.get(false));
		
		List<String> list1 = Arrays.asList("A", "B", "C", "D");
		List<String> list2 = Arrays.asList("E", "F", "G", "H");
		
		var response = list1.stream().filter(list2::contains).collect(Collectors.toList()); System.out.println(response);

		List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 1, 5);
		var resp1 = list.stream().collect(Collectors.groupingBy(f -> f, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(resp1);
		
		List<String> words = Arrays.asList("level", "java","ajva", "radar", "world");
		
		var palindrome = words.stream().filter(e -> new StringBuilder(e).reverse().toString().equals(e)).collect(Collectors.toList());
		System.out.println(palindrome);
		
		
		 List<String> input = Arrays.asList(
	                "PUNE_ADDRESS1",
	                "PUNE_ADDRESS2",
	                "MUMBAI_ADDRESS45",
	                "BANGLORE_ADDRESS4",
	                "BANGLORE_ADDRESS5"
	        );
		 
		 var res = input.stream().map(e -> e.split("_")).collect(Collectors.groupingBy(arr1 -> arr1[0], Collectors.mapping(arr2 -> arr2[1], Collectors.toList())));
		 System.out.println(res);
	}

}

//Write a program to remove subString from the string and reverse it by using java 8(streams)
//String str = " Programming ";
//String remove = " ram";