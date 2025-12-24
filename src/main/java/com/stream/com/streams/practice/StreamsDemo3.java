package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 25, 10, 98);
		Map<String, Long> wordCount = list.stream().filter(e -> Collections.frequency(list, e) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Counting of duplicate element from the list " + wordCount);

		Map<String, Long> dupCount = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println("Counting of duplicate element from the list " + dupCount);

		long i = list.stream().count();
		System.out.println(i);

		List<String> startsWith = list.stream().filter(e -> e.toLowerCase().startsWith("a"))
				.collect(Collectors.toList());
		System.out.println("Starts with "+startsWith);

		list.stream().distinct().forEach(System.out::println);

		List<String> st = list.stream().filter(e -> Collections.frequency(list, e) > 1).distinct()
				.collect(Collectors.toList());
		System.out.println(st);

		Set<String> str = new HashSet<>();
		Set<String> st1 = list.stream().filter(e -> !str.add(e)).collect(Collectors.toSet());
		System.out.println(st1);

		List<String> lst = list1.stream().map(e -> e + "").filter(e -> e.startsWith("8")).collect(Collectors.toList());
		System.out.println(lst);

		List<String> lst1 = list1.stream().map(e ->String.valueOf(e)).filter(e -> e.endsWith("8")).collect(Collectors.toList());
		System.out.println(lst1);
		
		double dbl = list1.stream().mapToInt(e -> e).average().getAsDouble(); System.out.println(dbl);
		
		long ln = list1.stream().mapToInt(Integer :: intValue).skip(1).sum(); System.out.println(ln);
		
		long sum = list1.stream().filter(e -> e % 2 == 0).reduce((e1,e2) -> e1 + e2).get(); System.out.println(sum);
		
		int i1 = list1.stream().filter(e -> e % 2 != 0).max(Integer :: compare).get(); System.out.println(i1);
		
		int i2 = list1.stream().min(Integer :: compare).get(); System.out.println(i2);
		
		Set<Integer> even = list1.stream().filter(e -> e % 2 == 0).collect(Collectors.toSet());
		System.out.println(even);
		
		int i3 = list1.stream().distinct().sorted().skip(1).findFirst().get(); System.out.println(i3);
		int i4 = list1.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().get(); System.out.println(i4);
	}

}
