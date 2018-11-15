<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
</head>
<body>
<div style="position:absolute;left:5%;font-size:1.3em;">
<s:a href="login.jsp">用户登陆</s:a>
</div>
<s:actionmessage />
<div class="loginbox">
<h1>管理员登陆</h1>

<s:form action="adminloginAction.action" method="post" >
<p style="position:absolute;top:25%;">管理员姓名:</p><s:textfield name="name" class="textfield" value="" style="position:absolute;top:32%;left:42%;" />
<p style="position:absolute;top:40%;">管理员密码:</p><s:password name="password" class="textfield" style="position:absolute;top:46%;left:42%;" />
<s:submit value="进入" class="button" style="position:absolute;left:60%;top:65%;"/>
</s:form>
</div>
</body>
</html>