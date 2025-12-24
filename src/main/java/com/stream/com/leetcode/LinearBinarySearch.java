package com.stream.com.leetcode;

public class LinearBinarySearch {

	public static void main(String[] args) {
		int nums[] = {2,4,7,10,13,15};
		int target = 1;
		
		int result = linearSearch(nums, target);
		int result1 = binarySearch(nums, target, 0, nums.length-1);
		if(result != -1) {
//			System.out.println("Element Found at the Index "+result);
		}
		if(result1 != -1) {
			System.out.println("Element Found at the Index "+result1);
		}
		else {
			System.out.println("Element Not Found");
		}

	}

	public static int binarySearch(int[] nums, int target, int firstIndex, int lastIndex) {

		if(firstIndex <= lastIndex) {
			int mid = (firstIndex + lastIndex)/2;
			
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				return binarySearch(nums, target, mid+1, lastIndex);
			}else {
				return binarySearch(nums, target, firstIndex, mid - 1);
			}
		}
		
//		int firstIndex = 0;
//		int lastIndex = nums.length -1;
//		while(firstIndex <= lastIndex) {
//			int mid = (firstIndex + lastIndex)/2;
//			
//			if(nums[mid] == target) {
//				return mid;
//			}else if(nums[mid] < target) {
//				firstIndex = mid + 1;
//			}else {
//				lastIndex = mid - 1;
//			}
//		}
		return -1;
	}

	public static int linearSearch(int[] nums, int target) {
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == target) {
				return i;
			}
		}
		return -1;
	}

}
