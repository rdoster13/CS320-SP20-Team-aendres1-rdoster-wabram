<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="edu.ycp.cs320.lab02a_wabram.model.*" %>

<html>

<head>

	<title>Chess Game</title>
	
	<style type="text/css">
		<%@include file="/chessPage.css"%>
	</style>
	
	<script>
		function transferCallToServlet(x,y) {
			document.requestForm.action = "${pageContext.servletContext.contextPath}/chessPage";
			document.requestForm.x1.value = x;
			document.requestForm.y1.value = y;
			document.requestForm.submit();
		}
	</script>

</head>

<body>
	<form action="${pageContext.servletContext.contextPath}/chessPage" method="post">
		<% Game model = (Game)request.getAttribute("model"); %>

		<Header class='chess'>
			Play Chess!
		</Header>
	</form>

	<form name="requestForm" method="post">
		<input type="hidden" name="x1">
		<input type="hidden" name="y1">
		<div class='space'>
		<table class="board">
			<% for (int y = 0; y < 8; y++ ) { %>
			<tr>
				<% for (int x = 0; x < 8; x++) { %>
				<td onclick= "transferCallToServlet(<%=x%> , <%=y%>)" class= "test<%=(x+y)%2%>" >
					<% if (model.getBoard().getPosition(x, y).getPiece() != null) {
						String type = null;
						
						String color = null;
						if (model.getBoard().getPiece(x, y).getColor() == 1) {
							color = "Black";
						} else {
							color = "White";
						}
						switch(model.getBoard().getPiece(x, y).getPieceType()){
							case PAWN:
								type = "Pawn";
								break;
							case ROOK:
								type = "Rook";
								break;
							case KNIGHT:
								type = "Knight";
								break;
							case BISHOP:
								type = "Bishop";
								break;
							case KING:
								type = "King";
								break;
							case QUEEN:
								type = "Queen";
						}
						
						String source = "images/" + color + type + ".png";  %>
						<img src=<%= source %> alt=" images/BlackPawn.png">
					 <% } %>
				 </td> 
				 <% } %>
			</tr> 
			<% } %> 
		</table> 
		</div>
		<c:if test="${! empty errorMessage}">
			<div class="error">${gameLog}</div>
		</c:if>
		
		</form>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	</body> 
</html>