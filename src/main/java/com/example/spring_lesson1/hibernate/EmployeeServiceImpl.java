package com.example.spring_lesson1.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public void createEmployee(Employee employee) {
        employeeDAO.create(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeDAO.getById(id);
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDAO.delete(employee);
    }
}
