package com.stream.com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WiproTest1 {

	public static void main(String[] args) {

		String str = "Programmingm";
		String s = str.replace("ram", "");
		String st = new StringBuilder(s).reverse().toString();
		System.out.println(st);
		
		//Progming -> "g","n"....,"P" -> gnimgorP
		
		var res = IntStream.range(0, s.length()).mapToObj(i -> s.charAt(s.length()-1-i)).map(String::valueOf).collect(Collectors.joining());
		System.out.println(res);
		
		var res1 = s.chars().mapToObj(c -> (char)c).collect(Collectors.toList()); System.out.println(res1);
		Collections.reverse(res1);
		System.out.println(res1);
		var res2 = res1.stream().map(String::valueOf).collect(Collectors.joining()); System.out.println(res2);
		
		var nonrepeatingChar = Arrays.stream(str.split("")).map(e -> e.toLowerCase()).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).map(e-> e.getKey()).get();
		System.out.println(nonrepeatingChar);
		String sg = "Pro gra mmin gm";
		var res3 = Arrays.stream(sg.split(" ")).filter(s1 -> !s1.isEmpty())       // remove any empty parts
        .reduce((first, second) -> second) // get the last word
        .map(String::length)
        .orElse(0);
		
		System.out.println(res3);
		//int s = str.length();
		List<String> list = Arrays.stream(str.split(" ")).collect(Collectors.toList());
//		list.get(s);
		System.out.println(list.get(list.size()-1).length());
		
		int length = Arrays.stream(str.trim().split("\\s+"))
                .filter(s2 -> !s2.isEmpty())       // remove any empty parts
                .reduce((first, second) -> second) // get the last word
                .map(String::length)
                .orElse(0);

        System.out.println("Length of last word: " + length);
        
        var highest = Arrays.stream(sg.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println(highest);
		
        int[] arr = {1,2,3,4,5,6,7,8};
        List<Integer> lst = List.of(1,2,3,4,5,6,7,8);
        
        var even = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(even.get(true));  System.out.println(even.get(false));
        
        int k = 6; 
        int n = arr.length;
        int[] newArr = new int[n];
        for(int i =0; i<n; i++) {
        	newArr[i] = arr[(i + k)%n];
        }
        System.out.println(Arrays.toString(newArr));
        
       var arr2=  IntStream.range(0, arr.length).map(i -> arr[arr.length-1-i]).toArray();
        System.out.println(Arrays.toString(arr2));

	

	}

}
