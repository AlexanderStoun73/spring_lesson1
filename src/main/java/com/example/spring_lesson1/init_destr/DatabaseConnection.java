package com.example.spring_lesson1.init_destr;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class DatabaseConnection {
    private String connectionString;

    public DatabaseConnection(String connectionString) {

        this.connectionString = connectionString;
    }

    @PostConstruct
    public void connect() {
        // Установка соединения с базой данных
        System.out.println("Connecting to database: " + connectionString);
    }

    public void executeQuery(String query) {
        // Выполнение SQL-запроса
        System.out.println("Executing query: " + query);
    }

    @PreDestroy
    public void disconnect() {
        // Закрытие соединения с базой данных
        System.out.println("Disconnecting from database: " + connectionString);
    }
}
