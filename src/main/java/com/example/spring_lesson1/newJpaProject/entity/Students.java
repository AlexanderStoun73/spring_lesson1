package com.example.spring_lesson1.newJpaProject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private List<Courses> courses;
}
