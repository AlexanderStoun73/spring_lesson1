package com.example.spring_lesson1.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {
    //@Override
    public void getBook(Book book) {
        System.out.println("Берем книгу " + book.getName());
    }
    public void returnBook() {
        System.out.println("Возвращаем книгу");
    }
    public void getMagazine() {
        System.out.println("Берем журнал");
    }
}
