<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		This is the index view jsp</td>
		<br/> <br/>
		<form action="${pageContext.servletContext.contextPath}/addNumbers" method="post">
			<input type="Submit" name="submit" value="Add Numbers!">
		</form>
		
		<br/><br/>
		
		<form action="${pageContext.servletContext.contextPath}/multiplyNumbers" method="post">
			<input type="Submit" name="submit" value="Multiply Numbers!">
		</form>
		
		<br/><br/>
		
		<form action="${pageContext.servletContext.contextPath}/guessingGame" method="Start game">
			<input type="Submit" name="submit" value="Guessing Game!">
		</form>
		
		<br/><br/>
		
		<form action="${pageContext.servletContext.contextPath}/loginPage" method="login">
			<input type="Submit" name="submit" value="Login">
		</form>
		
		<br/><br/>
		
		<form action="${pageContext.servletContext.contextPath}/boardPage" method="Play Chess">
			<input type="Submit" name="submit" value="Play Chess">
		</form>
	</body>
	
</html>
