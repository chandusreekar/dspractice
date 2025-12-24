package com.stream.test;

public class Synechron1StRound {

	public static void main(String[] args) {

		
		int[] arr = {1, 2, 3, 4,5};
		
		boolean flag = false;
		for(int i = 0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++)
			if(arr[i] == arr[j]) {
				
				flag = true;
				
			}
		}
		System.out.println(flag);
		
		int target = 3;
		int res = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == target) {
				res = i;
			}
		}
		System.out.println(res);
		
		int firstIndex = 0;
		int lastIndex = arr.length -1;
		while(firstIndex <= lastIndex) {
			int mid = (firstIndex + lastIndex)/2;
			
			if(arr[mid] == target) {
				res = mid;
			}else if(arr[mid] < target) {
				firstIndex = mid + 1;
			}else {
				lastIndex = mid - 1;
			}
		}
		System.out.println(""+res);
		

	}

}




//Given a sorted array and a target value, find the index of the target using binary search. If the target is not found, return -1.  
//
//Input:   
//
//• N (size of the array), followed by N sorted integers.
//
//• X (target value).
//
//                Output: Index of X or -1 if not found.






//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
//		 
//Example 1:
//
//Input: nums = [1, 2, 3, 3]
//
//Output: true
//
//Example 2:
//
//Input: nums = [1, 2, 3, 4]
//
//Output: false
