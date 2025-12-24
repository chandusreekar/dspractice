package com.stream.com.singleton.designpattern;

public class SingletonTelusko1 {

	public static void main(String[] args) {
//		TestDemo t1 = new Test(); we'll get the error when we create a private constructor
		TestDemo t2 = TestDemo.getInstance();
		TestDemo t3 = TestDemo.getInstance();
	}

}

class TestDemo{
	static TestDemo obj = new TestDemo();// Eager or Early  // there is problem here. when we use static it will create the obj in heap and will 
										  // become global variable even if we are not using it will be there once the class is loaded
	private TestDemo() {
		System.out.println("I'm here");
	}
	
	public static TestDemo getInstance() {
		
		return obj;
	}
	
}
