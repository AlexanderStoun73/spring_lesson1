package com.example.spring_lesson1.value;

/*
Аннотация @Value - это аннотация, которая используется в Java-фреймворке Spring для инъекции значений свойств
в бины (компоненты). Эта аннотация может быть применена к полям класса, геттерам и сеттерам, а также к параметрам конструктора.

Применение аннотации @Value в Spring предоставляет следующие возможности:

Инъекция значения простых типов: Вы можете использовать аннотацию @Value, чтобы внедрить значения простых типов,
таких как строки, числа и булевы значения, в свойства класса. Например, вы можете указать значение для поля или
параметра конструктора, используя аннотацию @Value("${property.key}"),
где "property.key" - это ключ свойства, которое нужно инъектировать.

Инъекция значений из файла свойств: Аннотация @Value также может использоваться для чтения значений из файла свойств.
Вы можете указать путь к файлу свойств и ключи свойств, которые нужно инъектировать.
Spring загрузит значения из указанного файла свойств и внедрит их в соответствующие свойства класса.

Инъекция значений из выражений SpEL: С помощью аннотации @Value вы можете инъектировать значения,
вычисленные с помощью выражений SpEL (Spring Expression Language).
SpEL позволяет использовать более сложные выражения для определения значений свойств на основе других свойств или бинов.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("personB")
public class Person {
    @Autowired
    @Qualifier("dogBean")
    private Pet pet;

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

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
