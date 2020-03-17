<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Login Page</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/loginPage" method="login">
			<table>
				<tr>
					<td class="label">User Name:</td>
					<td><input type="text" name="username" size="12" value="${login.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="12" value="${login.password}" /></td>
				</tr>
				
				<tr>
					<td class="label">Result:</td>
					<td>${login.resultMessage}</td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Login">
		</form>
	</body>
</html>