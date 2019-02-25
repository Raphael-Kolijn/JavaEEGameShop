<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Gamestore</title>
	</head>
	<body>
		<h1>${helloMessage}</h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/list">What kind of games can I buy?</a></li>
		</ul>
	</body>
</html>