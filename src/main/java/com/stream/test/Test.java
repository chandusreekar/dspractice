package com.stream.test;

interface Animal {
   default void sound() {
	   System.out.println("Home");
} // abstract

    default void sleep() {
        System.out.println("Sleeping...");
    }

    static void info() {
        System.out.println("Animals are living beings.");
    }
}

interface Animals{
	default void sound() {
		System.out.println("Wild");
	}
}

class Demo implements Animal, Animals{

	@Override
	public void sound() {
		
		System.out.println("Hii");
		
	}
	
}

class Cow implements Animal {
    public void sound() {
        System.out.println("Moo");
    }
    
     public void sleep() {
        System.out.println("Sleeping nicely...");
    }
    
    static void info() {
        System.out.println("Animals are living.");
    }
}

public class Test {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.sound();         // Moo
        cow.sleep();         // Sleeping...
//        cow.info();       // Animals are living beings.
        Animal.info();
        
        Demo demo = new Demo();
        demo.sound();
    }
}
