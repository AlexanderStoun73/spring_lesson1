package com.example.spring_lesson1.new_academy_proj_jpa.service;

import com.example.spring_lesson1.new_academy_proj_jpa.entity.Student;
import com.example.spring_lesson1.new_academy_proj_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleUI implements CommandLineRunner {
    private final StudentService studentService;

    @Autowired
    public ConsoleUI(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Получить всех студентов");
            System.out.println("3. Удалить студента");
            System.out.println("4. Изменить студента");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    getAllStudents();
                    break;
                case 3:
                    removeStudent(scanner);
                    break;
                case 4:
                    updateStudent(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }

    private void addStudent(Scanner scanner) {
        System.out.println("Введите имя студента:");
        String name = scanner.nextLine();

        System.out.println("Введите курс студента:");
        String course = scanner.nextLine();

        studentService.addStudent(name, course);

        System.out.println("Студент успешно добавлен");
        System.out.println();
    }

    private void getAllStudents() {
        System.out.println(studentService.getAllStudents());
    }

    private void removeStudent(Scanner scanner) {
        System.out.println("Введите ID студента для удаления:");
        Long studentId = scanner.nextLong();
        scanner.nextLine(); // Очистка буфера

        studentService.deleteStudent(studentId);

        System.out.println("Студент успешно удален");
        System.out.println();
    }

    private void updateStudent(Scanner scanner) {
        System.out.println("Введите ID студента для изменения:");
        Long studentId = scanner.nextLong();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Введите новое имя студента:");
        String name = scanner.nextLine();

        System.out.println("Введите новый курс студента:");
        String course = scanner.nextLine();

        Student student = new Student();
        student.setName(name);
        student.setCourse(course);

        studentService.updateStudent(studentId, student.getName(), course);

        System.out.println("Студент успешно изменен");
        System.out.println();
    }
}
