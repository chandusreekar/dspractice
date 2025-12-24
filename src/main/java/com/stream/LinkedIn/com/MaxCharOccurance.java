package com.stream.LinkedIn.com;

import java.util.Map;
import java.util.stream.Collectors;

public class MaxCharOccurance {

	public static void main(String[] args) {
		String str = "aaaaabbcddddd";
		
		String s1 ="";
		int max = 1;
		for(int i = 0; i<str.length(); i++) {
			int count = 0;
			for(int j = i+1; j<str.length(); j++) {
				if(str.charAt(i) == str.charAt(j) && (i != j)) {
					count++;
				}
			}
			if(count > max) {
				max = count;
				s1 += str.charAt(i);
			}
		}
		System.out.println(s1.repeat(max));
		
		var res = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(s->s, Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).map(e-> e.getKey()).get();
//		System.out.println(res);
	}

}
