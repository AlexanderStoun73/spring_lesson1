package com.example.spring_lesson1.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Employee employee = new Employee("Alex", 500);
        session.beginTransaction();
        session.save(employee);

        session.getTransaction().commit();

        System.out.println("Данные успешно сохранены");

        factory.close();
        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee employee1 = session.get(Employee.class, 2L);
        session.getTransaction().commit();
        System.out.println(employee1);
//// Создание контекста приложения на основе Java-конфигурации
//        ApplicationContext context
//                = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        // Получение и использование бинов и компонентов из контекста
//        EmployeeService employeeService = context.getBean(EmployeeService.class);
//
//        // Create (Создание)
//        Employee emp1 = new Employee("John Doe", 5000);
//        employeeService.createEmployee(emp1);
//
//        // Read (Чтение)
//        Long employeeId = 1L; // Здесь укажите ID существующего сотрудника
//        Employee readEmployee = employeeService.getEmployeeById(employeeId);
//        System.out.println("Read Employee: " + readEmployee);
//
//        // Update (Обновление)
//        readEmployee.setSalary(6000);
//        employeeService.updateEmployee(readEmployee);
//
//        // Read (Повторное чтение для проверки обновления)
//        Employee updatedEmployee = employeeService.getEmployeeById(employeeId);
//        System.out.println("Updated Employee: " + updatedEmployee);
//
//        // Delete (Удаление)
//        employeeService.deleteEmployee(updatedEmployee);
    }
}

