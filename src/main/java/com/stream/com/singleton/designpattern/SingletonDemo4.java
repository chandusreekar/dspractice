package com.stream.com.singleton.designpattern;

public class SingletonDemo4 {
	
	public static SingletonDemo4 obj;
	
	private SingletonDemo4() {
		
	}
	public static SingletonDemo4 getInstance() {
		if(obj == null) {
			synchronized (SingletonDemo4.class) {
				if(obj == null)
					obj = new SingletonDemo4();
			}
		}
		return obj;
	}
	public static void main(String[] args) {
		SingletonDemo4 instance1 = SingletonDemo4.getInstance();
		SingletonDemo4 instance2 = SingletonDemo4.getInstance();
		if(instance1 == instance2)
		System.out.println("refering to the same object");
	}

}
