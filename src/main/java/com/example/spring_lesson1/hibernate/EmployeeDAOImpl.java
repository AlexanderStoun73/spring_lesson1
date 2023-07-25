package com.example.spring_lesson1.hibernate;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee getById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
