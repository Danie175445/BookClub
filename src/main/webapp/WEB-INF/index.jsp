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
	<h1>Book Club</h1>
	<p>A Place for friends to share thoughts on books.</p>
	<div>
		<h2>Register</h2>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div>
				<form:label path="name">name:</form:label>
				<form:errors path="name" />
				<form:input type="text" path="name"/>
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" />
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" />
				<form:input type="password" path="password"/>
			</div>
			<div>
				<form:label path="confirm">Confirm PW:</form:label>
				<form:errors path="confirm" />
				<form:input type="password" path="confirm"/>
			</div>
			<input type="submit" />
		</form:form>
	</div>
	<div>
		<h2>Login</h2>
		<form:form action="/new/login" method="post" modelAttribute="newLogin">
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" />
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" />
				<form:input type="password" path="password"/>
			</div>
			<input type="submit" />
		</form:form>
	</div>
</body>
</html>