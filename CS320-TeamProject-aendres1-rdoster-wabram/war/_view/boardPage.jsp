<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<style type="text/css">
.error {
	color: red;
}

table.chessboard {
	margin: 80px auto;
	background: #999;
	border: 5px solid #333;
	border-collapse: separate; /* */
}

td.chessboard {
	width: 70px;
	height: 70px;
	border: 1px solid #333; /* */
}

tr.chessboard:nth-child(odd) td.chessboard:nth-child(even), tr.chessboard:nth-child(even) td.chessboard:nth-child(odd)
	{
	background: white;
}
</style>
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