package com.example.spring_lesson1.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {
    public void getBook() {
        System.out.println("Берем книгу");
    }
}
