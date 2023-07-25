package com.example.spring_lesson1.new_academy_proj_jpa.repository;

import com.example.spring_lesson1.new_academy_proj_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
}
