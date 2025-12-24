package com.stream.com.exception;

public class TestMyException {

	public static void main(String[] args) {
		try {
			InvalidAgeException1.chakAgeGroup(15);
			InvalidAgeException1.chakAgeGroup(19);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
 class InvalidAgeException1 extends RuntimeException{
	 public InvalidAgeException1(String str) {
		 super(str);
	 }
	 public static void chakAgeGroup(int age) throws InvalidAgeException1{
		 if(age > 18)
			 System.out.println("The Person trying to vote is Eligible");
		 else
			 System.out.println("The Person trying to vote is Not Eligible");
	 }
 }