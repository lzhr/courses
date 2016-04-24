<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程</title>
</head>
<body>
<ul>
<c:forEach var="course"  items="${courses }">
 	<li><a href="c${course.cid}">${course.cname}</a>
</c:forEach>
</ul>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>