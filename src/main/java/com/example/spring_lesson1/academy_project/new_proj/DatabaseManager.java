package com.example.spring_lesson1.academy_project.new_proj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/task_manager", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO task_manager (title, description, due_date, priority, status) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDueDate());
            statement.setInt(4, task.getPriority());
            statement.setString(5, task.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM task_manager");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String dueDate = resultSet.getString("due_date");
                int priority = resultSet.getInt("priority");
                String status = resultSet.getString("status");
                Task task = new Task(id, title, description, dueDate, priority);
                task.setStatus(status);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void updateTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE task_manager SET title = ?, description = ?, due_date = ?, priority = ?, status = ? WHERE id = ?");
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDueDate());
            statement.setInt(4, task.getPriority());
            statement.setString(5, task.getStatus());
            statement.setInt(6, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM task_manager  WHERE id = ?");
            statement.setInt(1, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
