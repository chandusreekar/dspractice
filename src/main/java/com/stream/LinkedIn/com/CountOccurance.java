package com.stream.LinkedIn.com;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountOccurance {

	public static void main(String[] args) {
		String str ="apple";
		
		var res = Arrays.stream(str.split("")).collect(Collectors.groupingBy(f -> f, Collectors.counting()));
		System.out.println(res);
	}

}
