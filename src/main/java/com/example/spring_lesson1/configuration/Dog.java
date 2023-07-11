package com.example.spring_lesson1.configuration;

import org.springframework.stereotype.Component;

//@Component("dogdog")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Gav");
    }

    public void init() {

        System.out.println("Class Dog: init method");
    }
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
