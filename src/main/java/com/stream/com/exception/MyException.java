package com.stream.com.exception;

class MyException1 extends Exception{
	
	public MyException1(String string) {
		super(string);
	}

}

public class MyException{
	public static void riskymethod() throws MyException1{
		throw new MyException1("It's my own Exception");
	}
	public static void main(String[] args) {
		try {
			riskymethod();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
