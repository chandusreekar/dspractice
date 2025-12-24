package com.stream.com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface Test{
//	public void draw();
	public String draw1(String name);
}
class Employee{
	int empId;
	String fname;
	String lname;
	float salary;
	public Employee(int empId, String fname, String lname, float salary) {
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
public class LambdaExpressionExample2 {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "Chandra", "Sekhar", 50000));
		emp.add(new Employee(2, "Jailer", "Rajini", 90000));
		emp.add(new Employee(3, "BShankar", "Chiru", 30000));
		emp.add(new Employee(4, "Bro", "Pavan", 70000));
		
		
		List<Float> sal = new ArrayList<>();
		for(Employee empl : emp) {
			if(empl.salary > 30000) {
				sal.add(empl.salary);
			}
		}
		System.out.println("List of salary who are getting More than 30000 "+ sal);   //		Output : [50000.0, 90000.0, 70000.0]
		
		
		
		System.out.println("**********************************************************************************");
		
		emp.stream().filter(p->p.salary>30000).collect(Collectors.toList()).forEach(System.out::println);// Working code
		emp.stream().filter(employee->employee.salary>30000).collect(Collectors.toList()).forEach(employee-> System.out.println(employee.fname+" "+employee.lname +" "+employee.salary));
	
		System.out.println("**********************************************************************************");
		
		List<Employee> empObj = emp.stream().filter(p->p.salary>30000).collect(Collectors.toList());
		System.out.println("List of salary who are getting More than 30000 "+ empObj); 

		System.out.println("**********************************************************************************");
		
		List<String> lname = emp.stream().sorted((e1,e2)->e1.fname.compareTo(e2.fname)).filter(e->e.salary>=30000).map(e->e.lname).collect(Collectors.toList());
		System.out.println("Filtering Based on Salary and Sorting based on Fist Name but Retriving the data based on Last name "+ lname); // Output : [Chiru]

		Map<Integer, String> lname1 = emp.stream().sorted((e1,e2)->e1.fname.compareTo(e2.fname)).filter(e->e.salary>=30000).collect(Collectors.toMap(Employee::getEmpId, Employee::getLname));
		System.out.println("By Using toMap() : "+lname1);
		System.out.println("**********************************************************************************");
		
		
		 Collections.sort(emp, Comparator.comparing(Employee::getFname).thenComparing(Employee::getSalary));
		 System.out.println("Testing "+emp);
		 
		 System.out.println("**********************************************************************************");
		 
		 Comparator<Employee> byfname = (e1,e2)->e1.fname.compareTo(e2.fname);
		 Comparator<Employee> bySalary = (e1,e2) -> Float.compare(e1.salary, e2.salary);
//		 List<Employee> e= emp.stream().sorted((e1,e2)->e1.fname.compareTo(e2.fname).thenComparing((e1,e2) -> Float.compare(e1.salary, e2.salary))).collect(Collectors.toList());
		List<Employee> e= emp.stream().sorted(byfname.thenComparing(bySalary)).collect(Collectors.toList());
		System.out.println(e);
//		 Collections.sort(emp,byfname.thenComparing(bySalary)); // Working code
		System.out.println("**********************************************************************************");
		
		Comparator<Employee> comparator = Comparator.comparing( Employee::getSalary );
		
		Employee minObject = emp.stream().min(comparator).get();
		System.out.println("Min Value Object is : "+minObject);
		System.out.println("**********************************************************************************");
		Employee maxObject = emp.stream().max(comparator).get();
		System.out.println(" Max Value Salary is : "+maxObject.salary);
		
		System.out.println("**********************************************************************************");

		long count = emp.stream().filter(p->p.salary>30000).count();
		System.out.println("Count of Emplayee who's salary above 30000 is: "+count +" Employees");
	}

}
