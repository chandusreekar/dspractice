package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllInOne2 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		
		List<String> a = list.stream().distinct().collect(Collectors.toList()); 
		System.out.println(a);
		
		List<String> b = list.stream().filter(e-> Collections.frequency(list, e)>1).collect(Collectors.toList());
		System.out.println(b);
		
		Map<String, Long> c = list.stream().filter(e->Collections.frequency(list, e)>1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(c);
		
		Map<String, Long> d = list.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
		System.out.println(d);
		
		Map<String, Long> e = list.stream().collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));
		System.out.println(e);
		
		List<String> f = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry :: getKey).collect(Collectors.toList());
		System.out.println(f);
		
		List<String> g = list.stream().filter(e1 -> e1.startsWith("D")).collect(Collectors.toList());System.out.println(g);
		
		
		int[][] matrix = {
	            {3, 4, 5},
	            {6, 7, 8},
	            {2, 6, 0},
	            {1, 2, 6}
	        };
		
		var res = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
		System.out.println(res);
	}

}
