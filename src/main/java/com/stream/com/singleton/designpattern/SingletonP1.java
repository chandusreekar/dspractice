package com.stream.com.singleton.designpattern;

public class SingletonP1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				A1 a1 = A1.getInstance();
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				A1 a2 = A1.getInstance();
				
			}
		});
		t1.start();
//		t1.sleep(5);
		t2.start();
		
	}

}

class A1{
	static A1 obj;
	private A1() {
		System.out.println("Returing Obj");
	}
	public static A1 getInstance() {
		if(obj == null) {
			synchronized(A1.class) {
				if(obj == null) {
					obj = new A1();
			}
			}
		}
		return obj;
	}
}