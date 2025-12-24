package com.stream.com.knowledgesharing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyDemo2 {

	public static void main(String[] args) {
		String s1 = "I'm learning Chandu Stream Api in Java Stream in Api";
		
		var str1 = Arrays.stream(s1.split(" ")).collect(Collectors.toList());
		System.out.println("str1 "+str1);
		
		var str2 = str1.stream().filter(e -> e.length() > 5).sorted().collect(Collectors.toList());
		System.out.println("str2 "+str2);
		
		var str3 = str1.stream().map(e -> e.toLowerCase()).filter(e -> e.contains("ch")).sorted().collect(Collectors.toList());
		System.out.println("str3 "+str3);
		
		var str4 = str1.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println("str4 "+str4);
		
		var obj = str4.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList()); System.out.println("Obj  "+obj);
		
		var obj1 = str4.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList()); System.out.println("Obj  "+obj1);
		
		var str5 = str1.stream().filter(e -> Collections.frequency(str1, e)>1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("str5 "+str5);
		
		var str6 = str1.stream().map(String::length).sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println("str6 "+str6);
		
		var str7 = str1.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
		System.out.println("str7 "+str7);
		
		var str8 = str1.stream().sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
		System.out.println("str8 "+str8);
		
		var str9 = Arrays.stream(s1.split(" ")).map(e -> e.replace("[^a-zA-Z]", "").toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println("str9 "+str9);
		

	}

}
