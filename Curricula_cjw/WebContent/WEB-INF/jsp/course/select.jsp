<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>选课</title>
</head>
<body>
<ul>
	<c:forEach var="course" items="${selectedcourses }">
		<li>${course.cid}.${course.cname}
	</c:forEach>
</ul>
 
<form method="post">
 <table><tr><th> </th><th>课程</th><th>教师(同一门课只选择一个任课教师,用jquery控制按钮组)</th><th>学分</th><th>时间</th><th>内容</th>
  <th  rowspan="10"><input type="submit" value="确定选择" onclick="return confirm('确定吗')"></th> </tr>
	<c:forEach var="c" items="${unselectedcourses}">
		 <tr><td><input type="checkbox" name="cid" value="${c.cid}"/></td>
			 <td>${c.cname}</td>
			 <td><c:forEach var="ct" items="${c.ct }">
				<input type="checkbox" class="check${c.cid }" name="tid"  
					value="${ct.teacher.tid}">${ct.teacher.tname} 
<%-- 				<input type="radio"  name="tid"  value="${ct.teacher.tid}">${ct.teacher.tname}  --%>
				</c:forEach></td><td>${c.credit}</td>
			<td>${c.c_time}</td><td>${c.c_details}</td>
		</tr> 
	</c:forEach>
	 
</table>
	
</form>
 
<p><a href="javascript:history.go(-1);">向上一页</a>
</body>
<script src="http://code.jquery.com/jquery-latest.js" type="text/javascript" charset="utf-8"></script>
<script src=" <%=request.getContextPath()%>/resources/jquery-latest.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(":checkbox").click(function() {
            var classname = $(this).attr('class');
            $("." + classname).prop("checked", false);
            $(this).prop("checked", true);
        });
    </script>
</html>