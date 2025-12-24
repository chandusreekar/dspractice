package com.stream.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AltimetrikTest2 {

	public static void main(String[] args) {
//		[‘ABC’,’abc’,’a1c’,’123’,’123a’,’ABC’,’DGF’]
		
		List<String> list = Arrays.asList("ABC","abc","a1c","123","123a","ABC","DGF");
	
		var response = list.stream().map(e -> e.toUpperCase()).filter(s -> s.matches("[a-zA-Z]+")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(response);
		
		String str = "hello how are you";
		var firstNonrepeatedChar = str.chars().filter(c -> c != ' ').mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
		System.out.println(firstNonrepeatedChar);
		
		
		List<Employee> emp = Arrays.asList(
                new Employee(1, "Alice", 60000, "IT", LocalDate.of(2023, 12, 10)),
                new Employee(2, "Bob", 55000, "HR", LocalDate.of(2024, 2, 5)),
                new Employee(3, "Charlie", 70000, "Finance", LocalDate.of(2024, 5, 20)),
                new Employee(4, "David", 80000, "IT", LocalDate.of(2024, 7, 15)),
                new Employee(5, "Eva", 65000, "HR", LocalDate.of(2025, 1, 8))
        );
		var res = emp.stream().filter(e -> e.getJoiningDate().getYear() >= 2024).collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(res);
		
		
		
	}

}

