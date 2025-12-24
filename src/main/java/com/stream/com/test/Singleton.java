package com.stream.com.test;

public class Singleton {

	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
			
		}
		return instance;
	}
	
	public static void main(String[] args) {
	
		Singleton instance1 = instance.getInstance();
		Singleton instance2 = instance.getInstance();
		
		if(instance1 == instance2) {
			System.out.println("Refering to the same Object");
		}
	}

}
