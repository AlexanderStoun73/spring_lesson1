package com.example.spring_lesson1.hibernate;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
