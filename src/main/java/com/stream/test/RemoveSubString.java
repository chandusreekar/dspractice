package com.stream.test;

public class RemoveSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " Programming ";
		String s = new StringBuilder(str.replace("ram", "")).reverse().toString();
	    System.out.println("Result: " + s);
	    
	    MyTest.getMessage();
	}

}

class MyTest{
	public static void getMessage() {
		System.out.println("I'm Printing Static Method");
	}
}