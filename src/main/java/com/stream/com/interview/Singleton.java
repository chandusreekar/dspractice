package com.stream.com.interview;

public class Singleton {
	
	private static Singleton singletonInstance;
	
	private Singleton() {
		if(singletonInstance != null) {
			throw new RuntimeException("It's a Singleton class");
		}
		System.out.println("It's a Singleton class");
	}
	public static Singleton getInstance() {
		if(singletonInstance == null) {
			synchronized (Singleton.class) {
				if(singletonInstance == null) {
					singletonInstance = new Singleton();		
				}
			}
			
		}
		return singletonInstance;
	}
	
	public Object cloneNotSupport() throws CloneNotSupportedException{
		return new CloneNotSupportedException();
		
	}

	public static void main(String[] args) {
		
		Singleton obj1 = singletonInstance.getInstance();
		Singleton obj2 = singletonInstance.getInstance();
		if(obj1.equals(obj2)) {
			System.out.println("Same Instance");
		}
		
		

	}

}
