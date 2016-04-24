<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HandlerMapping(éæ)</title>
</head>
<body>
URL --Method---Controller--Function 
<p>AdminController
<p>
<p>[/admin/{aid}]--[]-- --index
<br>
<p>[/admin/{aid}/course]--[]--- --courselist
<p>[/admin/{aid}/course/add || /admin/{aid}/addcourse]--[GET]----- -addCourse
<p>[/admin/{aid}/course/add || /admin/{aid}/addcourse]--[POST]----- addCourse
<p>[/admin/{aid}/course/{cid} || /admin/{aid}/c{cid}]--[GET]---- -editCourse
<p>[/admin/{aid}/course/{cid} || /admin/{aid}/c{cid}]--[POST]---- -doeditCourse
<p>
<p>[/admin/{aid}/student]--[]---- -studentList
<p>[/admin/{aid}/student/add || /admin/{aid}/addstudent]--[GET]--- -addstudent
<p>[/admin/{aid}/student/add || /admin/{aid}/addstudent]--[POST]-- --addStudent
<p>[/admin/{aid}/student/edit/{sid}]--[GET]-----editStudent
<p>[/admin/{aid}/student/edit/{sid}]--[POST]----editstudent
<p>[/admin/{aid}/student/delete]--[]------deletestudent
<p>
<p>[/admin/{aid}/teacher]--[]-----teachers
<p>[/admin/{aid}/teacher/delete]--[]------deleteTeacher
<p>
LoginController
[/login]--[GET]------login
[/login]--[POST]------dologin
[/admin || /teacher || /student || /course]--[GET]------re
<p>
<p>StudentController
<p>[/student/{sid}]--[]-----index
<p>[/student/{sid}/info]--[]--------info
<p>[/student/{sid}/courses]--[]------courses
<p>[/student/{sid}/courses/select]--[POST]-------selectcourse
<p>[/student/{sid}/courses/select]--[GET]--------selectcourse
<p>TeacherController
<p>[/teacher/{tid}]--[]-------index
<p>[/teacher/{tid}/course/c{cid} || /teacher/{tid}/c{cid}]--[]--- editCourse
<p>[/teacher/{tid}/course/c{cid} || /teacher/{tid}/c{cid}]--[POST]---- -doeditCourse
<p>[/teacher/{tid}/course]--[]----- -teach
<p>[/url]--[]------URLC--list
</body>
</html>