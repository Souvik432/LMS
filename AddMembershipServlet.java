package com.lms.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddMembershipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String duration = request.getParameter("duration");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Membership added for " + name + " (" + duration + ")</h3>");
    }
}
