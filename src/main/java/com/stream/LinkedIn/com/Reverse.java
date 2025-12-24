package com.stream.LinkedIn.com;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reverse {

	public static void main(String[] args) {
		String str = "Chandra";
		String reverse = "";
		for(int i = str.length()-1; i >=0; i--) {
			reverse = reverse + str.charAt(i);
		}
		System.out.println(reverse);

		// Second Approach
		String s1 = new StringBuffer(str).reverse().toString(); System.out.println(s1);
		// Or
		String s2 = new StringBuilder(str).reverse().toString(); System.out.println(s2);
		//Or
		StringBuffer s3 = new StringBuffer(str).reverse(); System.out.println(s3);
		// Or
		StringBuilder s4 = new StringBuilder(str).reverse(); System.out.println(s4);
		
		String s5 = IntStream.range(0, str.length()).mapToObj(i -> str.charAt(str.length() -1 -i)).map(String::valueOf).collect(Collectors.joining());
		System.out.println(s5);
	}

}
