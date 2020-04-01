<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
			<tr>
					<td class="label">Make Move:</td>
					<td><input type="text" name="first" size="12" value="${moves}" /></td>
				</tr>
		</table>
		
			</form>		
		<br>
	</body>
</html>