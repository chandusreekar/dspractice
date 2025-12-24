package com.stream.com.chatgpt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPracticeForEmploee {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
        emp.add(new Employee(1, "praveen", 50000, "java", "male"));
        emp.add(new Employee(2, "john", 90000, "api", "female"));
        emp.add(new Employee(3, "chandra", 70000, "rest", "male"));
        emp.add(new Employee(4, "alice", 70000, "java", "female"));
       
        
        var obj = emp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream()
        		.sorted((e1,e2) -> e2.getKey().compareTo(e1.getKey())).skip(1).limit(1).map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println(obj);
        var res1= emp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream()
        		.filter(e -> e.getKey() > 50000).collect(Collectors.toList());
        System.out.println(res1);
        
        emp.stream().filter(e-> e.getSalary() > 50000).map(Employee::getName).forEach(System.out::println);
        
        var res2 = emp.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(res2);
        
        var res3 = emp.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(res3);
        
        var res4 = emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).distinct().skip(1).findFirst().get();
        System.out.println(res4);
        int n = 3;
        var res5 = emp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream().sorted((e1,e2) -> e2.getKey().compareTo(e1.getKey()))
        		.skip(n-1).findFirst().get();
        System.out.println("Response : "+res5);
        
        var res6 = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(res6);
        
        var res7 = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(res7);

        var res8 = emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getSalary)));
        System.out.println(res8);
        
        var res9 = emp.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summingDouble(Employee::getSalary)));
        System.out.println(res9);
        
        var res10 = emp.stream().collect(Collectors.partitioningBy(e-> e.getSalary() > 50000));
        System.out.println(res10);
        
        
	}

}
