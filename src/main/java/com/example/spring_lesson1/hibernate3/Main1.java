package com.example.spring_lesson1.hibernate3;

import com.example.spring_lesson1.hibernate3.entity.Address;
import com.example.spring_lesson1.hibernate3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main1 {
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

        // Save the addresses before associating them with the employee
        session.beginTransaction();
        session.save(address);
        session.save(address1);
        session.getTransaction().commit();

//        employee.getAddresses().add(address);
//        employee.getAddresses().add(address1);

        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();

        factory.close();
        session.close();
    }
}
