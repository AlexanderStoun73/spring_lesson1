package com.example.spring_lesson1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personN")
public class Person {

    private Pet pet;

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    //@Autowired
    public Person(@Qualifier("dogdog") Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Class Person: set name");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public void callPet() {
        System.out.println("Hello pet");
        pet.say();
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

