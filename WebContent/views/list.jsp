<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--  
    SpringMVC 处理静态资源:
    1. s为什么会有访问静态资源会404:
    优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
    若将 DispatcherServlet 请求映射配置为 /, 
    则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理, 
    因找不到对应处理器将导致错误。
    2. s解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
-->
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".delete").click(
            function(){
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            }
    );
})
</script>
</head>
<body>
<form action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>
<c:if test="${empty requestScope.employeeList }">
        no employee!
    </c:if>
    <c:if test="${!empty requestScope.employeeList }">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            
            <c:forEach items="${requestScope.employeeList }" var="emp">
                <tr>
                    <td>${emp.id }</td>
                    <td>${emp.lastName }</td>
                    <td>${emp.email }</td>
                    <td>${emp.gender == 0 ? 'Female' : 'Male' }</td>
                    <td>${emp.department.departmentName }</td>
                    <td><a href="">Edit</a></td>
                    <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    
    <br><br>
    
    <a href="emp"> add employee</a>
</body>
</html>