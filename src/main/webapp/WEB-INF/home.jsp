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
		<h1>welcome ,<c:out value="${user.name }"/></h1>
		<p>Books from everyone's shelves</p>
	</div>
	<div>
	<a href="/logout">Log Out</a>
	<a href="new/book">+ Add to my shelf</a>
	<p><c:out value="${user.id}" /></p>
	</div>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted By</th>
		</tr>
		<c:forEach var="book" items="${books }">
			<tr>
				<td><c:out value="${book.id }" /></td>
				<td><a href="/book/${book.id}"><c:out value="${book.title }" /></a></td>
				<td><c:out value="${book.author }" /></td>
				<td><c:out value="${book.user.name }" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>