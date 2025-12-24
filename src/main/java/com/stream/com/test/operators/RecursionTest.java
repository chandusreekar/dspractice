package com.stream.com.test.operators;

public class RecursionTest {

	public static void main(String[] args) {
		int obj = RecTest1.sum(5);
		System.out.println(obj);
		
		int obj2 = RecTest1.multiply(5);
		System.out.println(obj2);
		
		System.out.print(RecTest1.n1 + " " + RecTest1.n2);
		RecTest1.fibanocci(10);
		
	}

}

class RecTest1{
	public static int sum(int n) {
		if(n == 0) {
			return 0;
		}
		else {
			return n + sum(n-1); // 5+4+3+2+1
		}
		
	}

	// Factorial Number
	public static int multiply(int n) {
		if(n == 0 || n == 1) {
			return 1;
		} else {
			return n * multiply(n-1); // 20 * 
		}
	}
	
	static int n1 = 0, n2 =1, n3;
	// fibanocci series is 0 1 1 2 3 5 8 13 21 34.... etc
	public static void fibanocci(int n) {
		if(n > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
			fibanocci(n-1);
		}
		 
	}

}

