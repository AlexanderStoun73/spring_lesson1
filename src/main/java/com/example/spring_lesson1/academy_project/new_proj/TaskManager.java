package com.example.spring_lesson1.academy_project.new_proj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    //private List<Task> tasks;
    private Scanner scanner;
    private DatabaseManager manager;

    public TaskManager() {
        //tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
        manager = new DatabaseManager();
    }

    void createTask(Scanner scanner) {
        System.out.print("Введите номер задачи: ");
        int id = scanner.nextInt();
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.print("Введите дату выполнения задачи: ");
        String dueDate = scanner.nextLine();
        System.out.print("Введите приоритет задачи (1 - Низкий, 2 - Средний, 3 - Высокий): ");
        int priority = scanner.nextInt();
        this.scanner.nextLine(); // Чтение символа новой строки после ввода числа
        Task task = new Task(id, title, description, dueDate, priority);
        manager.createTask(task);
        System.out.println("Задача успешно создана.");
    }

    void viewTasks() {
        List<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Индекс: " + i);
                System.out.println(tasks.get(i));
            }
        }
    }

    void editTask(Scanner scanner) {
        List<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего редактировать.");
            return;
        }
        System.out.print("Введите индекс задачи для редактирования: ");
        int index = scanner.nextInt();
        this.scanner.nextLine(); // Чтение символа новой строки после ввода числа
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }
        Task task = tasks.get(index);
        System.out.print("Введите новое название задачи: ");
        String newTitle = scanner.nextLine();
        System.out.print("Введите новое описание задачи: ");
        String newDescription = scanner.nextLine();
        System.out.print("Введите новую дату выполнения задачи: ");
        String newDueDate = scanner.nextLine();
        System.out.print("Введите новый приоритет задачи (1 - Низкий, 2 - Средний, 3 - Высокий): ");
        int newPriority = scanner.nextInt();
        this.scanner.nextLine(); // Чтение символа новой строки после ввода числа
        task.setTitle(newTitle);
        task.setDescription(newDescription);
        task.setDueDate(newDueDate);
        task.setPriority(newPriority);
        System.out.println("Задача успешно отредактирована.");
    }

    void deleteTask(Scanner scanner) {
        List<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего удалять.");
            return;
        }
        System.out.print("Введите индекс задачи для удаления: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Чтение символа новой строки после ввода числа
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }
        tasks.remove(index);
        System.out.println("Задача успешно удалена.");
    }

    void markTaskAsDone(Scanner scanner) {
        List<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего отмечать как выполненное.");
            return;
        }
        System.out.print("Введите индекс задачи для отметки как выполненной: ");
        int index = scanner.nextInt();
        this.scanner.nextLine(); // Чтение символа новой строки после ввода числа
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }
        Task task = tasks.get(index);
        task.setStatus("Выполнено");
        System.out.println("Задача успешно отмечена как выполненная.");
    }

    void setTaskStatus(Scanner scanner) {
        List<Task> tasks = manager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст. Нечего редактировать.");
            return;
        }
        System.out.print("Введите индекс задачи для изменения статуса: ");
        int index = scanner.nextInt();
        this.scanner.nextLine(); // Чтение символа новой строки после ввода числа
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Неверный индекс задачи.");
            return;
        }
        Task task = tasks.get(index);
        System.out.print("Введите новый статус задачи: ");
        String newStatus = scanner.nextLine();
        task.setStatus(newStatus);
        System.out.println("Статус задачи успешно изменен.");
    }
}
