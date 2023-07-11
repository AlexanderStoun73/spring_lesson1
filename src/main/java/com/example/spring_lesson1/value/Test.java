package com.example.spring_lesson1.value;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application_context4.xml");

        Person person = context.getBean("personB", Person.class);
        person.callPet();

        System.out.println(person.getName());
        System.out.println(person.getAge());
        context.close();
    }
}
