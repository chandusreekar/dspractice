package com.stream.com.leetcode;

public class BinarySearch1 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4,5};
		int target = 4;
		int res = BinarySearchTest(nums, target);
		if(res != -1) {
			System.out.println("Element found at "+res);
		} else {
			System.out.println("Element not found");
		}

	}

	private static int BinarySearchTest(int[] nums, int target) {
		int firstIndex = 0;
		int lastIndex = nums.length -1;
		while(firstIndex <= lastIndex) {
			int mid = (firstIndex + lastIndex)/2;
			if(nums[mid] == target) {
				 return  mid;
			}else if(nums[mid] < target) {
				firstIndex = mid + 1;
			}else {
				lastIndex = mid - 1;
			}
		}
		return -1;
		
	}

}
