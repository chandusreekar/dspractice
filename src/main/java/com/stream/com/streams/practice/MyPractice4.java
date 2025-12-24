package com.stream.com.streams.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyPractice4 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		List<String> lst1 = list.stream().filter(x -> Collections.frequency(list, x)>1).distinct().collect(Collectors.toList());
		System.out.println(lst1);
		
		Map<String, Long> lst2 = list.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println(lst2);
		
		List<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee("Akshitha","Krithik", 90000));
		emp.add(new Employee("Shankar","Vijay", 20000));
		emp.add(new Employee("Manu","Sindu", 50000));
		emp.add(new Employee("Nanna","Amma", 30000));
		
		List<Employee> ls = emp.stream().filter(x-> x.getSalary() >40000).collect(Collectors.toList());
		System.out.println(ls);
		
		List<Employee> ls1 = emp.stream().filter(x-> x.getSalary() >= 30000).sorted((e1,e2)-> e1.getFname().compareTo(e2.getFname())).collect(Collectors.toList());
		System.out.println(ls1);
		
		List<String> ls2 = emp.stream().filter(x-> x.getSalary() >= 30000).sorted((e1,e2)-> e1.getFname().compareTo(e2.getFname())).map(x->x.getLname()).collect(Collectors.toList());
		System.out.println(ls2);
		
		Collections.sort(emp, Comparator.comparing(Employee::getLname).thenComparing(Employee::getSalary));
		System.out.println(emp);
		
		Comparator<Employee> ls3 = Comparator.comparing(Employee::getSalary);
		Employee f1 = emp.stream().max(ls3).get(); System.out.println(f1);
		Employee f2 = emp.stream().min(ls3).get(); System.out.println(f2);
		
		var maxSalary1 = emp.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(maxSalary1);
		
		var maxSalary2 = emp.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(maxSalary2);
	}

}
