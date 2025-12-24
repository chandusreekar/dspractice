package com.stream.com.exception;

public class TestCustomException1 {

	public static void main(String[] args) {
		try {
			InvalidAgeException.invalid(17);
		} catch (Exception e) {
			System.out.println("Exception Occured");
			System.out.println(e);
		} finally {
			System.out.println("Please Utilize your Vote if you are eligible for voting");
		}
		
	}

}

class InvalidAgeException extends Exception{
	public InvalidAgeException(String str) {
		super(str);
	}
	public static void invalid(int age) throws InvalidAgeException{
		if(age < 18) {
			throw new InvalidAgeException("Not eligible for Vote");
		}
		else {
			System.out.println("Welcome to Vote");
		}
	}
}