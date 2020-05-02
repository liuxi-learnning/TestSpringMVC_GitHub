<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="testSessionAttribute">testSessionAttribute</a>
<br><br>

<a href="testMap">testMap</a>
<br><br>

<a href="testModelAndView">testModelAndView</a>
<br><br>

<a href="testServletAPI">Test ServletAPI</a>
<br><br>

<form action="testPojo" method="post">
    user name <input type="text" name="username">
    password <input type="password" name="password">
    email <input type="text" name="email">
    age <input type="text" name="age">
    city <input type="text" name="address.city">
    province <input type="text" name="address.province">
    <input type="submit" value="test POJO">
</form>
<br><br>

<a href="testRequestHeader">Test RequestHeader</a>
<br><br>

<a href="testcookieValue">Test cookieValue</a>
<br><br>

<a href="testRequestParam?username=tom">Test RequestParam</a>
<br><br>

<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="test put">
</form>
<br><br>

<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="test delete">
</form>
<br><br>

<form action="testRest" method="post">
    <input type="submit" value="test post2">
</form>
<br><br>

<a href="testRest/1">Test GET</a>
<br><br>

<a href="testVariable/101">Test Variable</a>
<br><br>

<a href="springmvc/testRequestMapping">Test RequestMapping</a>
<br><br>
<a href="testAntPath/123/abc">Test AntPath</a>
<br><br>
<a href="testParams?username=tom&age=11">Test Params</a>
<br><br>
<form action="testMethod" method="post">
<input type="submit" value="test post">
</form>
<br><br>
<a href="hello">hello</a>
</body>
</html>