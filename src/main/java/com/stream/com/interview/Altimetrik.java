package com.stream.com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Altimetrik {

	
	public static void main(String[] args) {
		
		String list = "AABCDB";
		List<String> ob = Arrays.asList(list);
		System.out.println(ob);
		List<Entry<String, Long>> l = Arrays.stream(list.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() > 1).collect(Collectors.toList());
		
		System.out.println(l);		
		
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "praveen", 50000, "java", "male"));
		emp.add(new Employee(3, "chandra", 30000, "rest", "male"));
		emp.add(new Employee(2, "john", 90000, "api", "female"));
		
		var obj = emp.stream().filter(e1 -> e1.getGender().contentEquals("male")).sorted(Comparator.comparing(Employee::getEmployeeSalary)).collect(Collectors.toList());
		System.out.println(obj);
		//		emp.entrySet().stream().sorted()
		Collections.sort(emp, Comparator.comparing(Employee::getEmployeeId).thenComparing(Employee::getEmployeeSalary));
		System.out.println(emp);
		
		

		int[] arr1 = {1, 3, 2, 1, 7, 5, 4};
		int[] arr2 = {2, 6, 2, 9, 7, 8, 4, 0};
		
		var lst = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().collect(Collectors.toList());
		System.out.println(lst);
		
		var result = lst.stream().filter(e -> Collections.frequency(lst, e) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result);
	
		var avgSalary = emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getEmployeeSalary)));
		System.out.println(avgSalary);
		
		Map<String, Optional<Employee>> maxSalary = emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getEmployeeSalary))));
		System.out.println(maxSalary);
//		Set<Integer> set = new HashSet<>();
//		list.stream().filter(n-> !set.add(n)).forEach(System.out::println);

	}

}
