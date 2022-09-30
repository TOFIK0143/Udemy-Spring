<!DOCTYPE html>
<html>

<head>

	<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

</head>

<body>

<h2>Spring MVC Demo - Home Page</h2>

<a href="hello/showForm">Plain Hello World</a>

<br><br>

<img src="${pageContext.request.contextPath}/resources/img/spring-logo.png" />

<br><br>

<a href="student/showForm">Student Form</a>
<br><br>

<a href="customer/showForm">Customer Form</a>
<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>

</body>

</html>