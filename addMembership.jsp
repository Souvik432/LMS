<html>
<head><title>Add Membership</title></head>
<body>
<h2>Add New Membership</h2>
<form action="MembershipServlet" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="name" required><br>
    Email: <input type="email" name="email" required><br>
    Phone: <input type="text" name="phone" required><br>
    Duration:<br>
    <input type="radio" name="duration" value="6months" checked>6 Months<br>
    <input type="radio" name="duration" value="1year">1 Year<br>
    <input type="radio" name="duration" value="2years">2 Years<br>
    <input type="submit" value="Add Membership">
</form>
</body>
</html>
