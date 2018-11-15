<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>登录</title>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<link rel="stylesheet" type="text/css" href="style/normalize.css"/>
<link rel="stylesheet" type="text/css" href="style/demo.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head> 
<body>
<div style="position:absolute;left:5%;font-size:1.3em;">
<s:a href="Adminlogin.jsp">管理员入口</s:a>
</div>
<div style="position:absolute;left:5%;font-size:1.3em;">
</div>
  <s:if test="hasActionMessages()">
        <div class="actionmessage">
            <s:actionmessage />     
            </div></s:if>
            <s:fielderror />
<div class="loginbox">
<h1>用户登录</h1>
<s:form action="loginAction.action"  method="post"  validate="true">
<p style="position:absolute;top:25%;">请输入学号:</p><input type="text" name="sid" class="textfield"  style="position:absolute;top:28%;left:42%;" />
<p style="position:absolute;top:40%;">请输入密&nbsp;码:</p><input type="password" name="spassword" class="textfield" style="position:absolute;top:43%;left:42%;"/>
<s:reset value="重置" class="button" style="position:absolute;left:60%;top:303px;"/>
<s:submit value="登陆" class="button" style="position:absolute;left:40%;top:303px;"/>
</s:form>
<p style="position:absolute;top:80%;right:20%;width:70%;">没有账号？请<s:a href="register.jsp">注册</s:a></p>
    </div>
 
</body>
</html>