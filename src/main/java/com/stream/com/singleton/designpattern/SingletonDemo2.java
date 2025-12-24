package com.stream.com.singleton.designpattern;

public class SingletonDemo2 {

	public static void main(String[] args) {
		Test1 t1 = Test1.INSTANCE;
		t1.i = 10;
		t1.Test1();
		Test1 t2 = Test1.INSTANCE;
		t2.i = 20;
		t2.Test1();
		
		Test3 t3 = Test3.INSTANCE;
		t3.str = "I'm Working with Singleton";
		t3.Test3();
		
	}

}
enum Test1{
	INSTANCE;
	 int i;
	public void Test1() {
		System.out.println(i);
	}
}

enum Test3{
	INSTANCE;
	String str;
	public void Test3(){
		System.out.println(str);
	}
}