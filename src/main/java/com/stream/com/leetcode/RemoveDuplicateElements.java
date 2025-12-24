package com.stream.com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3};
		
		int count =0;
		for(int i = 0; i<arr.length; i++) {
			if(i<arr.length -1 && arr[i] == arr[i+1]) {
				continue;
			}else {
				arr[count] = arr[i];
				count++;
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for(int num : set) {
			System.out.println(num);
		}
		
//		System.out.println(count);

	}

}
