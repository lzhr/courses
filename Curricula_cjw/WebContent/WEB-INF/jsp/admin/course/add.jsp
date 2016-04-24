<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
</head>
<body>
<form method="post">
<p>课程名<input type="text" name="cname" >
<p>时间<input type="text" name="c_time">
<p>授课教师<input type="text" name="tid">
<p><input type="submit" value="添加">
</form>
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>