package com.stream.test;

import java.time.LocalDate;

class Employee {
    private int empId;
    private String empName;
    private double empSalary;
    private String department;
    private LocalDate joiningDate;

    public Employee(int empId, String empName, double empSalary, String department, LocalDate joiningDate) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    public int getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public double getEmpSalary() { return empSalary; }
    public String getDepartment() { return department; }
    public LocalDate getJoiningDate() { return joiningDate; }

    @Override
    public String toString() {
        return empName + " (" + department + ", " + joiningDate + ")";
    }
}
