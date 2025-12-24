package com.stream.com.streams.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 25);
		
		System.out.println("How to count each element/word from the String ArrayList in Java8?");
		Map<String, Long> obj = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//		Map<String, Long> obj3 = obj.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
		System.out.println(obj);
		Map<String, Long> obj1 = list.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));// For sorting we use TreeMap::new
//		Map<String, Long> obj1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Counting of Elements "+obj1);
//		System.out.println("How to find only duplicate elements with its count from the String ArrayList in Java8?");
		Map<String, Long> obj2 = list.stream().filter(x-> Collections.frequency(list, x)>1).collect(Collectors.groupingBy(Function.identity(), 
				Collectors.counting()));
		System.out.println("Counting of Elements "+obj2);
		
		Map<Integer, Long> a1 = list1.stream().collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));
		System.out.println("Printing l1 "+a1);
		
		list.stream().sorted().distinct().forEach(System.out::println);
		
		list.stream().filter(a2->Collections.frequency(list, a2)>1).forEach(System.out::println);
		
//		System.out.println("Given a list of integers, find out all the even numbers that exist in the list using Stream functions?");
		List<Integer> l1 = list1.stream().sorted().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l1);
		
//		System.out.println("Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
		List<String> l2 = list1.stream().map(s-> s + "").filter(s->s.startsWith("1")).collect(Collectors.toList());
		System.out.println(l2);
//		System.out.println("How to find duplicate elements in a given integers list in java using Stream functions?");
		Set<Integer> set = new HashSet<>();
		List<Integer> l3 = list1.stream().filter(a-> !set.add(a)).collect(Collectors.toList());
		System.out.println(l3);
//		System.out.println("Given the list of integers, find the first element of the list using Stream functions?");
		list1.stream().sorted().findFirst().ifPresent(System.out::println);
//		System.out.println("Given a list of integers, find the total number of elements present in the list using Stream functions?");
		long a = list1.stream().count();
		System.out.println(a);
		int sum = list1.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		int sum1 = 0;
		for(Integer s : list1) {
			sum1 += s;
		}
		System.out.println(sum1);
//		System.out.println("Given a list of integers, find the maximum value element present in it using Stream functions?");
		int l4 = list1.stream().max(Integer::compare).get();
		System.out.println(l4);
//		System.out.println("Given a list of integers, find the Minimum value element present in it using Stream functions?");
		int l5 = list1.stream().min(Integer::compare).get();
		System.out.println(l5);
		//		System.out.println("Given a list of integers, sort all the values present in it using Stream functions?");
		list1.stream().sorted().forEach(System.out::println);
//		System.out.println("Given a list of integers, sort all the values present in it in descending order using Stream functions?");
		list1.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
//		System.out.println("Java 8 program to perform cube on list elements and filter numbers greater than 50.");
		integerList.stream().map(i -> i*i*i).filter(i-> i > 50).forEach(System.out::println);
	}

}
