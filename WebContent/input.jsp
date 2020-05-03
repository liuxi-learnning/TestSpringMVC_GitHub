<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form:form action="emp" method="POST" modelAttribute="employee">
        lastName: <form:input path="lastName"/><br>
        email: <form:input path="email"/><br>
        <%
        Map<String, String> genders = new HashMap();
        genders.put("1", "Male");
        genders.put("0", "Female");
        request.setAttribute("genders", genders);
        %>
        gender: <form:radiobuttons path="gender" items="${genders}"/><br>
        department: <form:select path="department.id"
            items="${departmentList}" itemLabel="departmentName" itemValue="id">
        </form:select><br>
        <input type="submit" value="add">
        
    </form:form>
</body>
</html>