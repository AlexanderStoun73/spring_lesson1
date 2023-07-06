package com.example.spring_lesson1.academy_project.new_proj;

public class Task {
        private int id;
        private String title;
        private String description;
        private String dueDate;
        private int priority;
        private String status;

        public Task(int id, String title, String description, String dueDate, int priority) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.priority = priority;
            this.status = "Невыполнено";
        }

        // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Задача: " + title +
                    "\nОписание: " + description +
                    "\nДата выполнения: " + dueDate +
                    "\nПриоритет: " + priority +
                    "\nСтатус: " + status;
        }
}
