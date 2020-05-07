<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(function() {
    $("#testJson").click(
            function(){
                var url = this.href;
                var args = {};
                $.post(url, args, function(data){
                    for(var i=0, i<data.length, i++) {
                        var id= data[i].id;
                        var lastName = data[i].lastName;
                        console.log(id + ", "+ lastName);
                    }
                });
                return false;
            }        
    );
})
</script>
</head>
<body>
<a href="testDefaultHandlerExceptionResolver">testDefaultHandlerExceptionResolver</a>
<br><br>

<a href="testResponseStatusExceptionResolver?i=10">testResponseStatusExceptionResolver</a>
<br><br>

<a href="testExceptionHandlerExceptionResolver?i=10">testExceptionHandlerExceptionResolver</a>
<br><br>

<form action="testFileUpload" method="POST"  enctype="multipart/form-data">
    file<input type="file" name="file"/>
    desc<input type="text" name="desc"/>
    <input type="submit" value="submit"/>
</form>
<br><br>

<a href="testResponseEntity">Test ResponseEntity</a>
<br><br>

<form action="testHttpMessageConverter" method="POST"  enctype="multipart/form-data">
    file<input type="file" name="file"/>
    desc<input type="text" name="desc"/>
    <input type="submit" value="submit"/>
</form>
<br><br>

<a href="testJson" id="testJson">Test Json</a>
<br><br>

<a href="emps">list all employees</a>
<br><br>

</body>
</html>