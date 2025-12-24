package com.stream.test;

class Parent {
    static void show() {
        System.out.println("Parent static method");
    }
    
    
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static method");
    }
}

public class TestStaticMethod {
    public static void main(String[] args) {
        Parent p = new Child();
        Parent.show();  // ❌ Output: Parent static method
    }
}
