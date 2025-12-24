package com.stream.com.streams.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsAllInOne4 {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("Akshitha","Krithik", 90000));
		emp.add(new Employee("Shankar","Vijay", 20000));
		emp.add(new Employee("Manu","Sindu", 50000));
		emp.add(new Employee("Nanna","Amma", 30000));
		
		var em = emp.stream().sorted((e1, e2) -> e1.getFname().compareTo(e2.getFname())).map(x -> x.getFname()).collect(Collectors.toList()); 
		
		Collections.sort(emp, Comparator.comparing(Employee::getFname).thenComparing(Employee::getSalary));
		System.out.println(emp);
		
//		List<Employee> em = emp.stream().filter(e -> e.getSalary() > 30000).collect(Collectors.toList());
		System.out.println(em);
//		
//		List<Employee> em1 = emp.stream().sorted((e1,e2)-> e1.getFname().compareTo(e2.getFname())).collect(Collectors.toList());
//		System.out.println(em1);
//		
//		List<String> l = emp.stream().filter(e-> e.getSalary() > 30000).sorted((e1,e2)-> e1.getFname().compareTo(e2.getFname())).map(x -> x.getLname()).collect(Collectors.toList());
//		System.out.println(l);
//		
//		Collections.sort(emp, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getLname));
//		System.out.println(emp);
//		
//		Comparator<Employee> com = Comparator.comparing(Employee::getSalary);
//		Employee l1 = emp.stream().min(com).get(); System.out.println(l1);
//		Employee l2 = emp.stream().skip(1).max(com).get(); System.out.println(l2);
	}

}
  