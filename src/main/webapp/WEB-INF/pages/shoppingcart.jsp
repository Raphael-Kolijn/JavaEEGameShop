<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Game store</title>
	</head>
	<body>
		<h1>Game Shoppingcart</h1>
		<div>
			<table>
				<thead>
					<tr>
						<td><h2>You have just ordered:</h2></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Name</td>
						<td>${orderedGame.name}</td>
					</tr>
					<tr>
						<td>Price</td>
						<td>${orderedGame.price}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<td><h2>Total order:</h2></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${currentGameOrder}" var="orderedGame">
						<tr>
							<td>${orderedGame.name}</td>
							<td>${orderedGame.price}</td>
						</tr>
					</c:forEach>
					<tr>
						<td>
							<b>Total price:</b>
						</td>
						<td>
							<b>${totalPrice}</b>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<form method="post" action="${pageContext.request.contextPath}/checkout">
				<input type="hidden" name="payment" value="${totalPrice}">
				<input type="submit" value="Submit complete game order" />
			</form>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/list">Back to games list</a>
		</div>
	</body>
</html>