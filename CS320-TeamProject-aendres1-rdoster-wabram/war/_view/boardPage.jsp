<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>

<head>
<title>Board Page</title>

</head>

<body>

	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>

	<form action="${pageContext.servletContext.contextPath}/boardPage"
		method="post">

		<table class="chessboard">
			<tr class="chessboard">
				<td class="chessboard">Rook</td>
				<td class="chessboard">Knight</td>
				<td class="chessboard">Bishop</td>
				<td class="chessboard">King</td>
				<td class="chessboard">Queen</td>
				<td class="chessboard">Bishop</td>
				<td class="chessboard">Knight</td>
				<td class="chessboard">Rook</td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
				<td class="chessboard"></td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
				<td class="chessboard">Pawn</td>
			</tr>
			<tr class="chessboard">
				<td class="chessboard">Rook</td>
				<td class="chessboard">Knight</td>
				<td class="chessboard">Bishop</td>
				<td class="chessboard">King</td>
				<td class="chessboard">Queen</td>
				<td class="chessboard">Bishop</td>
				<td class="chessboard">Knight</td>
				<td class="chessboard">Rook</td>
			</tr>
		</table>
		<input type="Submit" name="submit" value="play">
	</form>
</body>
</html>