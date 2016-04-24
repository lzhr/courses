<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<form method="post">
<p>用户ID<input type="text" name="id">
<p style="display:none;">用户名<input type="text" name="name">
<p>密    码<input type="password" name="pw">
<p><input type="radio" name="usertype" value="student" id="1"><label for="1">学生</label>
<input type="radio" name="usertype" value="teacher" id="2"><label for="2">教师</label>
<input type="radio" name="usertype" value="admin" id="3"><label for="3">管理员</label>
<p><input type="submit" value="登录"><input type="reset"> 
</form>
<p>学生ID：1001~
<p>教师ID：3001~
<p>管理员ID：1~10
<p>没有密码

<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
</html>