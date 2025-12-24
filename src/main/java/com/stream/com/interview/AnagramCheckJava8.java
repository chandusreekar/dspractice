package com.stream.com.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramCheckJava8 {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		return s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.equals(t.chars().mapToObj(c -> (char) c)
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram")); // true
		System.out.println(isAnagram("rat", "car")); // false
		
		// Grouped Anagrams
		String[] arr = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };

		var sol = Arrays.stream(arr).map(String::trim).collect(Collectors.groupingBy(word -> {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
			
		}));
		
		List<String> list = Arrays.asList( "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" );
		
		var res = list.stream().map(String::trim).collect(Collectors.groupingBy(word -> {
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
		}));
		
		System.out.println("list : "+res);
		
		
//        var sol = Arrays.stream(arr).map(String::trim).collect(Collectors.groupingBy(word -> {
//        	char[] chars = word.toCharArray();
//        	Arrays.sort(chars);
//        	return new String(chars);
//        }));
        
        var sol1 = sol.values().stream().filter(k-> k.size() > 1).collect(Collectors.toList());
        System.out.println(sol1);

	}
}
