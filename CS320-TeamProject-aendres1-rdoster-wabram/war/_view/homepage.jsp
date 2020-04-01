<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Home Page</title>
		<style type="text/css">
			.error {
				color: red;
				font-weight: bold;				
			}
			
			tr.button {
				padding-left: 20px;
				margin: 20 px;
			}
		</style>
	</head>

	<body>
		<br>
			<form action="${pageContext.servletContext.contextPath}/homepage" method="post">
				<table>
					<tr>
						<td class="label">Home Page</td>
					</tr>
				</table>
			</form>		
		<br>
	</body>
</html>