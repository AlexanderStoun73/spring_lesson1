package com.example.spring_lesson1.value;

//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("dogBean")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }
    @Override
    public void say() {
        System.out.println("Gav");
    }

    //@PostConstruct
    public void init() {

        System.out.println("Class Dog: init method");
    }
    //@PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
