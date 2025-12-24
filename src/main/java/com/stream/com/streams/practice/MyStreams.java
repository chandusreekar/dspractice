package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MyStreams {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("FF", "SS", "AA", "BB", "CC", "AB", "BC", "SS");
		var obj1 = str.stream().collect(Collectors.groupingBy(f -> f, TreeMap::new, Collectors.counting()));
		System.out.println(obj1);
		
		var obj2 = str.stream().filter(x -> Collections.frequency(str, x)>1).collect(Collectors.groupingBy(f -> f, TreeMap::new, Collectors.counting()));
		System.out.println(obj2);
		
		var obj3 = str.stream().collect(Collectors.groupingBy(f -> f, TreeMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println(obj3);
		
		var obj4 = str.stream().sorted().collect(Collectors.toSet());
		System.out.println(obj4);
		
		var obj5 = str.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(obj5);
		
		var obj6 = str.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("b")).collect(Collectors.groupingBy(f->f, TreeMap::new, Collectors.counting()));
		System.out.println(obj6);
		
		String name = "chandrasekhar";
		var n1 = Arrays.stream(name.split("")).collect(Collectors.toList());
		System.out.println(n1);
		
		var n2 = n1.stream().filter(x-> Collections.frequency(n1, x)>1).collect(Collectors.toList());
		System.out.println(n2);
		
		var n3 = n1.stream().filter(x-> Collections.frequency(n1, x)==1).collect(Collectors.toList());
		System.out.println(n3);
		
		var n4 = Arrays.stream(name.split("")).collect(Collectors.toList()).stream().filter(x -> Collections.frequency(str, x)>1).collect(Collectors.toList());
		System.out.println("N4 "+n4);
				

	}

}
