<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>
<body>
<a href="addstudent">添加</a>
<ul>
<c:forEach var="student" items="${students}">
	<li><a href="student/details/${student.sid}">${student.sname}</a>
	<a href="student/edit/${student.sid}">编辑</a>
	<a href="student/delete?sid=${student.sid}" onclick="return confirm('确定要删除吗')">删除</a>
	<ul>
	<c:forEach var="sc" items="${student.sc}">
		<li>${sc.course.cname} (授课教师：${sc.teacher.tname })
	</c:forEach>
	</ul>
</c:forEach>
</ul>
<p><a href="javascript:history.go(-1);">向上一页</a> 
</body>
</html>