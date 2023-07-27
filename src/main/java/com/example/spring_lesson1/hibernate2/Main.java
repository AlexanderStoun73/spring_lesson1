package com.example.spring_lesson1.hibernate2;

import com.example.spring_lesson1.hibernate2.entity.Author;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        for (Author author : new Helper().getAutorList()) {
            System.out.println("author - " + author.getName());
        }
    }
}
