package com.example.spring_lesson1.hibernate;

import javax.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", length = 100, nullable = false)
    private double amount;
}
