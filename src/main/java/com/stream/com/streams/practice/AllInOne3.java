package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllInOne3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 25, 10, 98);
		
		List<Integer> a = list.stream().distinct().collect(Collectors.toList());
		System.out.println(a);
		
		List<Integer> a1 = list.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(a1);
		
		Optional<Integer> a2 = list.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
		System.out.println(a2);
		
		List<Integer> a3 = list.stream().distinct().sorted((e1,e2)-> e2.compareTo(e1)).collect(Collectors.toList());
		System.out.println(a3);
		
		Integer a4 = list.stream().distinct().reduce((e1,e2) -> e1+e2).get();
		System.out.println(a4);
		
		Integer a5 = list.stream().max(Integer::compare).get();
		System.out.println(a5);
		
		Integer a6 = list.stream().filter(e-> e%2 ==0 ).mapToInt(Integer::intValue).sum();
		System.out.println(a6);
		
		double a7 = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(a7);
		
		List<String> a8 = list.stream().map(s-> String.valueOf(s)).filter(e -> e.startsWith("2")).collect(Collectors.toList());
		System.out.println(a8);
		
		Map<Integer, Long> ln = list.stream().collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));
		System.out.println(ln);
		
		Map<Integer, Long> ln1 = list.stream().filter(e -> e % 2 == 0).filter(e-> Collections.frequency(list, e) > 1)
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println(ln1);
		
		int i = list.stream().distinct().sorted().limit(5).mapToInt(Integer::intValue).sum();
		System.out.println(i);

	}

}
