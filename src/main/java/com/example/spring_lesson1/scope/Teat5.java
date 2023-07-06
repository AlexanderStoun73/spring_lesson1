package com.example.spring_lesson1.scope;

import com.example.spring_lesson1.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Teat5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application_context2.xml");

        Dog dog = context.getBean("myPet", Dog.class);
        Dog myDog = context.getBean("myPet", Dog.class);

        System.out.println(dog == myDog);
        System.out.println(dog);
        System.out.println(myDog);

        context.close();
    }
}
