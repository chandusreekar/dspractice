package com.stream.test;

import java.util.stream.IntStream;

public class MphasisTest1 {

	public static void main(String[] args) {
		
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		var res = IntStream.range(0, nums.length).flatMap(i -> IntStream.range(i+1, nums.length).map(j -> nums[i]+nums[j])).max().getAsInt();
		System.out.println(res);
		
		int minSum = nums[0];
		int maxSum = nums[0];
		
		for(int i =0; i<nums.length; i++) {
			minSum = minSum+nums[i];
			
			if(maxSum < minSum) {
				maxSum = minSum;
			}
		}
		System.out.println(maxSum);
	}
	
}




