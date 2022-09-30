<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Tofik Home Page</title>
</head>

<body>
	<h2>Tofik's Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the Tofik's company home page!!!
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
				method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>

</html>