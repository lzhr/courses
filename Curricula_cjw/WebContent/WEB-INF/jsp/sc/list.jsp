<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课表</title>
</head>
<body>
<c:forEach var="sc" items=${sc }>
	${sc.student.sname }
	${sc.course.cname }
</c:forEach>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>