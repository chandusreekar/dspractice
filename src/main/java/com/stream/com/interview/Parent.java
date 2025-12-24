package com.stream.com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Parent {

    public static void display() {

        System.out.println("static::parent");

    }

    public void show() {

        System.out.println("parent");

    }

    public static void main(String[] args) {

        Child ob = new Child();

        ob.show();

        ob.display();
        
        String s1 = "ABC";
        String s2 = new String("ABC");
        String s3 = new String("ABC");
        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 1);
        map.put(s2, 2);
        map.put(s3, 3);
        System.out.println("map size : " + map.size());

        System.out.println("Get Map : "+ map.get(s1));
        
        Map<Student, Integer> hm = new HashMap<>();
        hm.put(new Student(1,"ravi"),100);
        hm.put(new Student(1,"ravi"),200);
        Integer i = hm.get(new Student(1,"ravi"));
        System.out.println(i);
        System.out.println("Map Size " +hm.size());
    }

}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return id == other.id && name.equals(other.name);
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}


class Child extends Parent {

    public static void display() {

        System.out.println("static::child");

    }

    public void show() {

        System.out.println("Child");

    }

}