package com.stream.com.interview;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SynechronTest1 {

	public static void main(String[] args) {

		
		String input="Hello world hello HELLO World world World";
        
        List<String> response = Arrays.stream(input.split(" "))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e->e.getValue()>2)
            .map(e-> e.getKey()).collect(Collectors.toList());
            
            System.out.println(response);
	
	}

}
