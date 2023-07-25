package com.example.spring_lesson1.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id // Столбец с Primary Key содержит уникальное значение и не может быть null
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Аннотация @GeneratedValue в JPA (Java Persistence API)
                                                        // используется для указания того, как должно генерироваться
                                                        // значение первичного ключа для сущности, когда она
                                                        // сохраняется в базе данных. Аннотация @GeneratedValue
                                                        // работает в сочетании с аннотацией @Id, которая используется
                                                        // для пометки поля как первичного ключа объекта.
                                                        // Стратегии:
                                                // AUTO: это стратегия по умолчанию. Поставщик постоянства (например, Hibernate)
                                                // выбирает соответствующую стратегию на основе базы данных и реализации JPA.
                                                // Обычно он использует столбец идентификаторов в базе данных или
                                                // последовательность (например, в Oracle) для создания первичного ключа.
                                                // IDENTITY: Поставщик постоянства полагается на столбец идентификаторов
                                                // в базе данных для создания значения первичного ключа.
                                                // Эта стратегия часто используется с базами данных, поддерживающими
                                                // автоматическое увеличение столбцов (например, MySQL, SQL Server).
                                                // SEQUENCE: поставщик сохраняемости использует последовательность
                                                // базы данных для создания значения первичного ключа.
                                                // Эта стратегия часто используется с базами данных, поддерживающими
                                                // последовательности (например, Oracle). Имя последовательности можно
                                                // указать с помощью атрибута генератора аннотации @GeneratedValue.
                                                // К примеру:
                                                    // @Id
                                                    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
                                                    //@SequenceGenerator(name = "employee_seq", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
                                                    //private Long id;
                                                // TABLE: Поставщик постоянства использует отдельную таблицу для создания
                                                // значений первичного ключа. Он создает таблицу с двумя столбцами:
                                                // один для имени объекта, а другой для текущего значения первичного ключа.
                                                // Эта стратегия менее эффективна, чем другие, и используется реже.
    private Long id;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(name = "salary")
    private double salary;

    public Employee() {
    }

    public Employee(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
        //this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String  toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
