<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<td> This is the index view </td>
		
		<br/><br/>
		
		<form action = "${pageContext.servletContext.contextPath}/guessingGame">
			<button type ="submit">guessingGame</button>
		</form>
			
		<br></br>
	
		<form action="${pageContext.servletContext.contextPath}/loginPage" method="login">
			<input type="Submit" name="submit" value="Login">
		</form>
		
		<br/><br/>
		
	</body>
	
</html>
