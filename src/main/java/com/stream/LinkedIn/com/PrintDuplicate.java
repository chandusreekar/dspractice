package com.stream.LinkedIn.com;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintDuplicate {

	public static void main(String[] args) {
		String str = "Programming";
		
		String s1 = "";
		for(int i =0; i<str.length(); i++) {
			int count = 1;
			if(str.charAt(i) != ' ') {
				for(int j = i+1; j<str.length(); j++) {
					if(str.charAt(i) == str.charAt(j) && (i != j))
						count++;
				}
			}
			if(count > 1) {
				s1 = s1 + str.charAt(i)+ " ";
			}
		}
		System.out.println(s1);
		
		var s2 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(e ->e.getKey()).collect(Collectors.toList());
		
		System.out.println(s2);
		
		String st = "";
		for(int i =0; i<str.length(); i++) {
			int count = 1;
			if(str.charAt(i) != ' ') {
				for(int j = i+1; j<str.length(); j++) {
					if(str.charAt(i) == str.charAt(j) &&  (i != j)) {
						count++;
					}
				}
			}
			if(count > 1) {
				st += str.charAt(i)+" : "+count + " ";
			}
		}
		
		System.out.println(st);
		
		var s3 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toList());
		System.out.println(s3);
	}

}
