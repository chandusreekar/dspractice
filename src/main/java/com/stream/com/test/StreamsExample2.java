package com.stream.com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee2{
	int empId;
	String fname;
	String lname;
	float salary;
	public Employee2(int empId, String fname, String lname, float salary) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
		return "Employee [empId=" + empId + ", fname=" + fname + ", lname=" + lname + ", salary=" + salary + "]";
	}
	
}
public class StreamsExample2 {

	public static void main(String[] args) {
		List<Employee2> emp = new ArrayList<>();
		emp.add(new Employee2(1, "Chandra", "Bakhar", 50000));
		emp.add(new Employee2(2, "Darling", "Anjani", 90000));
		emp.add(new Employee2(3, "Bhanu", "Chiru", 30000));
		emp.add(new Employee2(4, "Abhi", "Dhavan", 70000));
		emp.add(new Employee2(5, "Chandra", "Bakhar", 50000));
		
		Map<String, Integer> nameAgeCounts = emp.stream()
                .collect(Collectors.toMap(
                		e -> e.getFname() + "-" + e.getSalary(), // Combine name and age
                		e -> 1, // Initial count is 1
                        Integer::sum // Merge function for duplicate keys
                ));

        // Filter and print entries with count > 1 (duplicates)
        nameAgeCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    
		
		Map<String, Long> count = emp.stream().collect(Collectors.groupingBy(Employee2::getFname, Collectors.counting()));
		count.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
		
		
		List<Employee2> fname = emp.stream().sorted((e1,e2)->e1.fname.compareTo(e2.fname)).collect(Collectors.toList());
		System.out.println("Sorted with First Name : "+fname);
		
		List<String> list1 = emp.stream().sorted((e1,e2)->e1.lname.compareTo(e2.lname)).filter(e->e.salary>30000).map(e->e.fname).collect(Collectors.toList());
		System.out.println(list1);
		
		Map<Integer, String> list2 = emp.stream().sorted((e1,e2)->e1.lname.compareTo(e2.lname)).filter(e->e.salary>30000).collect(Collectors.toMap(Employee2::getEmpId, Employee2::getFname));
		System.out.println(list2);
		

	}

}
