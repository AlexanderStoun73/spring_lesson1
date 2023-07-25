package com.example.spring_lesson1.hibernate2;

import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
    }
}
