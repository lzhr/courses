<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习课程</title>
</head>
<body>
<h2>课程</h2>
<table border="1">
<tr><th>课程号</th><th>课程</th><th>学分</th><th>时间</th><th>内容</th><th>教师</th></tr>
<c:forEach var="ct" items="${sct }">
	<tr><td>${ct.course.cid }</td><td>${ct.course.cname }</td><td>${ct.course.credit}</td>
		<td>${ct.course.c_time}</td><td>${ct.course.c_details}</td>
		<td>${ct.teacher.tname}</td>
		<td><a href="courses/delete?cid=${ct.course.cid }" onclick="return confirm('确定要删除吗')">删除</a></td></tr>
</c:forEach>
</table>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>