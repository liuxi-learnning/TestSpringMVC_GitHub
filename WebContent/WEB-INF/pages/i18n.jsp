<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
i18n !
<br><br>
<a href="i18n?locale=zh_CN"> 中文</a>
<br><br>
<a href="i18n?locale=en_US"> 英文</a>
<br><br>
<fmt:message key="i18n.username"></fmt:message>
<br><br>
<a href="i18n2"> i18n2 page</a>
</body>
</html>