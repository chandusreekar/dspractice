package com.stream.com.test;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringToMap {
    public static void main(String[] args) {
        String obj = "ABCDEFABCD";

     List<String> list =    Arrays.stream(obj.split("")).collect(Collectors.toList());
       List<String> dup =  list.stream().filter(x -> Collections.frequency(list, x)== 1).collect(Collectors.toList());
       System.out.println(dup);
       
       Map<String, Long> dup1 =  list.stream().filter(x -> Collections.frequency(list, x)== 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       System.out.println(dup1);
       
       
        
    	int num = 4;
    	int num2 = 2;
    	if (num % 2 == 0) {
    	    System.out.println("Even");
    	} else {
    	    System.out.println("Odd");
    	}

    	System.out.println(num << num2);//16
    }
}