package com.example.spring_lesson1.hibernate3;

import com.example.spring_lesson1.hibernate3.entity.Address;
import com.example.spring_lesson1.hibernate3.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {
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

        // Set the relationship in both directions
//        address.setEmployee(employee);
//        address1.setEmployee(employee);

        employee.getAddresses().add(address);
        employee.getAddresses().add(address1);

        session.beginTransaction();
        session.save(address); // Save the addresses first (owning side)
        session.save(address1);
        session.save(employee); // Save the employee
        session.getTransaction().commit();

        factory.close();
        session.close();
    }
}
