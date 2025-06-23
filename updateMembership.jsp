<html>
<head><title>Update Membership</title></head>
<body>
<h2>Update Membership</h2>
<form action="MembershipServlet" method="post">
    <input type="hidden" name="action" value="update">
    Membership ID: <input type="number" name="memberId" required><br>
    Action:<br>
    <input type="radio" name="updateType" value="extend" checked> Extend by 6 Months<br>
    <input type="radio" name="updateType" value="cancel"> Cancel Membership<br>
    <input type="submit" value="Update Membership">
</form>
</body>
</html>
