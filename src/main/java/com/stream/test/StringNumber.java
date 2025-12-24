package com.stream.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringNumber {

	public static void main(String[] args) {
		String str = "AAAABBBCCCCCAAA";

		Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		String result = map.entrySet().stream().map(e -> e.getValue() + "" + e.getKey()).collect(Collectors.joining());
		System.out.println(result);

	}

}
