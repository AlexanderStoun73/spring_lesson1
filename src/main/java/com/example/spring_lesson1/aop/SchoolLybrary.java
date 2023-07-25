package com.example.spring_lesson1.aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLybrary extends AbstarctLybrary{
    @Override
    public void getBook() {
        System.out.println("Берем книгу из школьной библиотеки");
    }
}
