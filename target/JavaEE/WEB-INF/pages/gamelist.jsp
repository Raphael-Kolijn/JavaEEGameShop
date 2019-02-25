<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Game store</title>
	</head>
	<body>
		<h1>Games List</h1>
		<ul>
			<c:forEach items="${gamelist}" var="game">
				<li><a href="${pageContext.request.contextPath}/order?gameName=${game}">${game}</a></li>
			</c:forEach>
		</ul>
	</body>
</html>