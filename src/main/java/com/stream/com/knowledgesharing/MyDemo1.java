package com.stream.com.knowledgesharing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyDemo1 {

	public static void main(String[] args) {
		int a[] = {1,5,3,2};
		int b[] = {4,6,2,1};
		
		// Creating a new array with array a and array b
		int c[] = new int[a.length + b.length];
		// one way of doing
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		System.out.println("Array String "+ Arrays.toString(c));
		
		// Getting the array data without duplicates and in ascending order
		int[] arrnonDup = Arrays.stream(c).distinct().sorted().toArray();
		System.out.println("Array Non Duplicates "+ Arrays.toString(arrnonDup));
		
		// Another way of doing arrays to List or set using Boxed and collecting as a list or set
		Set<Integer> obj = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).boxed().collect(Collectors.toSet()); // set will not allow the duplicates also we can use distinct()
		System.out.println(obj);
		
		// Using distinct() and getting as a list
		List<Integer> obj1 = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).distinct().sorted().boxed().collect(Collectors.toList());
		
		System.out.println(obj1);
		
		// COnverting an arrays a,b as a List
		List<Integer> object = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).boxed().collect(Collectors.toList());
		
		// Print Even numbers from the list
		var even = object.stream().filter(e -> e % 2 == 0).collect(Collectors.toSet());
		System.out.println("Even numbers from the list "+even);
		
		// printing the odd numbers then removing the duplicates and sorting in reverse order
		var odd = object.stream().filter(e -> e % 2 != 0).distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("printing the odd numbers then removing the duplicates and sorting in reverse order "+odd);
		
		var odd1 = object.stream().filter(e -> e % 2 != 0).distinct().sorted((e1,e2) -> e1.compareTo(e2)).collect(Collectors.toList());
		System.out.println("printing the odd numbers then removing the duplicates and sorting in Natural order "+odd1);
		
		System.out.println("List of Data "+object);
		
		var oddNumbers = object.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
		System.out.println("List of oddNumbers "+ oddNumbers);
		var sumOfOddNumbers = object.stream().filter(e -> e % 2 != 0).reduce((e1,e2) -> e1+e2).get();
		System.out.println("sumOfOddNumbers "+ sumOfOddNumbers);
		
		var evenNumbers = object.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
		System.out.println("evenNumbers "+ evenNumbers);
		
		var sumOfEvenNumbers = object.stream().distinct().filter(e -> e % 2 == 0).mapToInt(Integer::valueOf).sum();
		System.out.println("sumOfEvenNumbers "+ sumOfEvenNumbers);
		
		var max = object.stream().max(Integer::compare).get();
		System.out.println("Maximum number "+max);
		
		var min = object.stream().min(Integer::compare).get();
		System.out.println("Minimum Number "+min);
		
		var avg = object.stream().distinct().filter(e -> e % 2 == 0).mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(avg);
		
		var addition = object.stream().filter(e -> e % 2 == 0).map(e -> e + 2).distinct().collect(Collectors.toList());
		System.out.println("Filtering even numbers and adding those numbers with 2 "+addition);
		
		var with2 = object.stream().map(e -> e+"").filter(e -> e.startsWith("2")).collect(Collectors.toList());
		System.out.println("Numbers Starts With 2 by converting Integer to Sting in map method  "+with2);
		
		var with4 = object.stream().map(e -> String.valueOf(e)).filter(e -> e.contains("4")).collect(Collectors.toList());
		System.out.println("Numbers Starts With 2 by converting Integer to Sting in map method  "+with4);
		
		var count = object.stream().filter( e -> Collections.frequency(object, e) > 1 ).collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println("Count of duplicate elements in the list "+count);
		
		var count1 = object.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Count of Each element in a list "+count1);
		
		
		

	}

}
