
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName" />
        <br>
        <br>
        Last Name: <form:input path="lastName"/>
        <br>
        <br>
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>
            <!--form:option value="Germany" label="Germany"/-->
            <!--form:option value="India" label="India"/-->
            <!--form:option value="Turkey" label="Turkey"/-->
        </form:select>
        <br>
        <br>
        Favorite Language:
        Java<form:radiobutton path="favoriteLanguage" value="Java"/>
        C#<form:radiobutton path="favoriteLanguage" value="C#"/>
        PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
        Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
        <br>
        <br>
        Operating Systems:
        Linux<form:checkbox path="operatingSystems" value="Linux"/>
        MAC<form:checkbox path="operatingSystems" value="MAC"/>
        MS Windows<form:checkbox path="operatingSystems" value="MS Windows"/>
        <br>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
