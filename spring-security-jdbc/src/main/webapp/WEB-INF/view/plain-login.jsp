<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>
    <h3>Custome Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
   <c:if test="${param.error != null}">
       <i class="failed">Sorry! You entered invalid username/password</i>
   </c:if>
    <p>
        User name: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password">
    </p>
    <input type="submit" value="Login">
</form:form>
</body>
</html>
