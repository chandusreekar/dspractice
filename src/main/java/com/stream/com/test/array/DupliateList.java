package com.stream.com.test.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DupliateList {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		
		// 1 to Print by skipping duplicates
		List<String> dup1 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(dup1);
		
		// 2
		Set<String> set1 = new HashSet<>();
		list.stream().filter(a->!set1.add(a)).forEach(System.out::println);
		
		// 3
		Set<String> original = new HashSet<>();
		Set<String> repeated = new HashSet<>();
		for(String str : list) {
			if(!original.add(str)) {
				repeated.add(str);
			}
		}
		System.out.println("Original "+original);
		System.out.println("Repeated "+repeated);
		
		// 4
		Set<String> duplicate = new HashSet<>();
		for(String obj : list) {
			if(Collections.frequency(list, obj) > 1) {
				duplicate.add(obj);
			}
		}
		System.out.println(duplicate);
		
		// Through Map
				Map<String, Integer> frequencyMap = new HashMap<>();

				for (String str : list) {
				    frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
				}

				for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
				    if (entry.getValue() > 1) {
				        System.out.println("Repeated: " + entry.getKey());
				    }
				}
	}

}
