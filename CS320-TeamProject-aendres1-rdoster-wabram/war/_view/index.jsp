<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<td> This is the index view jsp </td>
		<br/><br/>
		
		<form action="${pageContext.servletContext.contextPath}/loginPage" method="login">
			<input type="Submit" name="submit" value="Login">
		</form>
		
		<br/><br/>
		
		<form action="${pageContext.servletContext.contextPath}/boardPage" method="play">
			<input type="Submit" name="submit" value="Play Chess">
		</form>
		
	</body>
	
</html>
