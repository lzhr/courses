<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
<form method="post">
名字:<input type="text" name="sname" value="${student.sname}">
<p><input type="submit" value="修改">
</form>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>