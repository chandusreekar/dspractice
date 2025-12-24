package com.stream.com.streams.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsAllInOne {

	public static void main(String[] args) {
		int a[] = {1,5,3,2};
		int b[] = {4,6,2,1};
		int c[] = new int[a.length + b.length];
		
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		int arr[] = Arrays.stream(c).sorted().distinct().toArray(); System.out.println(Arrays.toString(arr));
		
		List<Integer> list = Arrays.stream(c).sorted().distinct().boxed().collect(Collectors.toList()); System.out.println(list);
		
		int sum =	Arrays.stream(c).reduce((e1,e2) -> e1+e2).getAsInt(); System.out.println(sum);
		long min = list.stream().min(Integer :: compare).get(); System.out.println(min);
		long max = list.stream().max(Integer::compare).get(); System.out.println(max);
		
		int arr1[] = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray(); System.out.println(Arrays.toString(arr1));
		List<Integer> arr2 = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().boxed().collect(Collectors.toList()); System.out.println(arr2);
		Set<Integer> arr3 = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().boxed().collect(Collectors.toSet()); System.out.println(arr3);
		int sum1  = list.stream().filter(e->e % 2 == 0).mapToInt(Integer :: intValue).sum(); System.out.println(sum1);
		double avg = list.stream().mapToInt(Integer :: intValue).average().getAsDouble(); System.out.println("Average  "+avg);
		
		//===================================================================================================================================================
		
		String s1 = "I'm learning Stream Api in Java";
		
		String str = Arrays.stream(s1.split(" ")).max(Comparator.comparing(String :: length)).get(); System.out.println("Max String "+str);
		
		String str1 = Arrays.stream(s1.split(" ")).min(Comparator.comparing(String :: length)).get(); System.out.println("Min String "+str1);
		
		String s2 = "adbcefad";
		
		Arrays.stream(s2.split("")).distinct().sorted().forEach(System.out :: print);
		
		Integer str3 = Arrays.stream(s1.split(" ")).map(x->x.length()).sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.print(str3);
		
		Map<String, Long> map = Arrays.stream(s1.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		Arrays.stream(s1.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2).forEach(System.out::println);
		
		Arrays.stream(s1.split(" ")).filter(e -> e.replaceAll("[^aeiouAEIOU]", "").length() > 1).forEach(System.out :: println);

		// ==========================================================================================================================================================
		List<String> list11 = Arrays.asList("AA", "BB", "DD", "AA", "CC", "DD");
		
		List<String> ab = list11.stream().distinct().collect(Collectors.toList()); 
		System.out.println(ab);
		
		List<String> bc = list11.stream().filter(e-> Collections.frequency(list11, e)>1).collect(Collectors.toList());
		System.out.println(bc);
		
		Map<String, Long> cd = list11.stream().filter(e->Collections.frequency(list11, e)>1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(cd);
		
		Map<String, Long> d = list11.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
		System.out.println("DDDD => "+d);
		
		Map<String, Long> e = list11.stream().collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));
		System.out.println(e);
		
		List<String> f = list11.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry :: getKey).collect(Collectors.toList());
		System.out.println(f);
		
		List<String> g = list11.stream().filter(e1 -> e1.startsWith("D")).collect(Collectors.toList());System.out.println(g);
		
		
		// ==========================================================================================================================================================
		

		List<Integer> list2 = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 25, 10, 98);
		
		List<Integer> aa = list2.stream().distinct().collect(Collectors.toList());
		System.out.println(aa);
		
		List<Integer> a1 = list2.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(a1);
		
		Optional<Integer> a2 = list2.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst();
		System.out.println(a2);
		
		List<Integer> a3 = list2.stream().distinct().sorted((e1,e2)-> e2.compareTo(e1)).collect(Collectors.toList());
		System.out.println(a3);
		
		Integer a4 = list2.stream().distinct().reduce((e1,e2) -> e1+e2).get();
		System.out.println(a4);
		
		Integer a5 = list2.stream().max(Integer::compare).get();
		System.out.println(a5);
		
		Integer a6 = list2.stream().filter(e1-> e1%2 ==0 ).mapToInt(Integer::intValue).sum();
		System.out.println(a6);
		
		double a7 = list2.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(a7);
		
		List<String> a8 = list2.stream().map(s-> String.valueOf(s)).filter(x -> x.startsWith("2")).collect(Collectors.toList());
		System.out.println(a8);
		
		Map<Integer, Long> ln = list2.stream().collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));
		System.out.println(ln);
		
		Map<Integer, Long> ln1 = list2.stream().filter(x -> x % 2 == 0).filter(x-> Collections.frequency(list2, e) > 1)
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println(ln1);
		
		int i = list.stream().distinct().sorted().limit(5).mapToInt(Integer::intValue).sum();
		System.out.println(i);

	
		// ==========================================================================================================================================================
		
		
		// ==========================================================================================================================================================
		List<Employee> emp = new ArrayList<>();
		
		emp.add(new Employee("Akshitha","Krithik", 90000));
		emp.add(new Employee("Shankar","Vijay", 20000));
		emp.add(new Employee("Manu","Sindu", 50000));
		emp.add(new Employee("Nanna","Amma", 30000));
		
		List<Employee> em = emp.stream().filter(x -> x.getSalary() > 30000).collect(Collectors.toList());
		System.out.println(em);
		
		List<Employee> em1 = emp.stream().sorted((e1,e2)-> e1.getFname().compareTo(e2.getFname())).collect(Collectors.toList());
		System.out.println(em1);
		
		List<String> l = emp.stream().filter(x-> x.getSalary() > 30000).sorted((e1,e2)-> e1.getFname().compareTo(e2.getFname())).map(x -> x.getLname()).collect(Collectors.toList());
		System.out.println(l);
		
		Collections.sort(emp, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getLname));
		System.out.println(emp);
		
		Comparator<Employee> com = Comparator.comparing(Employee::getSalary);
		Employee l1 = emp.stream().min(com).get(); System.out.println(l1);
		Employee l2 = emp.stream().skip(1).max(com).get(); System.out.println(l2);
	}

}
