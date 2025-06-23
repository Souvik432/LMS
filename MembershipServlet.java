package com.lms.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MembershipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_db", "root", "");

            if ("add".equals(action)) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String duration = request.getParameter("duration");

                PreparedStatement pst = conn.prepareStatement("INSERT INTO members (name, email, phone) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, phone);
                pst.executeUpdate();

                ResultSet rs = pst.getGeneratedKeys();
                int memberId = 0;
                if (rs.next()) {
                    memberId = rs.getInt(1);
                }

                int months = duration.equals("1year") ? 12 : (duration.equals("2years") ? 24 : 6);
                LocalDate startDate = LocalDate.now();
                LocalDate endDate = startDate.plusMonths(months);

                pst = conn.prepareStatement("INSERT INTO memberships (member_id, start_date, end_date, status) VALUES (?, ?, ?, ?)");
                pst.setInt(1, memberId);
                pst.setDate(2, Date.valueOf(startDate));
                pst.setDate(3, Date.valueOf(endDate));
                pst.setString(4, "active");
                pst.executeUpdate();

                conn.close();
                response.sendRedirect("dashboard.jsp");
            } else if ("update".equals(action)) {
                int memberId = Integer.parseInt(request.getParameter("memberId"));
                String updateType = request.getParameter("updateType");

                PreparedStatement pst;
                if ("extend".equals(updateType)) {
                    pst = conn.prepareStatement("UPDATE memberships SET end_date = DATE_ADD(end_date, INTERVAL 6 MONTH) WHERE member_id = ?");
                    pst.setInt(1, memberId);
                } else {
                    pst = conn.prepareStatement("UPDATE memberships SET status = 'cancelled' WHERE member_id = ?");
                    pst.setInt(1, memberId);
                }
                pst.executeUpdate();

                conn.close();
                response.sendRedirect("dashboard.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
