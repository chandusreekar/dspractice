package com.stream.com.practice;
public final class Employee {
	private final String name;
	private final float salary;
	private final int age;
	public Employee(String name, float salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	

}
