package com.example.spring_lesson1.component;

import com.example.spring_lesson1.Pet;
import org.springframework.stereotype.Component;

/*
@Component - это аннотация, которая используется во фреймворке Spring для
обозначения классов, которые должны быть управляемыми контейнером Spring.
Когда класс отмечен аннотацией @Component, Spring автоматически создает
экземпляр этого класса и управляет его жизненным циклом в контексте приложения.

Аннотация @Component является базовой аннотацией для других аннотаций,
таких как @Service, @Repository и @Controller, которые предоставляют
дополнительные семантические значения для классов, специализированных для
определенных слоев или типов компонентов.
 */


@Component    // по умолчанию scope component - singleton
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Myow");
    }
}


/*
Spring обнаружит класс, отмеченный аннотацией @Component, при сканировании
классов приложения и создаст его экземпляр в контексте приложения.
После создания экземпляра Spring может управлять его зависимостями, внедрять
их и осуществлять другие операции внутри контейнера.

Компоненты, отмеченные аннотацией @Component, могут использоваться в
других классах через механизм внедрения зависимостей (dependency injection),
что позволяет эффективно организовывать и управлять зависимостями между
различными компонентами приложения.
 */