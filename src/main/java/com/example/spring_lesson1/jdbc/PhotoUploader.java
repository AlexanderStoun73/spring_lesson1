package com.example.spring_lesson1.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhotoUploader {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/hr_system";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public void uploadPhoto(String photoPath, String name, String type) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            File photoFile = new File(photoPath);
            try (FileInputStream fis = new FileInputStream(photoFile)) {
                String sql = "INSERT INTO image_data (imageData, name, type) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setBinaryStream(1, fis, (int) photoFile.length());
                statement.setString(2, name);
                statement.setString(3, type);
                statement.executeUpdate();
                System.out.println("Photo uploaded successfully.");
            } catch (IOException e) {
                System.out.println("Failed to read the photo file: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        PhotoUploader uploader = new PhotoUploader();
        String photoPath = "Hwo.jpg";
        String name = "Photo";
        String type = "jpg";
        uploader.uploadPhoto(photoPath, name, type);
    }
}
