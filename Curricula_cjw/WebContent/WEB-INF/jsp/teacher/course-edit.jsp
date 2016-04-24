<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
input
{ vertical-align:middle; }
</style>
<title>编辑课程</title>
</head>
<body>
<form method="post">
<p>课程名:${course.cname }<input  hidden=true type="text" name="cname" value="${course.cname}">
<p>时间<input  type="text" name="c_time" value="${course.c_time}">
<p>学分<input type="text" name="credit" value="${course.credit}">
<p>具体内容<input type="text" name="c_details" value="${course.c_details }">
<p><input type="submit" value="修改">
</form>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>