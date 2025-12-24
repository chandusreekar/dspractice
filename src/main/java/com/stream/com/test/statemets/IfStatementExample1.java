package com.stream.com.test.statemets;

public class IfStatementExample1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		
		int marks=65;  
	      
	    if(marks<35){  
	        System.out.println("fail");  
	    }  
	    else if(marks>=50 && marks<60){  
	        System.out.println("D grade");  
	    }  
	    else if(marks>=60 && marks<70){  
	        System.out.println("C grade");  
	    }  
	    else if(marks>=70 && marks<80){  
	        System.out.println("B grade");  
	    }  
	    else if(marks>=80 && marks<90){  
	        System.out.println("A grade");  
	    }else if(marks>=90 && marks<100){  
	        System.out.println("A+ grade");  
	    }else{  
	        System.out.println("Invalid!");  
	    }  
		
		
		int age =20;
		int weight = 30;
		
		 if(age>=18){    
			 System.out.println("age is greater than or equals to 18");
		        if(weight>50){  
		            System.out.println("You are eligible to donate blood");  
		        }    
		        else {
		        	System.out.println("You are not eligible to donate the blood");
		        }
		    }    
		 else {
			 System.out.println("Age is not matching ");
		 }
		
		
		
		
		
		
		
		
		
		
		
//		int s= 5;
//		int j= 10;
//		
//		
//		if(false) {
//			System.out.println("Printing of the values "+s +" And " +j);
//		}
//		else if(true) {
//		System.out.println("There is a else if condition");
//		} 
//		else {
//			System.out.println("There is a else statement");
//		}
//		if(s+j ==15) {
//			System.out.println("yes entered into if statemet");
//		}
//		else {
//		System.out.println("Not entered into if statemet");
//		}
////		
////		
//		if(s+j > 20) {
//			System.out.println("Yes..!!, I'm into the 'Simple If Statemet ' ");
//		}
//		else {
//		System.out.println("Oh Shut I'm out of If condition");
//		}
	}

}
