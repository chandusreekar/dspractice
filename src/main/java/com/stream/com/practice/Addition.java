package com.stream.com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;



public class Addition {

	
	public static int add(int a, int b) {
		return a+b;
		
	}
	public static void main(String[] args) {
		String s1 = "I'm learning Stream Api in Java";
		String s2 = "I'm learning Stream Api in Java Stream Java";
		String s = Arrays.stream(s1.split(" "))
				.sorted(Comparator.comparing(String::length).reversed())
				.distinct()
				.skip(1)
				.findFirst()
				.orElse("Nothing to Print");
		System.out.println(s);
		
		var res = Arrays.stream(s2.split(" "))
				.map(e -> e.replaceAll("[^a-zA-Z]", "").toLowerCase())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(x -> x.getValue() > 1)
				.map(x -> x.getKey())
				.collect(Collectors.toList());
		System.out.println(res);
		
		var rs = s1.replaceAll("[^a-zA-Z]", "").toLowerCase()
				.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(f->f, Collectors.counting()))
				.entrySet().stream()
				.filter(e -> e.getValue() > 1).map(e -> e.getKey())
				.collect(Collectors.toList());
		System.out.println(rs);
		
		String input = "chandrasekhar";
		
		var result = Arrays.stream(input.split("")).collect(Collectors.groupingBy(f->f, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(e->e.getKey()).distinct().sorted().collect(Collectors.toList());
		System.out.println(result);
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Chandra", 10000, 40));
		empList.add(new Employee("Saurabh", 20000, 30));
		empList.add(new Employee("Kalyan", 20000, 50));
		
		Collections.sort(empList, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary).thenComparing(Employee::getAge));
		
//		System.out.println(empList);
		
		Addition add = new Addition();
//		myFirstInterview.getNthHighestSalaryGroup(empList, 1);
		add.getEmployee(empList, 2);
		
	}

	public List<List<Employee>> getEmployee(List<Employee> list, int n) {

//		var list1 = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(n - 1).collect(Collectors.toList());
		var list1 = list.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream()
				.sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).skip(n - 1).limit(1).map(Map.Entry::getValue)
				.collect(Collectors.toList());

		System.out.println(list1);
		return list1;

	}

}
