package com.stream.com.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Palindrome {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("level", "java", "radar", "world");

		var palindrome = words.stream().filter(e -> new StringBuilder(e).reverse().toString().equals(e))
				.collect(Collectors.toList());
		System.out.println(palindrome);
	}
}
