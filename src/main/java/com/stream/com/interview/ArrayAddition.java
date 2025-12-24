package com.stream.com.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayAddition {

	public static void main(String[] args) {
		int a[] = {1,5,3,2};
		int b[] = {4,6,2,1};
		
		int c[] = new int[ a.length + b.length];
		
		
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		
		int arr[] = Arrays.stream(c).sorted().toArray();
		System.out.println("Print Array"+Arrays.toString(arr));
		
		List<Integer> d = Arrays.stream(c).sorted().boxed().collect(Collectors.toList());
		System.out.println("Print D"+d);
		
		int obj1[] =  IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println("Print Obj1 "+Arrays.toString(obj1));
		
		List<Integer> list = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().boxed().collect(Collectors.toList());
		System.out.println("Print List"+list);

		Set<Integer> set = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().filter(m-> m%2==0).boxed().collect(Collectors.toSet());
		System.out.println("Print Set "+set);
		
		String s1 = "I'm learning Stream Api in Java";
		
		String result = Arrays.stream(s1.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println(result);
		
		String s2 = "adbcefad";
		
		Arrays.stream(s2.split("")).distinct().sorted().forEach(System.out::print);
		
	}

}
