package com.stream.com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		
		// Multiple ways to find the duplicate strings from the above list;
		// 1. Through Set 
		Set<String> originalSet = new HashSet<>();
		Set<String> repeatedSet = new HashSet<>();
		for(String s:list) {
			if(!originalSet.add(s)) {
				repeatedSet.add(s);
			}
		}
		System.out.println("Print s "+repeatedSet);
		

		// Using Collection
		Set<String> repeatedSet2 = new HashSet<>();
		for(String st:list) {
			if(Collections.frequency(list, st) > 1)
			{
				repeatedSet2.add(st);
			}
		}
		System.out.println(repeatedSet2);
		
		// Through Streams
		Set<String> set2 = new HashSet<>();
		
		list.stream().filter(n->!set2.add(n)).forEach(System.out::println);
		
		System.out.println("How to count each element/word from the String ArrayList in Java8?");
		Map<String, Long> strcount1 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(strcount1);
		
		System.out.println("How to find only duplicate elements with its count from the String ArrayList in Java8?");
		Map<String, Long> strCount = list.stream().filter(x -> Collections.frequency(list, x) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(strCount);

		System.out.println("Interview Question");
		
		List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		
		List<Integer> obj3 = list1.stream().sorted((e1,e2)->e2.compareTo(e1)).collect(Collectors.toList());
		System.out.println("Finding the 2nd largest Value :  " +obj3.get(0) );
		
		Optional<Integer> obj4 = list1.stream().sorted((a1,a2)-> a2.compareTo(a1)).skip(1).findFirst();
		System.out.println("Data for 2nd largest value  "+obj4);
		
		System.out.println("Given a list of integers, find out all the even numbers that exist in the list using Stream functions?");
		list1.stream().sorted().filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
		list1.stream().map(s -> s + "") // Convert integer to String
				.filter(s -> s.startsWith("1")).forEach(System.out::println);

		System.out.println("How to find duplicate elements in a given integers list in java using Stream functions?");
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<Integer>();
		myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);

		System.out.println("Given the list of integers, find the first element of the list using Stream functions?");
		myList.stream().findFirst().ifPresent(System.out::print);

		System.out.println("Given a list of integers, find the total number of elements present in the list using Stream functions?");
		long count = myList.stream().count();
		System.out.println(count);

		System.out.println("Given a list of integers, find the maximum value element present in it using Stream functions?");
		int max = myList.stream().max(Integer::compare).get();
		System.out.print(max);
		
		System.out.println("Given a list of integers, find the maximum value element present in it using Stream functions?");
		int min = myList.stream().min(Integer::compare).get();
		System.out.print(min);
		
		System.out.println("Given a list of integers, sort all the values present in it using Stream functions?");
		myList.stream().sorted().forEach(System.out::print);

		System.out.println("Given a list of integers, sort all the values present in it in descending order using Stream functions?");
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
		List<Integer> l =myList.stream().sorted((l1,l2)->l2.compareTo(l1)).collect(Collectors.toList());
		System.err.print(l);
		System.out.println("Java 8 program to perform cube on list elements and filter numbers greater than 50.");
		List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
		integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::print);

	}

}
