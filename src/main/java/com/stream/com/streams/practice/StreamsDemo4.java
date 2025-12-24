package com.stream.com.streams.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	private String fname;
	private String lname;
	private float salary;

	public Employee(String fname, String lname, float salary) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", salary=" + salary + "]";
	}

}

public class StreamsDemo4 {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("Chalamaaih", "Venkata", 50000));
		emp.add(new Employee("Venkata", "Subbamma", 30000));
		emp.add(new Employee("Chandra", "Sekhar", 90000));
		emp.add(new Employee("AkshithA", "KritiK", 20000));

//		List<Employee> obj = emp.stream().filter(e -> e.getSalary() > 30000).collect(Collectors.toList());
//		System.out.println(obj);
//
//		emp.stream().filter(e -> e.getSalary() < 30000).collect(Collectors.toList())
//				.forEach(e -> System.out.println(e.getFname() + " : " + e.getLname()));
//
//		List<String> lname = emp.stream().sorted((e1, e2) -> e1.getFname().compareTo(e2.getFname()))
//				.filter(e -> e.getSalary() > 30000).map(e -> e.getLname()).collect(Collectors.toList());
//		System.out.println(lname);
//
//		Map<String, String> lname1 = emp.stream().sorted((e1, e2) -> e1.getLname().compareTo(e2.getLname()))
//				.filter(e -> e.getSalary() < 30000).collect(Collectors.toMap(Employee::getFname, Employee::getLname));
//		System.out.println(lname1);
//		
//		Collections.sort(emp, Comparator.comparing(Employee::getLname).thenComparing(Employee::getSalary).thenComparing(Employee::getFname));
//		System.out.println(emp);
//		
//		Comparator<Employee> lst = Comparator.comparing(Employee::getSalary);
//		Employee db = emp.stream().max(lst).get(); System.out.println(db);
//
//		Employee db1 = emp.stream().min(lst).get(); System.out.println(db1);
//		
//		long l3 = emp.stream().filter(e -> e.getSalary() > 30000).count();  System.out.println(l3);

		List<Employee> obj1 = emp.stream().filter(e -> e.getSalary() > 30000).collect(Collectors.toList());
		System.out.println(obj1);
		
		emp.stream().filter(e->e.getSalary()<30000).collect(Collectors.toList()).forEach(e-> System.out.println(e.getFname() + " : "+ e.getLname()));
		
		List<String> obj2 = emp.stream().sorted((e1,e2) -> e1.getFname().compareTo(e2.getFname())).filter(e->e.getSalary() > 30000).map(e -> e.getLname()).collect(Collectors.toList());
		System.out.println(obj2);
		
		Map<String, String> obj3 = emp.stream().sorted((e1,e2)-> e1.getLname().compareTo(e2.getLname())).filter(e->e.getSalary()<30000).collect(Collectors.toMap(Employee::getFname, Employee::getLname));
		System.out.println("Obj3  "+obj3);
		
		Collections.sort(emp, Comparator.comparing(Employee::getFname).thenComparing(Employee::getSalary));
		System.out.println(emp);
		
		Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
		Employee max = emp.stream().max(comparator).get(); System.out.println(max);
		Employee min = emp.stream().min(comparator).get(); System.out.println(min);
		long count  = emp.stream().filter(e->e.getSalary()>30000).count(); System.out.println(count + " Employess");
	}

}
