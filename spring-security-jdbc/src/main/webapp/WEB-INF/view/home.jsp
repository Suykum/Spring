
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2> Spring Security</h2>
    <hr>
    <p>
        Wellcome!!!
    </p>
    <hr>
    <!-- display username and role -->
    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <hr>
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
            (Only for Managers)
        </p>
    </security:authorize>
    <hr>
    <security:authorize access="hasRole('ADMIN')">
        <!-- only for users who have Admin role-->
        <p>
            <a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
            (Only for Admins)
        </p>
    </security:authorize>
    <hr>
   <form:form action="${pageContext.request.contextPath}/logout" method="post">
       <input type="submit" value="Logout">
   </form:form>
</body>
</html>
