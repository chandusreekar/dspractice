package com.stream.com.singleton.designpattern;

public class SingletonDEmo3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Abc obj = Abc.getInstance();
				
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Abc obj = Abc.getInstance();
				
			}
		});
		t2.start();
	}

}
class Abc{
	public static Abc obj;
	private Abc() {
		System.out.println("I'm Testing Abc");
	}
	public static Abc getInstance() {
		if(obj == null) {
			synchronized (Abc.class) {
				if(obj == null) {
					obj = new Abc();
				}
			}	
		}
		return obj;
	}
}