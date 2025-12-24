package com.stream.com.test.operators;

public class FactorialRecursion {

	public static void main(String[] args) {
		int fact = FactorialTest.factorial(5);
		System.out.println(fact);

	}

}

class FactorialTest{
	public static int factorial(int n) {
		if(n == 0 || n == 1)
			return 1;
		else
			return n * factorial(n - 1);
		
	}
}