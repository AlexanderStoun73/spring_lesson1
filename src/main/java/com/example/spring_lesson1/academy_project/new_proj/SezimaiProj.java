package com.example.spring_lesson1.academy_project.new_proj;

import java.util.Scanner;

public class SezimaiProj {
    private TaskManager taskManager;
    private Scanner scanner;

    public SezimaiProj() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SezimaiProj sezimaiProj = new SezimaiProj();
        sezimaiProj.run();
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> taskManager.createTask(scanner);
                case 2 -> taskManager.viewTasks();
                case 3 -> taskManager.editTask(scanner);
                case 4 -> taskManager.deleteTask(scanner);
                case 5 -> taskManager.markTaskAsDone(scanner);
                case 6 -> taskManager.setTaskStatus(scanner);
                case 0 -> exit = true;
                default -> System.out.println("Неверный выбор. Повторите попытку.");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println(" Task Manager ");
        System.out.println("1. Создать задачу");
        System.out.println("2. Просмотреть список задач");
        System.out.println("3. Редактировать задачу");
        System.out.println("4. Удалить задачу");
        System.out.println("5. Отметить задачу как выполненную");
        System.out.println("6. Установить статус задачи");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }
}
