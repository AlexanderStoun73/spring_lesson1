package com.example.spring_lesson1.new_academy_proj_jpa;

import com.example.spring_lesson1.new_academy_proj_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        SwingUtilities.invokeLater(() -> {
            StudentService studentService = context.getBean(StudentService.class);
            StudentForm studentForm = new StudentForm(studentService);
            studentForm.setVisible(true);
        });
    }
}

class StudentForm extends JFrame {

    private final JTextField nameTextField;
    private final JTextField courseTextField;
    private final JTextArea outputTextArea;
    private final StudentService studentService;



    public StudentForm(StudentService studentService) {
        this.studentService = studentService;

        setTitle("Student Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Инициализируем элементы формы
        JLabel nameLabel = new JLabel("Name:");
        JLabel courseLabel = new JLabel("Course:");
        nameTextField = new JTextField(20);
        courseTextField = new JTextField(5);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);

        // Создаем панели
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        // Добавляем элементы на панели
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(courseLabel);
        inputPanel.add(courseTextField);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        // Добавляем панели на форму
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Инициализируем StudentService
        //studentService = new StudentService();

        // Добавляем обработчики событий на кнопки
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String course = courseTextField.getText();
                if (!name.isEmpty() && !course.isEmpty()) {
                    studentService.addStudent(name, course);
                    updateOutputTextArea();
                    nameTextField.setText("");
                    courseTextField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                if (!name.isEmpty()) {
         //           studentService.deleteStudent(name);
                    updateOutputTextArea();
                    nameTextField.setText("");
                    courseTextField.setText("");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String course = courseTextField.getText();
                if (!name.isEmpty() && !course.isEmpty()) {
                  //  studentService.updateStudent(name, course);
                    updateOutputTextArea();
                    nameTextField.setText("");
                    courseTextField.setText("");
                }
            }
        });

        updateOutputTextArea();
    }

    private void updateOutputTextArea() {
        outputTextArea.setText(studentService.getAllStudents());
    }
}
