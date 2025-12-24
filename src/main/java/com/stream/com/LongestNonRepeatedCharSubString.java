package com.stream.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestNonRepeatedCharSubString {

	public static void main(String[] args) {
		longestSubString("abcabcdab");

	}

	private static void longestSubString(String str) {
		String lonestSubString = null;
		int longestSubStringLength = 0;
		
		
		
		Map<Character, Integer> map = new LinkedHashMap<>();
//		char[] arr =str.toCharArray();
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(!map.containsKey(ch)) {
				map.put(ch, i);
			}
			else {
				i = map.get(ch);
				map.clear();
			}
			if(longestSubStringLength < map.size()) {
				longestSubStringLength = map.size();
				lonestSubString = map.keySet().toString();
			}
		}
		System.out.println(longestSubStringLength);
		System.out.println(lonestSubString);
		
						
		Set<Character> set = new HashSet<>();
		int left = 0;
		int maxLength = 0;
		
		for(int i = 0; i< str.length(); i++) {
			while(set.contains(str.charAt(i))) {
				set.remove(str.charAt(i));
				left++;
			}
			set.add(str.charAt(i));
			maxLength = Math.max(maxLength, i - left + 1);
		}
		System.out.println(maxLength);
		System.out.println(set.toString());
		
		
		int start = 0;
		int end = 0;
		int max_length = 0;
		
		String longestSubString = null;
		
		List<Character> list = new ArrayList<>();

		while(end < str.length()) {
			if(!list.contains(str.charAt(end))) {
				list.add(str.charAt(end));
				end++;
				max_length = Math.max(max_length, list.size());
				longestSubString = list.toString();
			}
			else {
				list.remove(Character.valueOf(str.charAt(start)));
				start++;
			}
		}
		System.out.println(max_length);
		System.out.println(longestSubString);
	}

}
