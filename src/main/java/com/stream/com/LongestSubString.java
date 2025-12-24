package com.stream.com;

import java.util.*;

public class LongestSubString {

	public static void main(String[] args) {
		String str = "abcabcdab";
		
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		char[] arr = str.toCharArray();
		String lss = null;
		int lssl = 0;
		for(int i = 0; i< arr.length; i++) {
			char ch = arr[i];
			if(!map.containsKey(ch)) {
				map.put(ch, i);
				
			}else {
				i = map.get(ch);
				map.clear();
			}
			
		}
		if(map.size() > lssl) {
			lssl = map.size();
			lss = map.keySet().toString();
		}
		System.out.println(lssl);
		System.out.println(lss);
		
		
		
		
		
		
		
		
		// java
		
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
