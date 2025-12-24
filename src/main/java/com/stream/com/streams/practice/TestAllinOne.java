package com.stream.com.streams.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestAllinOne {

	public static void main(String[] args) {
		int a[] = {1,5,3,2};
		int b[] = {4,6,2,1};
		
		int c[] = new int[a.length + b.length];
		
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		
		int arr[] = Arrays.stream(c).sorted().toArray(); System.out.println(Arrays.toString(arr));
		int arr1[] = Arrays.stream(c).sorted().distinct().toArray(); System.out.println(Arrays.toString(arr1));
		int obj = Arrays.stream(arr1).reduce((e1,e2) -> e1+e2).getAsInt(); System.out.println(obj);
		int obj1 = Arrays.stream(arr1).filter(x -> x % 2 == 0).reduce((e1,e2) -> e1+e2).getAsInt(); System.out.println(obj1);
		int obj2 = Arrays.stream(arr1).filter(x -> x % 2 != 0).reduce((e1,e2) -> e1+e2).getAsInt(); System.out.println(obj2);
		
		List<Integer> lst = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).boxed().collect(Collectors.toList());
		int i = lst.stream().sorted(Collections.reverseOrder()).distinct().findFirst().get(); System.out.println(i);
		int i1 = lst.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get(); System.out.println(i1);
		int i2 = lst.stream().limit(3).sorted((x1,x2) -> x2.compareTo(x1)).distinct().skip(1).findFirst().get(); System.out.println(i2);
		int i3 = lst.stream().min(Integer::compare).get(); System.out.println(i3);
		int i4 = lst.stream().sorted().limit(3).max(Integer::compare).get(); System.out.println(i4);
		Map<Integer, Long> map1 = lst.stream().filter(x -> Collections.frequency(lst, x) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map1);
		Map<Integer, Long> map2 = lst.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map2);
		
		double d = lst.stream().mapToInt(Integer::intValue).average().getAsDouble(); System.out.println(d);
		
		int sum = lst.stream().mapToInt(Integer::intValue).sum(); System.out.println(sum);
		
//		------------------------------------------------------------------------------------------------
		List<Integer> list2 = Arrays.asList(10, 15, 8,26, 27, 26, 49, 25, 98, 32, 25, 10, 98, 22, 22);
		Map<String, Long> obj3 = list2.stream().filter(x -> Collections.frequency(list2, x)>1).map(x -> String.valueOf(x)).filter(x -> x.startsWith("2"))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(obj3);
		
		List<Integer> obj4 = list2.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(obj4);
		
		
		
	}

}
