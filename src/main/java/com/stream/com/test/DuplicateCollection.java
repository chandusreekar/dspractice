package com.stream.com.test;
  
 
 import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

 class Person {
     private String name;

     public Person(String name) {
         this.name = name;
     }

     public String getName() {
         return name;
     }
 }

 public class DuplicateCollection {
     public static void main(String[] args) {
         List<Person> people = new ArrayList<>();
         people.add(new Person("Alice"));
         people.add(new Person("Bob"));
         people.add(new Person("Alice"));
         people.add(new Person("Charlie"));
         people.add(new Person("Bob"));

         Map<String, Long> counts = people.stream()
                 .collect(Collectors.groupingBy(
                         Person::getName, TreeMap :: new,  // Group by the 'name' property
                         Collectors.counting() // Count the occurrences of each 'name'
                 ));
         
         System.out.println("Counts "+counts);
         
         
//         Set<Entry<String, Long>> obj = counts.entrySet().stream().collect(Collectors.toSet());
//         System.out.println("Obj "+obj);

         // Filter and print names with count > 1 (duplicates)
         counts.entrySet().stream()
                 .filter(entry -> entry.getValue() > 1)
                 .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
     }
 }

	