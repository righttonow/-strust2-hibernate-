<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*" import="org.apache.struts2.ServletActionContext" import="action.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.p{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:20%;
top:20%;
}
.url{
position:absolute;
top:90%;
left:85%;
background-color:white;
font-weight:600;
font-size:1.5em;
border:solid;
border-width:1px;
border-color:black;
height:5%;

}
</style>
<title>已订购书籍</title>
</head>
<body>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">
<s:actionmessage />
<div class="PageTitle">
<h1>已订购书籍</h1>
<ul>
</ul>
</div>
<div class="UserShowBox">
<s:if test="#session['List']==null">
<p class="p">订单空空的！</p>
</s:if>
<s:elseif test="#session['List'].book.isbn.size==0">
<p class="p">订单空空的！</p>
</s:elseif>
<s:else>
<h2>已订购书籍将由班级统一领取，日期等候学校通知</h2>
<table border=1 class="OrderTable">
<tr>
<th>ISBN</th><th>书名</th><th>单价</th>
</tr>
<s:iterator value="#session.List" var="book" status="index">
<tr>
<td><s:property value="book.isbn"/></td>
<td><s:property value="book.bname"/></td>
<td><s:property value="book.price"/></td>

</tr>
</s:iterator>
</table>

</s:else>
</div>
</div>
</body>
</html>