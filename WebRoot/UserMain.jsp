<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*" import="org.apache.struts2.ServletActionContext" import="action.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

</style>
<link rel="stylesheet" type="text/css" href="style/UserStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
 <%
  		Student s=(Student)session.getAttribute("loginstudent");
  		String sname=s.getSname();
  		Double price=s.getPrice();
   %>
<div class="MainBox">
<div class="MainLabelBox">
<h1>教材订购系统</h1>
</div>
<div class="MenuLabel">
<div class="LoginMenu">
<s:if test="#session['loginstudent']==null">
<div>
用户未登录   <div style="position:absolute;left:30%;margin:0px;top:10%;">请 <a href="login.jsp">登陆</a>|<s:a href="getBookList.action">首页</s:a>|<a href="register.jsp">免费注册</a>|<s:a href="ShowCart.action">查看购物车</s:a></div>
</div>
</s:if>
<s:else>
<p style="position:absolute;left:0%;margin:0;">用户已登录</p>
<p style="position:absolute;left:15%;margin:0;"><s:property value="#session['loginstudent'].sname"/>你好!</p>
<div style="position:absolute;left:30%;margin:0px;"><s:a href="index.jsp">首页</s:a>|<s:a href="loginoff.action">退出登录</s:a>|
<s:a href="ShowOrder.action">已订购书籍</s:a>|<s:a href="carts.action">查看订购单</s:a>| 余额<%=price%>元| <a href="recharge.jsp" style="text-decoration:none">充值</a>
 </div>
</s:else>
 </div>
</div>
</div>
</body>
</html>