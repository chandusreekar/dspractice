package com.stream.com.chatgpt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsAll {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();
		set.add(1);
//		1. How to remove duplicates from a list using Java 8 Streams?
		List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
		var res1 = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println(res1);
//		Sum and Average using Stream
		var sum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		var avg = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
		int[] arr = {1, 2, 2, 3, 4, 4, 5};
		long summing = Arrays.stream(arr).summaryStatistics().getSum(); System.out.println(summing);
		System.out.println(avg);
//		2.How to find the first non-repeated character in a String?
		String input = "programming";
		var res2 = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(f -> f, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
		System.out.println(res2);

		List<String> lis = Arrays.asList("chan", "asdf", "chandra", "java");
		var response = lis.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(response);

		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "praveen", 50000, "java", "male"));
		emp.add(new Employee(2, "john", 90000, "api", "female"));
		emp.add(new Employee(3, "chandra", 70000, "rest", "male"));
		emp.add(new Employee(4, "alice", 70000, "java", "female"));

		int x = 2;

		var nthHighSalary = emp.stream().collect(Collectors.groupingBy(Employee::getSalary)).entrySet().stream()
				.sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).skip(x - 1).limit(1).map(Entry::getValue)
				.collect(Collectors.toList());
		System.out.println(nthHighSalary);

		Map<Boolean, List<Employee>> partitioned = emp.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
		System.out.println("Even: " + partitioned.get(true));
		System.out.println("Odd: " + partitioned.get(false));

		var res3 = emp.stream().sorted(Comparator.comparing(Employee::getGender).thenComparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println(res3);

		Collections.sort(emp, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
		System.out.println(emp);

		var res4 = emp.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(res4);

		var res5 = emp.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println(res5);

		var res6 = emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();
		System.out.println(res6);

		List<List<String>> list = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
		var res7 = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(res7);

		List<String> names = Arrays.asList("java", "spring", "java", "hibernate", "spring");

		List<Entry<String, Long>> result = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).collect(Collectors.toList());
		System.out.println(result);

//        Convert Map to List
		Map<Integer, String> map = Map.of(1, "A", 2, "B", 3, "C");

		List<Entry<Integer, String>> newList = new ArrayList<>(map.entrySet());

		System.out.println(newList);

		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);

		Map<Boolean, List<Integer>> partitioned1 = numbers1.stream()
				.collect(Collectors.partitioningBy(n -> n % 2 == 0));

		System.out.println("Even: " + partitioned1.get(true));
		System.out.println("Odd: " + partitioned1.get(false));

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

//        List<Integer> list3 = list1.stream().map(list1.addAll(list2)).collect(Collectors.toList());

		List<Integer> common = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println(common);

		List<Integer> Duplist = Arrays.asList(1, 2, 3, 2, 4, 1, 5);

		var dupRes = Duplist.stream().collect(Collectors.groupingBy(f -> f, TreeMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());

		System.out.println(dupRes);

		String str = "Java is awesome";

		long count = str.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count();
		System.out.println(count);

		List<String> words = Arrays.asList("level", "java", "radar", "world");

		var palindrome = words.stream().filter(e -> new StringBuilder(e).reverse().toString().equals(e))
				.collect(Collectors.toList());
		System.out.println(palindrome);

		var obj = emp.stream().collect(Collectors.partitioningBy(emp1 -> emp1.getSalary() > 50000));
		System.out.println(obj.get(true));
		System.out.println(obj.get(false));

		String strng = "hello world2";

		var maxChar = strng.toLowerCase().chars().mapToObj(c -> (char) c).filter(Character::isLetterOrDigit)
				.collect(Collectors.groupingBy(f -> f, Collectors.counting())).entrySet().stream()
				.max(Entry.comparingByValue()).map(Entry::getKey).get();
		System.out.println(maxChar);

		String strn = "Java programming";

		strn.toLowerCase().chars().mapToObj(c -> (char) c).distinct().sorted(Comparator.reverseOrder())
				.forEach(System.out::print);

		String result2 = strn.chars().mapToObj(c -> (char) c)
//                .filter(c -> c != ' ') // optional: remove this line if you want to keep spaces
//                .map(Character::toLowerCase) // optional: normalize case
				.collect(Collectors.toCollection(LinkedHashSet::new)) // remove duplicates, preserve order
				.stream().collect(Collectors.collectingAndThen(Collectors.toList(), list5 -> {
					Collections.reverse(list5); // reverse list
					return list5.stream().map(String::valueOf).collect(Collectors.joining());
				}));

		System.out.println("Result: " + result2);

		String result3 = strn.chars().mapToObj(c -> (char) c).filter(c -> c != ' ')
				.collect(Collectors.toCollection(LinkedHashSet::new)).stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
					Collections.reverse(lst);
					return lst.stream().map(String::valueOf).collect(Collectors.joining());
				}));
		System.out.println(result3);

		List<String> list4 = Arrays.asList("A", "B", "C", "A", "B", "D", "E");
		
		var response4 = list4.stream().collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		System.out.println(response4);
		
		var res = response4.entrySet().stream().collect(Collectors.toMap(e-> e.getKey(), p -> p.getValue()));
		System.out.println(res);
		
		List<String> list3 = Arrays.asList("ABC", "BCD", "CA", "ABCD", "B", "DSDFGH", "E");
		
		var result0 = list3.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(result0);
		var r2 = emp.stream().filter(e -> e.getSalary() > 50000).map(Employee::getName).collect(Collectors.toList());
		System.out.println(r2);

		List<Integer> lists = Arrays.asList(9, 2, 5, 3, 6, 7, 1);

		var res0 = lists.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(res0);

		String strs = "its my interview";
		var res11 = strs.chars().mapToObj(c -> (char) c).filter(c -> c != ' ')
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(res11);

		var res22 = res11.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
		System.out.println(res22);

		List<Number> list5 = List.of(1, 9, 101, 8.1, 9.6, 1.001, 89, 19);

		var response5 = list5.stream().map(String::valueOf).filter(e -> e.startsWith("1")).collect(Collectors.toList());
		var response1 = list5.stream().map(s -> s + "").filter(e -> e.endsWith("1")).collect(Collectors.toList());
		System.out.println(response5);
		System.out.print(response1);

		List<Double> list6 = Arrays.asList(1.0, 9.0, 101.0, 8.1, 9.6, 1.001, 89.0, 19.0);

		List<Double> result6 = list6.stream().filter(num -> {
			String str6 = String.valueOf(num);
			return str6.startsWith("1") || str6.endsWith("1");
		}).collect(Collectors.toList());
		System.out.println(result6);

	}

}
