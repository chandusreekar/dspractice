package com.stream.com.test.operators;

public class FibanacciRecursion {

	
	public static void main(String[] args) {
		
		System.out.print(FibanacciTest.n1 + " " + FibanacciTest.n2 );
		FibanacciTest.fibnacci(10);
	}

}
class FibanacciTest{
	 static int n1 = 0, n2 = 1, n3;

	public static void fibnacci(int n) {
		if(n > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
			fibnacci(n -1);
		}	
	}
}