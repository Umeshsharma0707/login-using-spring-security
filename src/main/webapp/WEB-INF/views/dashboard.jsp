<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body>
	<h1>Hello, <span style="font-size: 30px;color: red;background: beige;">
		<c:if test="${username !=null }">
			<c:out value="${username }"></c:out>
		</c:if>	</span></h1>
	<h2>this is your private dashboard</h2>
</body>
</html>