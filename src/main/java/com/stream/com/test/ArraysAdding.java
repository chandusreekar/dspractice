package com.stream.com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysAdding {

	public static void main(String[] args) {
		int arr1[] = new int[] {1,3,5,7};
		int arr2[] = {2,4,6,8};

		int[] obj = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
		System.out.println("Array Obj 0 "+Arrays.toString(obj));
		
		List<Integer> obj1 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().boxed().collect(Collectors.toList());
		System.out.println("Object 1 "+obj1);
		
		int arr3[] = new int[arr1.length+arr2.length]; 
		
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		
		List<Integer> list = Arrays.stream(arr3).sorted().boxed().collect(Collectors.toList());
		System.out.println("List "+list);
		
		int arr4[] = new int[] {8, 13, 11, 9, 12, 10,15};
		
		int arr5[] = new int[arr3.length+arr4.length];
		
		System.arraycopy(arr3, 0, arr5, 0, arr3.length);
		System.arraycopy(arr4, 0, arr5, arr3.length, arr4.length);
		List<Integer> list2 = Arrays.stream(arr5).sorted().filter(n->n%2==0).boxed().collect(Collectors.toList());
		System.out.println("List2 "+list2);
		Set<Integer> list3 = Arrays.stream(arr5).sorted().filter(n->n%2==0).boxed().collect(Collectors.toSet());
		System.out.println("List3 "+list3);
		
		
	}

}

