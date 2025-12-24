package com.stream.com.youtube;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

	public static void main(String[] args) {
		String s1 = "Hello java";
		// 1st Approach
		int len = s1.length();
		String str = "";
		for(int i = len-1; i>=0; i--) {
			str = str+s1.charAt(i);
		}
		System.out.println(str);
		
		var res = IntStream.range(0, len).mapToObj(i -> s1.charAt(s1.length() -1 -i)).map(String::valueOf).collect(Collectors.joining());
		System.out.println(res);
		// 2nd Approach
		String s2 = new StringBuffer(s1.replace("ll", "")).reverse().toString();
		System.out.println(s2);
		
		String s3 = new StringBuilder().reverse().toString();
		System.out.println(s3);
	}

}
