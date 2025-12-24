package com.stream.com.test.statemets;

public class IfStatementExample2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		
		if(true) 
			System.out.println("Yes..!!, I'm into the 'Simple If Statemet ' ");
		else 
			System.out.println("Oh Shut I'm out of If condition");
		
		int val = 10;
		
		if(val==10)
			System.out.println("Yes..!!, I'm into the 'Simple If Statemet ' ");
		else
		System.out.println("Oh Shut I'm out of If condition");
		
		if(val!=10)
			System.out.println("Yes..!!, I'm into the 'Simple If Statemet ' ");
		else
		System.out.println("Oh Shut I'm out of If condition");
		
		String username = "123Shaik";
		String name = "Sameer"; // we are getting from User database
		String name2 = "Sameer"; // ffrom UI we are giving this nmae
		
		if(name==name2)
			System.out.println("Yes..!!, I'm into the Facebook or Insta Home page ");
		else
		System.out.println("User Not authorized");
		
		if(name.equals(name2))
			System.out.println("Yes..!!, I'm into the 'Simple If Statemet ' ");
		else
		System.out.println("Oh Shut I'm out of If condition");
	}

}
