package com.stream.com.test;

import java.util.Arrays;
import java.util.List;

public class RecursionExample {

	public static void main(String[] args) {
		
		int result = factorial(5);
		System.out.println(result);
		
		int num = 1234;
		List<Integer> list = Arrays.asList(num);
		System.out.println(list);
		int sum = String.valueOf(num)
		                .chars()
		                .map(Character::getNumericValue)
		                .sum();
		System.out.println("Sum of digits: " + sum);
	
	}

	private static int factorial(int i) {
		if(i == 0 || i == 1) {
		return 1;
		}
		return i * factorial(i - 1);
	}

}
