package com.example.spring_lesson1.configuration;

import org.springframework.stereotype.Component;

//@Component("catN")
public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Myow");
    }
}
