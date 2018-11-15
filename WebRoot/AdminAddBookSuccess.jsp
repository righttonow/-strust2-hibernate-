<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
p{
color:black;
font-size:2em;
font-weight:600;
position:absolute;
left:22%;
top:40%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍成功！</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>添加成功！</h1>
<p><s:a href="AdminAddBook.jsp" >继续添加</s:a>|<s:a href="AdminMain.jsp">返回主页</s:a></p>
</div>
</body>
</html>