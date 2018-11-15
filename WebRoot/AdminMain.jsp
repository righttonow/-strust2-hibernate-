<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*" import="org.apache.struts2.ServletActionContext" import="action.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%
  		Admin a=(Admin)session.getAttribute("admin");
   %>
<title>管理员</title>
</head>
<body>
<div class="adminBox">
<div class="mainLabel">
<h1 >教材订购系统系统</h1>
</div>
<s:if test="#session['admin']==null">
管理员未登录，请<s:a href="Adminlogin.jsp">登录</s:a>
</s:if>
<s:else>
<div class="adminMenu">
<br>
<strong>管理员已登录</strong><br>

<s:include value="AdminMenu.jsp"></s:include>
</div>
</s:else>
</div>
</body>
</html>