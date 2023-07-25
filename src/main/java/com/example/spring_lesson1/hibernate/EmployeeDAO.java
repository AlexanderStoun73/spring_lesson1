package com.example.spring_lesson1.hibernate;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee getById(Long id);
    void update(Employee employee);
    void delete(Employee employee);
}
