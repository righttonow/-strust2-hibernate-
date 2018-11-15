<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教材单</title>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>教材单</h1>
<s:actionmessage/><br>
<table border=1 class="OrderTable">
<tr>
<th>ISBN</th><th>书名</th><th>单价</th><th colspan=2>操作</th>
</tr>
<s:iterator value="#session.allbook" var="book">
<tr>
<td><s:property value="#book.isbn"/></td>
<td><s:property value="#book.bname"/></td>
<td><s:property value="#book.price"/></td>
<td>
 <a href="deleteBook.action?isbn=<s:property value="#book.isbn"/>">删除</a></td>
</tr>
</s:iterator>
</table>
</div>
</body>
</html>