package com.stream.LinkedIn.com;

public class RemoveGivenChar {

	public static void main(String[] args) {
		String s = "nacre Software";
		char ch = 'a';
		String s1 = "";
		for(int i=0;i<s.length(); i++) {
			if(s.charAt(i) != ch) {
				s1 += s.charAt(i);
			}
			
		}	
		System.out.println(s1);
		
		String s2 = s.replace("a", "");
		System.out.println(s2);
		
		System.out.println(CheckDigit("I'm Chandra123"));
		System.out.println(CheckDigit("I'm Chandra"));
		
	}

	public static String CheckDigit(String str) {
		for(int i =0; i<str.length(); i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {
				return "Given String contains Digits";
			}
		}
		return "Not Contain Digits";
		
	}
}
