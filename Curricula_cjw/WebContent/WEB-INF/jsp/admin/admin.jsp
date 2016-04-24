<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理</title>
</head>
<body>
<h3> 教务管理 </h3>
<ul>
<li><a href="${aid}/student">学生 </a>
<li><a href="${aid}/teacher">教师 </a>
<li><a href="${aid}/course">课程</a>
</ul>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>