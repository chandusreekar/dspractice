package com.stream.com.leetcode;

public class BubbleSort {

	public static void main(String[] args) {
		int []arr = {2,0,9,3,6,1,10};
		int temp = 0;
		for(int i = 0; i<arr.length; i++) {
			for (int j = i+1; j< arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
//			System.out.println();
//			for(int nums : arr)   {
//				System.out.print(nums +" ");
//			}
		}
//		System.out.println();
		for(int nums : arr) {
			System.out.print(nums +" ");
		}

	}

}
