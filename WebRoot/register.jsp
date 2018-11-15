<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="style/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>注册</title>
	
</head>
<div style="position:absolute;left:5%;font-size:1.3em;">
<s:a href="login.jsp">用户登陆</s:a>
</div>
	 <s:if test="hasActionMessages()">
        <div class="actionmessage">
            <s:actionmessage />     
            </div></s:if>

<div class="registerBox">
<h1>用户注册</h1>
<s:form action="saveRegister.action" method="post">
<p>请输入学号:</p><input type="text" name="sid" class="registerText" style="position:absolute;top:110px;"/>
<p>请输入密码(6~20长度):</p><input type="password" name="spassword" class="registerText" style="position:absolute;top:160px;"/>
<p>请再次输入密码：</p><input type="password" name="password" class="registerText" style="position:absolute;top:210px;"/>
<p>请输入真实姓名:</p><input type="text" name="sname" class="registerText" style="position:absolute;top:258px;"/>
<p>请输入年级:</p><input type="text" name="grade" class="registerText" style="position:absolute;top:310px;"/>
<s:submit value="注册" class="button" style="position:absolute;top:453px;left:60%;width:20%;"/>
</s:form>
</div>
</html>