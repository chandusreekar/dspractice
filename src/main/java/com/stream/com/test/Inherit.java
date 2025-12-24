package com.stream.com.test;

class A{
	public int a=10;
}
class B extends A{
	private int a=20;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
public class Inherit {

	public static void main(String[] args) {
		B a1= new B();
		System.out.println(a1.getA());

	}

}
