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

    <form action="testConversionServiceConverer" method="POST">
        <!-- lastname-email-gender-department.id 例如: GG-gg@atguigu.com-0-105 -->
        Employee: <input type="text" name="employee"/>
        <input type="submit" value="Submit"/>
    </form>
    <br><br>
    <!--  
        1. WHY 使用 form 标签呢 ?
        可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
        2. s注意:
        可以通过 modelAttribute 属性指定绑定的模型属性,
        若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
        如果该属性值也不存在，则会发生错误。
    -->
    <form:form action="emp" method="POST" modelAttribute="employee">
       <c:if test="${employee.id == null}">
        lastName: <form:input path="lastName"/><br>
       </c:if>
       <c:if test="${employee.id != null}">
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT">
        <%-- s对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
            <%-- 
            <form:hidden path="_method" value="PUT"/>
            --%>
       </c:if>
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
        birth: <form:input path="birth"/><br>
        salary: <form:input path="salary"/><br>
        <input type="submit" value="add">
        
    </form:form>
</body>
</html>