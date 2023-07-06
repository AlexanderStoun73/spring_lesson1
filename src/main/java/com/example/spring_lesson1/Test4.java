package com.example.spring_lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application_context.xml");

        Person1 person = context.getBean("myPerson1", Person1.class);

        System.out.println(person.getName());
        System.out.println(person.getAge());

        Pet pet = context.getBean("myPet", Pet.class);
        Dog dog = (Dog) pet;

        System.out.println(dog.getName());
        System.out.println(dog.getAge());
    }
}
