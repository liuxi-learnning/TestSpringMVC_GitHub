<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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