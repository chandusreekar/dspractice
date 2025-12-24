package com.stream.test;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Altimetrik5
{
	public static void main(String[] args) {
		String s = "student";
		
		var res = s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(res);
	}
}

// Occurance of each character of string

class Singleton{
	private static Singleton instance;
	
	private Singleton() {
		System.out.println("This is a Singleton class");
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
