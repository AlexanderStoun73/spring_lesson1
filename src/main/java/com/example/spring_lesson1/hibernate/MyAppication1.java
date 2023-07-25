package com.example.spring_lesson1.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MyAppication1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee").getResultList();

        for (Employee employee : employees)
            System.out.println(employee);

        session.getTransaction().commit();

        factory.close();
    }
}
