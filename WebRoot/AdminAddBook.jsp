<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教材</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>教材添加</h1>
<s:actionmessage/><br>
<form action="AdminAddBook.action" method="post">
<p class="P" style="position:absolute;top:80px;">书名:</p><s:textfield name="book.bname" class="textfield" style="position:absolute;top:110px;left:330px"/>
<p class="P" style="position:absolute;top:200px;">ISBN:</p><s:textfield name="book.isbn" class="textfield" style="position:absolute;top:220px;left:330px"/>
<p class="P" style="position:absolute;top:320px;">售价:</p><s:textfield name="book.price" class="textfield" style="position:absolute;top:340px;left:330px"/>
<s:submit value="添加" class="button" style="position:absolute;left:50%;top:353px;"/>
</form>
</div>
</body>
</html>