package com.example.spring_lesson1.new_academy_proj_jpa.service;

import com.example.spring_lesson1.new_academy_proj_jpa.entity.Student;
import com.example.spring_lesson1.new_academy_proj_jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(String name, String course) {
        Student student = new Student();
        student.setName(name);
        student.setCourse(course);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Optional<Student> students = studentRepository.findById(id);
        if (students.isPresent()) {
            Student student = students.get();
            studentRepository.delete(student);
        }
    }

    public void updateStudent(Long id, String name, String course) {
        Optional<Student> students = studentRepository.findById(id);
        if (students.isPresent()) {
            Student student = students.get();
            student.setName(name);
            student.setCourse(course);
            studentRepository.save(student);
        }
    }

    public String getAllStudents() {
        List<Student> students = studentRepository.findAll();
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.getId()).append(" - ")
                    .append(student.getName())
                    .append(" - Course ")
                    .append(student.getCourse()).append("\n");
        }
        return result.toString();
    }

    // Другие методы для работы со студентами

    // ...
}

