package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyPractice1 {

	public static void main(String[] args) {
		int arr1[] = {9,3,5,2,3};
		int arr2[] = {0,4,1,6,5};

		int arr3[] = new int[arr1.length + arr2.length];
		
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
		System.out.println(Arrays.toString(arr3));
		
		int[] newArr = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
		System.out.println(Arrays.toString(newArr));
		
		List<Integer> arrList = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().collect(Collectors.toList());
		System.out.println(arrList);
		
		List<Integer> arrList1 =  arrList.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(arrList1);
		
		List<Integer> duplicates = arrList.stream().filter(e1 -> Collections.frequency(arrList, e1)>1).collect(Collectors.toList());
		System.out.println("Duplicates "+duplicates);
		
		Map<Integer, Long> duplicates1 = arrList.stream().filter(e1 -> Collections.frequency(arrList, e1)>1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(duplicates1);
		
		Map<Integer, Long> eachCount = arrList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(eachCount);
		
		long sum = arrList.stream().reduce((e1, e2) -> e1+e2).get();
		System.out.println(sum);
		
		long sumOfEvenNumbers = arrList.stream().filter(e1 -> e1%2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfEvenNumbers);
		
		long sumOfOddNumbers = arrList.stream().filter(e1 -> e1%2 != 0).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfOddNumbers);
		
		long sumOfMultiplyNumbers = arrList.stream().map(e1 -> e1*2).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfMultiplyNumbers);
		
		long sumOfAddBy2Numbers = arrList.stream().map(e1 -> e1+2).mapToInt(Integer::intValue).sum();
		System.out.println(sumOfAddBy2Numbers);
		
		long count = arrList.stream().count(); System.out.println(count);
		long min = arrList.stream().min(Integer::compare).get();	System.out.println(min);
		long max = arrList.stream().max(Integer::compare).get();	System.out.println(max);
		double avg = arrList.stream().mapToInt(Integer::intValue).average().getAsDouble();	System.out.println(avg);
	}

}
