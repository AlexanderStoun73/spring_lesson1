package com.example.spring_lesson1.hibernate2;

import com.example.spring_lesson1.hibernate2.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Helper {
    private SessionFactory sessionFactory;

    public Helper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAutorList() {
        Session session = sessionFactory.openSession();
        session.get(Author.class, 1L);

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class); // первостепенный, корневой entity (в sql запросе - from)
        criteriaQuery.select(root); // не обязательный опреатор, если нужно все значения

        // Выполнение запроса
        Query query = session.createQuery(criteriaQuery);
        List<Author> authorList = query.getResultList();
        session.close();

        return authorList;
    }
}
