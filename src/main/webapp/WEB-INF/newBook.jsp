<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Add a book to your shelf</h1>
		<a href="/home">back to the shelves</a>
	</div>
	<form:form action="/new/book" method="post" modelAttribute="newBook">
		<form:input type="hidden" path="user"  value="${user.id }"/>
		<div>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input type="text" path="title"/>
		</div>
		<div>
			<form:label path="author">Author</form:label>
			<form:errors path="author" />
			<form:input type="text" path="author"/>
		</div>
		<div>
			<form:label path="thoughts">My Thoughts</form:label><br />
			<form:errors path="thoughts" />
			<form:textarea rows="5" cols="17" path="thoughts"></form:textarea>
		</div>
		<input type="submit" />
	</form:form>
</body>
</html>