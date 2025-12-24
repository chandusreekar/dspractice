package com.stream.com.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee1 {
    private int id;
    private String name;
    private double salary;
    private String dept;
    private String gender;

    public Employee1(int id, String name, double salary, String dept, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }
}

public class AvgSalaryByDept {
    public static void main(String[] args) {
        List<Employee1> emp = new ArrayList<>();
        emp.add(new Employee1(1, "praveen", 50000, "java", "male"));
        emp.add(new Employee1(2, "john", 90000, "api", "female"));
        emp.add(new Employee1(3, "chandra", 30000, "rest", "male"));
        emp.add(new Employee1(4, "alice", 70000, "java", "female"));

        Map<String, Double> avgSalaryByDept = emp.stream()
            .collect(Collectors.groupingBy(
                Employee1::getDept,
                Collectors.averagingDouble(Employee1::getSalary)
            ));

        avgSalaryByDept.forEach((dept, avgSalary) ->
            System.out.println(dept + " => " + avgSalary));
        
        var response = emp.stream().collect(Collectors.groupingBy(Employee1::getDept, Collectors.averagingDouble(Employee1::getSalary)));
        response.forEach((k, v) -> System.out.println(k +" "+ v));
        
        var obj = emp.stream().collect(Collectors.groupingBy(Employee1::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee1::getSalary))));
        System.out.println(obj);

        

		
		String str1 = "chandrasekhar";
		
		var res = Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream().filter(e->e.getValue() == 1).map(e->e.getKey()).collect(Collectors.toList());
		System.out.println(res);
		
		int num = 12345;
		int reversed = 0;
		String str2 = String.valueOf(num);
		System.out.println(str2);
		Arrays.stream(str2.split("")).sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
		while(num !=0) {
			reversed = reversed * 10 + num%10;
			num = num/10;
		}
		System.out.println();
		System.out.println(reversed);
//		Write a program to remove subString from the string and reverse it by the Java 8
		String str = "Programming";
//		Remove " ram";
		String s = str.replace("ram", "");
		 Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).forEach(System.out::print);
		 Arrays.stream(str.split("")).distinct().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		String rev =  IntStream.range(0, s.length()).mapToObj(i -> s.charAt(s.length() -1 -i)).map(String::valueOf).collect(Collectors.joining());
		System.out.println(rev);
//		System.out.println(result);
		
		int a = 10;
		int b = 20;
		
		int temp = 0;
		
//		temp = a;
		a = a*b;
		b = a/b;
		a = a/b;
		System.out.println(a + " : a  <==>  b : "+b);
           
		
//		 System.out.println(avgSalaryByDept);
    }
}
