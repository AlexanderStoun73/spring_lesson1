package com.example.spring_lesson1.hibernate3;

import com.example.spring_lesson1.hibernate3.entity.Address;
import com.example.spring_lesson1.hibernate3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Address address = new Address();
        address.setCity("London");
        address.setStreet("Backer str.");
        address.setZipCode("001100");

        Employee employee = new Employee();
        employee.setFirstName("Charly");
        employee.setLastName("Main");
        employee.setAge(30);
        //employee.setAddress(address);

        session.beginTransaction();
        session.save(address);
        session.save(employee);
        session.getTransaction().commit();

        factory.close();
        session.close();
    }
}
