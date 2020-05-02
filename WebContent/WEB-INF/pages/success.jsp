<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
success!
<br>
now is : ${requestScope.time}
<br>
names : ${requestScope.names}
<br>
request user : ${requestScope.user}
<br>
session user : ${sessionScope.user}
</body>
</html>