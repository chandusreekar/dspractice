package com.stream.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayCopy {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k = 2;
		int n = arr.length;
		k = k%n;
		int[] arrCopy = new int[n];
		for(int i = 0; i<n; i++) {
			arrCopy[i] = arr[(i+k)%n];
		}
		System.out.println(Arrays.toString(arrCopy));
		
		 // if k is greater than n
		
		int arr1[] = IntStream.concat(Arrays.stream(arr, k,n), Arrays.stream(arr, 0, k)).toArray();
		System.out.println(Arrays.toString(arr1));
		
		int arr2[] = IntStream.concat(Arrays.stream(arr, n-k,n), Arrays.stream(arr, 0, n-k)).toArray();
		System.out.println(Arrays.toString(arr2));
		
		

		String s = "mmississippin";
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
	    
	    var res = s.chars().mapToObj(c -> (char)c)
	        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
	        .entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
	    System.out.println(res);
	    for(int i = 0; i<s.length(); i++) {
	    	if(s.charAt(i) == res) {
	    		return i;
	    	}
	    }
		return -1;
	}

}
