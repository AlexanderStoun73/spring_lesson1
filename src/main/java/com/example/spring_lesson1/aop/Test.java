package com.example.spring_lesson1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConf.class);

        Library library = context.getBean("library", Library.class);
        library.getBook();

        context.close();
    }
}
