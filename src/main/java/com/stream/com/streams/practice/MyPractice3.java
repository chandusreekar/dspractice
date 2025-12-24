package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyPractice3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 15, 8,26, 27, 26, 49, 25, 98, 32, 25, 10, 98, 22, 22,15);
		List<Integer> rmvDup = list.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(rmvDup);
		
		Integer reverseOrder = list.stream().distinct().limit(5).sorted(Collections.reverseOrder()).skip(2).findFirst().get();
		System.out.println(reverseOrder);
		
		List<String> lst = list.stream().filter(x -> Collections.frequency(list, x) > 1).map(x -> String.valueOf(x)).filter(x -> x.startsWith("2")).collect(Collectors.toList());
		System.out.println(lst);
		
		Map<String, Long> lst1 = list.stream().filter(x -> Collections.frequency(list, x) > 1).map(x -> String.valueOf(x))
				.filter(x -> x.startsWith("2")).collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println(lst1);
		
		Map<String, Long> lst2 = list.stream().filter(x -> Collections.frequency(list, x) > 1).map(x -> x+"").filter(x -> x.endsWith("5"))
		.collect(Collectors.groupingBy(x -> x, TreeMap :: new, Collectors.counting()));
		System.out.println(lst2);
		
		long max = list.stream().max(Integer::compare).get(); System.out.println(max);
		long min = list.stream().min(Integer::compare).get(); System.out.println(min);
		double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble(); System.out.println(avg);
		
		int secondLargestNumber = list.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondLargestNumber);

	}

}
