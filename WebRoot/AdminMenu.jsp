<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教材管理</title>
</head>
<body>
<h1>管理员菜单</h1>
<h3>教材管理</h3>
<ul>
 <li><s:a href="AdminAddBook.jsp">添加教材</s:a></li>
  <li><s:a href="AdminUpdateBook.jsp">修改教材</s:a></li>
 <li><s:a href="getAllBook.action">教材单</s:a></li>
</ul>
<h3>学生管理</h3>
<ul>
<li><s:a href="getAllStudent.action">学生单</s:a></li>
</ul>
<h3>订单管理</h3>

</body>
</html>
