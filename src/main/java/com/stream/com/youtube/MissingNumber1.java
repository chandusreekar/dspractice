package com.stream.com.youtube;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,6,7};
		
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		
		int sum1 = 0;
		for(int j = 1; j<=7; j++) {
			sum1 = sum1 + j;
		}
		System.out.println(sum1 - sum);
		
		var diff = IntStream.rangeClosed(Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()).sum()
				- Arrays.stream(arr).sum();
		System.out.println(diff);
		
	}

}
