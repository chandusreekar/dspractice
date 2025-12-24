package com.stream.LinkedIn.com;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "bananas";
		String s1 = "";
		
		for(int i = 0; i<str.length(); i++) {
			int count = 0;
			if(str.charAt(i) != ' ') {
				for(int j = i+1; j<str.length(); j++) {
					if(str.charAt(i) == str.charAt(j) && i != j) {
						count++;	
					}
				}
				if(count == 0) {
					s1 = s1+ str.charAt(i);
				}
			}
		}
		System.out.println(s1);
		
		Set<Character> set = new LinkedHashSet<>();
		char[] ch = str.toCharArray();
		for(Character c :ch) {
			set.add(c);
		}
		System.out.println(set.stream().map(String::valueOf).collect(Collectors.joining()));
		
		
		var s2 = Arrays.stream(str.split("")).collect(Collectors.toSet());
		System.out.println(s2.stream().map(String::valueOf).collect(Collectors.joining()));
		
	}

}
