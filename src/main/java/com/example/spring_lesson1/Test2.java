package com.example.spring_lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application_context.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

//        Pet pet1 = context.getBean("myPet1", Pet.class);
//        pet1.say();

        context.close();
    }
}
