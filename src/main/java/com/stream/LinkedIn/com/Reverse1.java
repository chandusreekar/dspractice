package com.stream.LinkedIn.com;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Reverse1 {

	public static void main(String[] args) {
		String str = "Software Services";
		
		String s1 = "";
//		StringBuilder st = new StringBuilder(str).reverse();
//		String str = st.toString().toUpperCase();
		for(int i =0; i<str.length(); i++) {
			int count = 0;
			if(str.charAt(i) != ' ') {
				for(int j = 0; j< str.length(); j++) {
					if(str.charAt(i) == str.charAt(j) && i != j) {
						count++;
						break;
					}					
				}
				if(count == 0) {
					s1 = s1+ str.charAt(i);
					break;
				}
			}
		}
		System.out.println(s1);
		
		Character s2 = str.chars().filter(c -> c !=' ').map(Character::toUpperCase).mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
		System.out.println(s2);
	}

}
