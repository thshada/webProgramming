<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
year=<%=request.getParameter("year") %>
month=<%=request.getParameter("month") %>
day=<%=request.getParameter("day") %>

	<p>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}입니다</p>
</body>
</html>
