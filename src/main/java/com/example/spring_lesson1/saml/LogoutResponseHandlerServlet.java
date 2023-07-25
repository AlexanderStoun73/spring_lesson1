package com.example.spring_lesson1.saml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout-response")
public class LogoutResponseHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<!doctype html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>SAML Response Handler</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Successfully consumed the Logout Response</h2>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
