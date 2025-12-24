package com.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
 
public class MainTest {

    public static void main(String[] args) {

        TreeSet<Student> st = new TreeSet<>();
        st.add(new Student(1, "Alex", 20));
        st.add(new Student(2, "John", 21));
        st.add(new Student(3, "Rony", 22));
        st.add(new Student(4, "Jimmy", 23));

        System.out.println(st.size());
        
        List<Student> student = new ArrayList<Student>();
        student.add(new Student(1, "Tri",37));
		student.add(new Student(2, "Frini",48));
		student.add(new Student(3, "Srinivasan",18));
		student.add(new Student(4, "Srini",18));
		
		var res = student.stream().max(Comparator.comparingInt(Student::getAge)).get();
		System.out.println(res);
		
		List<Integer> lst = Arrays.asList(1,2,3,4,5,6);
		
		var odd = lst.stream().filter(e -> e%2 !=0).mapToInt(Integer::intValue).sum();
		System.out.println(odd);
		
		
		List<Student> lststud = Arrays.asList(
				new Student(0, "srini",25),
				new Student(1,"srini",25),
				new Student(2, "vasan",25),
				new Student(3, "vasan",25),
				new Student(4, "kaviya",25),
				new Student(5, "varshini",25));
 
		Map<String,List<Student>> res1 = lststud.stream().collect(Collectors.groupingBy(Student::getName));
		System.out.println(res1);
		
    }

}
 
 
class Student implements Comparable{

    private int id;
    private String name;
    private int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        return Integer.compare(this.id, s.id);
    }

}
