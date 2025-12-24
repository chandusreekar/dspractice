package com.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyFirstInterview {

	public static void main(String[] args) {
		String str = "chandrasekhar";
		
		Map<String, Long> map = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println(map);
		
		var obj1 = map.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toList());
		System.out.println(obj1);
		
		var obj2 = map.entrySet().stream().filter(x -> x.getValue() == 1).collect(Collectors.toList());
		System.out.println(obj2);
		
		
		System.out.println(obj2.stream().map(x -> x.getKey()).collect(Collectors.toList()));
		
		
		List<String> map1 = Arrays.stream(str.split(""))				
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(Entry :: getKey)
				.collect(Collectors.toList());
		System.out.println(map1);
		
		List<String> non = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
		
		System.out.println(" Repeating Chars "+non);
		
		List<Character> nonRepeatedChars = str.chars()
	            .mapToObj(c -> (char) c)
	            .collect(Collectors.groupingBy(
	                Function.identity(), Collectors.counting()))
	            .entrySet().stream()
	            .filter(entry -> entry.getValue() == 1)
	            .map(Entry::getKey)
	            .collect(Collectors.toList());

	        System.out.println("Non-repeated characters: " + nonRepeatedChars);
		

	}

}
