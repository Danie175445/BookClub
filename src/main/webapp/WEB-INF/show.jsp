<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1><c:out value="${book.title }" /></h1>
		<a href="/home">Back to shelves</a>
	</div>
	<div>
		<h3><c:out value="${book.user.name }"/> read <c:out value="${book.title }"/> by <c:out value="${book.author }"/></h3>
		<p>Here are <c:out value="${book.user.name }"/>'s thoughts: </p>
	</div>
	<p><c:out value="${book.thoughts }"/></p>
</body>
</html>