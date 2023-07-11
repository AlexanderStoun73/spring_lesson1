package com.example.spring_lesson1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.spring_lesson1.aop")
@EnableAspectJAutoProxy  // Аннотация @EnableAspectJAutoProxy является одной из аннотаций, предоставляемых Spring Framework,
                         // и используется для включения автоматической прокси-поддержки для аспектов, определенных с использованием AspectJ.
                         //Когда вы добавляете аннотацию @EnableAspectJAutoProxy к конфигурационному классу в Spring,
                         //  это указывает фреймворку создать и применить прокси-объекты для бинов, на которые
                         //  применены аспекты. Прокси-объекты обеспечивают внедрение аспектов и включение функциональности, определенной в аспектах, в основной код приложения.
public class MyConf {
}
