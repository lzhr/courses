<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
<h2>学生信息</h2>
<p>${student.sname }
<ul>
<li><a href="courses">已选课程</a>
<li><a href="courses/select">选择课程</a>
</ul>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>