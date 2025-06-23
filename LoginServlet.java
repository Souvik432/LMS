package com.lms.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        if ("admin".equals(username) && "admin123".equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("role", "admin");
            response.sendRedirect("dashboard.jsp");
        } else if ("user".equals(username) && "user123".equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("role", "user");
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
