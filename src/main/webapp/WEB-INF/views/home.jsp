<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Training</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
    <h1>Welcome to Spring Training</h1>
    <a href="<c:url value="/spittles" />"/>Spittles</a>
    <a href="<c:url value="/spitter/register" />"/>Register</a>
</body>
</html>
