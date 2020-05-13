<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login Page</title>
		<style type="text/css">
			<%@include file="/loginPage.css"%>
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/loginPage" method="post">
			<table>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="12" value="${password}" /></td>
				</tr>
			</table>
			<input class = 'button' type="Submit" name="submit" value="Login">
		</form>
	</body>
</html>