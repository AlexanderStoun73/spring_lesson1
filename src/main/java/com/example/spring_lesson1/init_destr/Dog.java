package com.example.spring_lesson1.init_destr;

public class Dog implements Pet{
    public Dog() {
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Gav");
    }

    public void eliza() {

        System.out.println("Class Dog: init method");
    }
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
