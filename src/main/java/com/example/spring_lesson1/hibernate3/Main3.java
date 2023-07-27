package com.example.spring_lesson1.hibernate3;

import com.example.spring_lesson1.hibernate3.entity.Address;
import com.example.spring_lesson1.hibernate3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main3 {
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

        Address address1 = new Address();
        address1.setCity("Paris");
        address1.setStreet("Lui str.");
        address1.setZipCode("11111");

        Employee employee = new Employee();
        employee.setFirstName("Charly");
        employee.setLastName("Main");
        employee.setAge(30);

        Employee employee1 = new Employee();
        employee1.setFirstName("Bob");
        employee1.setLastName("Marly");
        employee1.setAge(50);

        // Set the relationship in both directions
        address.getEmployee().add(employee);
        address.getEmployee().add(employee1);

        employee.getAddresses().add(address);
        employee.getAddresses().add(address1);

        session.beginTransaction();
        session.save(address);
        session.save(address1);
        session.save(employee);
        session.save(employee1);
        session.getTransaction().commit();

        factory.close();
        session.close();
    }
}
