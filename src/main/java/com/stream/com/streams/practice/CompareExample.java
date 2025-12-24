package com.stream.com.streams.practice;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Student class implements Comparable for natural ordering (by age)

class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    
    public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	// Natural ordering: by age
    @Override
    public int compareTo(Student other) {
        return this.age - other.age;  // ascending order by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class CompareExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(22, "John"));
        students.add(new Student(20, "Alice"));
        students.add(new Student(25, "Bob"));

//        System.out.println("Original List:");
//        students.forEach(System.out::println);

        // Sort using Comparable (natural order - by age)
        Collections.sort(students);
//        System.out.println("\nSorted by Age (using Comparable):");
//        students.forEach(System.out::println);

        // Sort using Comparator (custom order - by name)
        Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);

        Collections.sort(students, nameComparator);
        System.out.println("\nSorted by Name (using Comparator):");
        students.forEach(System.out::println);
        
       List<String> lst = students.stream().filter(x-> x.getAge() > 20).map(x -> x.getName()).collect(Collectors.toList());
       System.out.println("List of "+lst);
        
        Collections.sort(students, Comparator.comparing(Student::getAge).thenComparing(Student::getName));
        System.out.println(students);
    }
}
