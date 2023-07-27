package com.example.spring_lesson1.hibernate3.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

//    @OneToOne
//    private Address address;  // ссылка на объект адрес
    //@OneToMany(mappedBy = "employee")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_address",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();

    /*
    Когда вы используете @OneToMany без указания @JoinColumn, Hibernate создает
    промежуточную (объединяющую) таблицу для управления ассоциацией. Эта промежуточная таблица
    (employees_addresses) содержит внешние ключи для связи объектов Employee и Address.

    Если вы не указываете конкретный столбец соединения, Hibernate предполагает, что вы хотите
    использовать таблицу соединений для представления отношения «один ко многим».
    В результате столбец адресов в таблице «Сотрудники» не создается.

    Если вы хотите поддерживать отношение «один ко многим» без отдельной таблицы соединения и вместо
    этого иметь внешний ключ в таблице Address для ссылки на связанного сотрудника,
    вам необходимо изменить сопоставление.
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
