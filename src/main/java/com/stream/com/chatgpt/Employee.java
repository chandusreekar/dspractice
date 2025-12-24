package com.stream.com.chatgpt;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private String dept;
    private String gender;

    public Employee(int id, String name, double salary, String dept, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
        this.gender = gender;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + ", gender=" + gender
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept, gender, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

    

}
