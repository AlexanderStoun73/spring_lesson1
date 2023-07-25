package com.example.spring_lesson1.saml;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        startTomcatServer();
    }

    private static void startTomcatServer() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080); // Порт, на котором будет запущен сервер

        // Создание контекста для приложения
        Context context = tomcat.addWebapp("", System.getProperty("java.io.tmpdir"));

        // Добавление сервлетов в контекст
        Tomcat.addServlet(context, "samlResponseServlet", new SAMLResponseHandlerServlet());
        context.addServletMappingDecoded("/saml-response", "samlResponseServlet");

        Tomcat.addServlet(context, "logoutResponseServlet", new LogoutResponseHandlerServlet());
        context.addServletMappingDecoded("/logout-response", "logoutResponseServlet");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}