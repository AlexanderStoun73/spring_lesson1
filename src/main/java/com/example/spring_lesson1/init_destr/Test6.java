package com.example.spring_lesson1.init_destr;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application_context3.xml");

        Dog dog = context.getBean("myPet", Dog.class);
        dog.say();

        context.close();
    }
}

/*
Методы init и destroy

У данных методов access modifier может быть любым

Return type может быть любым. Но из-за того, что возвращаемое значение никак не используется,
чаще всего Return type - void

Называться эти методы могут как угодно

В данных методах не должно быть параметров

Определение методов init и destroy в Spring-бинах дает вам контроль над их жизненным циклом
и позволяет выполнять дополнительные операции до и после использования бина. Они особенно
полезны, когда вам нужно настроить или освободить ресурсы, которые не управляются самим Spring,
такие как соединения с базой данных, сетевые ресурсы и т.д.

Важно отметить, что в более современных версиях Spring (начиная с версии 5.1)
рекомендуется использовать аннотации @PostConstruct и @PreDestroy вместо явного
определения методов init и destroy. Аннотация @PostConstruct указывает метод, который
должен быть выполнен после завершения внедрения зависимостей, а `@PreDestroy


Если у бина scope = prototype, то:
- init метод будет вызываться для каждого новосозданного бина
- для этого бина destroy метод вызываться не будет
- нужно самостоятельно писать код для закрытия/освобождения ресурсов, которые были использованы в бине
 */
