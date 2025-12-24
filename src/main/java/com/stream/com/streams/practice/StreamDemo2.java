package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo2 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		
		List<String> dis = list.stream().distinct().collect(Collectors.toList()); System.out.println(dis);

		List<String> di21 = list.stream().filter(e -> Collections.frequency(list, e)>1).collect(Collectors.toList()); System.out.println(di21);
		Set<String> di2 = list.stream().filter(e -> Collections.frequency(list, e)>1).collect(Collectors.toSet()); System.out.println(di2);
		
		Map<String, Long> dup = list.stream().filter(e -> Collections.frequency(list, e)>1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); System.out.println(dup);
		
		Set<String> st = new HashSet<>();
		Set<String> st1 = list.stream().filter(e -> !st.add(e)).collect(Collectors.toSet()); System.out.println(st1);
		
		Map<String, Long> gpBy =   list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("GroupBy Value"+gpBy);
		
		List<String> startWith = list.stream().filter(e -> e.startsWith("D")).collect(Collectors.toList());
		System.out.println(startWith);
		
		// ===============================================================================================================
		
		List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 25, 10, 98);
		
		List<Integer> even =  list1.stream().filter(e -> e%2 == 0).sorted().distinct().collect(Collectors.toList());
		System.out.println(even);
		
		List<Integer> odd =  list1.stream().filter(e -> e%2 != 0).sorted().distinct().collect(Collectors.toList());
		System.out.println(odd);
		
		int i = list1.stream().reduce((e1,e2)-> e1+e2).get(); System.out.println(i);
		
		int sum = list1.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
		double dbl = list1.stream().mapToInt(e -> e).average().getAsDouble(); System.out.println(dbl);
		double dbl2 = list1.stream().mapToInt(Integer::intValue).average().getAsDouble(); System.out.println("Double 2 "+dbl2);
		int i1 = list1.stream().min(Integer :: compare).get(); System.out.println(i1);
		int i2 = list1.stream().max(Integer :: compare).get(); System.out.println(i2);
		List<Integer> limit = list1.stream().limit(5).filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println(limit);
		List<Integer> skip = list1.stream().skip(5).filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println(skip);
		
		int ndL = list1.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println(ndL);
		int nd = list1.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println(nd);
		
		int evenSum = list1.stream().filter(e -> e % 2 == 0).mapToInt(Integer :: intValue).sum();
		System.out.println(evenSum);
		
		int oddSum = list1.stream().filter(e -> e % 2 != 0).mapToInt(Integer :: intValue).sum();
		System.out.println(oddSum);
		
		int ff = list1.stream().findFirst().get(); System.out.println(ff);
		
		Map<Integer, Long> arr = list1.stream().filter(e -> Collections.frequency(list1, e)>1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(arr);
		
		Map<Integer, Long> arr1 = list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(arr1);
		
		List<String> endsWith = list1.stream().map(s -> s +"").filter(e -> e.endsWith("2")).collect(Collectors.toList());
		System.out.println(endsWith);
		
		List<String> startsWith = list1.stream().map(e -> String.valueOf(e)).filter(e -> e.startsWith("2")).collect(Collectors.toList());
		System.out.println(startsWith);
	}

}
