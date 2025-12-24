package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyPractice2 {

	public static void main(String[] args) {
		String s1 = "I'm learning Chandu Stream Api in Java Stream in APi";

		Arrays.stream(s1.split(" ")).filter(e1 -> e1.length() > 5).forEach(System.out::println);
		Arrays.stream(s1.split(" ")).filter(e1 -> e1.length() > 5).sorted().forEach(System.out::println);
		Arrays.stream(s1.split(" ")).filter(e1 -> e1.length() > 3).distinct().forEach(System.out::println);
		Integer str3 = Arrays.stream(s1.split(" ")).map(x -> x.length()).sorted(Collections.reverseOrder()).skip(1)
				.findFirst().get();
		System.out.println("str3 " + str3);

		var lst = Arrays.stream(s1.split(" ")).map(e -> e.replaceAll("[^a-zA-Z]", ""))
				.collect(Collectors.groupingBy(f -> f, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).collect(Collectors.toList());
		System.out.println("List of Duplicate words : " + lst);

		List<Character> duplicateChars = s1.replaceAll("[^a-zA-Z]", "") // remove non-letters
				.toLowerCase().chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(duplicateChars);

		var secondLargest = Arrays.stream(s1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1)
				.findFirst().get();

		System.out.println("Second largest word is : " + secondLargest);

		String largestString = Arrays.stream(s1.split(" ")).sorted(Comparator.comparing(String::length).reversed())
				.skip(1).findFirst().orElse("");
		System.out.println("Largest String " + largestString);

		List<String> duplicateWords = Arrays.stream(s1.split("\\s+"))
				.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase()) // remove punctuation and normalize
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println("Duplicate words: " + duplicateWords);

		var duplicateWords1 = Arrays.stream(s1.split(" ")).map(x -> x.toLowerCase())
				.collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("duplicateWords1 " + duplicateWords1);

		Map<String, Long> map = Arrays.stream(s1.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("map " + map);

		String max = Arrays.stream(s1.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println(max);

		String min = Arrays.stream(s1.split(" ")).min(Comparator.comparing(String::length)).get();
		System.out.println(min);
		System.out.println("====================");
		Arrays.stream(s1.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() > 1)
				.forEach(System.out::println);
		System.out.println("------------------------");
		Arrays.stream(s1.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2)
				.forEach(System.out::println);
		System.out.println("************************");

		String s2 = "chandrasekHar";

		Arrays.stream(s2.split("")).distinct().sorted().forEach(System.out::print);
		Map<String, Long> map1 = Arrays.stream(s2.split("")).map(x -> x.toLowerCase()).filter(x -> x.startsWith("h"))
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println("\n" + map1);

		List<String> obj = Arrays.stream(s2.split("")).map(x -> x.toLowerCase())
				.collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
		System.out.println("Non Repeated Characters" + obj);

		var obj1 = Arrays.stream(s2.split("")).map(x -> x.toLowerCase())
				.collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.collect(Collectors.toList());
		System.out.println(" Characters" + obj1);

	}

}
