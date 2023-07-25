package com.example.spring_lesson1.hibernate2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory; // настройка и работа с сессиями (фабрика сессий)

    static {
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder() // получение реестра сервисов
                        .configure().build();
        try {
            // MetadataSources - для работы с метаданными маппинга объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
