<html>
<head><title>Dashboard</title></head>
<body>
<h2>Welcome to Library Management System</h2>
<% String role = (String) session.getAttribute("role"); %>
<% if ("admin".equals(role)) { %>
    <a href="maintenance.jsp">Maintenance</a><br>
<% } %>
<a href="reports.jsp">Reports</a><br>
<a href="transactions.jsp">Transactions</a><br>
<a href="logout.jsp">Logout</a>
</body>
</html>
