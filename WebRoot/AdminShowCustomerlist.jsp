<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<s:actionerror />
<div class="AdminDoBox">
<h1>用户资料</h1>
<s:actionmessage/><br>
<table border=1 class="OrderTable">
<tr>
<th>学号</th><th>姓名</th><th>年级</th><th>密码</th><th>余额</th>
</tr>
<s:iterator value="#session.allstudent" var="student">
<tr>
<td><s:property value="#student.sid"/></td>
<td><s:property value="#student.sname"/></td>
<td><s:property value="#student.grade"/></td>
<td><s:property value="#student.spassword"/></td>
<td><s:property value="#student.price"/></td>
</tr>
</s:iterator>
</table>
</div>
</body>
</html>