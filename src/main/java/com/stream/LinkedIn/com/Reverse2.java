package com.stream.LinkedIn.com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Reverse2 {

	public static void main(String[] args) {
		String str = "Software services";
		String s1 = "";
		
		String st = str.toLowerCase();
		for(int i = st.length() -1; i>=0; i--) {
			int count = 0;
			if(st.charAt(i) != ' ') {
				for(int j = 0; j< st.length(); j++) {
					if(st.charAt(i) == st.charAt(j) && i != j) {
						count++;
						break;
					}
				}
				if(count == 0) {
					s1 = s1+st.charAt(i);
					break;
				}
			}
		}
		System.out.println(s1);
		StringBuilder sb = new StringBuilder(st).reverse();
		var s2 = sb.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
		System.out.println(s2);
	}

}
