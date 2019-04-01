<%--
  Created by IntelliJ IDEA.
  User:
  Date: 31-Mar-19
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
   <div id="wrapper">
       <div id="header">
           <h2>CRM - Customer Relationship Manager</h2>
       </div>
   </div>
    <div id="container">
        <div id="content">

            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
            class="add-button"/>
            <!--add out html table here -->

            <table>
                <tr>
                    <th>Firts Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                <!-- loop over and print customers-->
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>