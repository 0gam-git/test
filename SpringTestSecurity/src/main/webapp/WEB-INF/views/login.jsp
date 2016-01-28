<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<form action="checkUser" method="POST">
		<input type="text" name="id" id="id" /> 
		<input type="password" name="password" id="password" /> 

		<input type="submit" name="submitButton" id="submitButton" />
	</form>


</body>
</html>
