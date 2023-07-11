package com.example.spring_lesson1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
//@ComponentScan("com.example.spring_lesson1.configuration")
public class MyConfig {

    @Bean
    public Pet catsBean() {
        return new Cat();
    }

    @Bean
    public Person personsBean() {
        return new Person(catsBean());
    }
}
