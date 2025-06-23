Library Management System Setup Guide

1. Prerequisites:
   - JDK 11+ installed
   - Apache Tomcat configured in VS Code
   - MySQL Server running

2. Database Setup:
   - Import schema.sql into MySQL to create database and tables.
   - Create an admin user:
     INSERT INTO users (username, password, role) VALUES ('admin', 'admin123', 'admin');

3. VS Code Setup:
   - Open the project folder in VS Code.
   - Add Tomcat server via extension.
   - Deploy WebContent folder to Tomcat.
   - Ensure servlet mapping is correct in web.xml.

4. Run:
   - Start Tomcat.
   - Go to http://localhost:8080/LibraryManagementSystem

5. Login:
   - Admin: admin / admin123
   - User: (Create via DB or UI)

6. Features:
   - Login, Membership Management, Reports, Transactions
   - Admin-only Maintenance Module
   - Sessions, Validations, Radio/Checkbox logic as required.
