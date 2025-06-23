package com.lms.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.lms.dao.DBConnection;

public class AddMembershipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String duration = request.getParameter("duration");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO membership (name, email, duration) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, duration);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Membership added for " + name + " (" + duration + ")</h3>");
    }
}
