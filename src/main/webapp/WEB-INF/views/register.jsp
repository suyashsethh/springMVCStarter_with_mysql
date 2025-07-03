<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<form action="register" method="post">
  Name: <input type="text" name="name" required /><br/>
  Email: <input type="email" name="email" required /><br/>
  Password: <input type="password" name="password" required /><br/>
  <input type="submit" value="Register" />
</form>
<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
