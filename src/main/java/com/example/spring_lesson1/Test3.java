package com.example.spring_lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application_context.xml");

        Person person = context.getBean("myPerson", Person.class);
        person.callPet();

        System.out.println(person.getName());
        System.out.println(person.getAge());

//        Person1 person1 = context.getBean("myPerson1", Person1.class);
//
//        System.out.println(person1.getName());
//        System.out.println(person1.getAge());

         context.close();
    }
}
