<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
success!
<br><br>
<fmt:message key="i18n.username"></fmt:message>
<br><br>
<fmt:message key="i18n.password"></fmt:message>
<br><br>
now is : ${requestScope.time}
<br>
names : ${requestScope.names}
<br>
request user : ${requestScope.user}
<br>
session user : ${sessionScope.user}
<br>
request testString : ${requestScope.testString}
<br>
session testString : ${sessionScope.testString}
<br>
request testLocalDateTime : ${requestScope.testLocalDateTime}
<br>
session testLocalDateTime : ${sessionScope.testLocalDateTime}
</body>
</html>