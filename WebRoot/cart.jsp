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
left:90%;
background-color:red;
font-weight:60;
font-size:1.5em;
border:solid;
border-width:1px;
border-color:black;
height:5%;

}
</style>
<title>订购单</title>
</head>
<body>

	 <s:if test="hasActionMessages()">
        <div class="actionmessage">
            <s:actionmessage />     
            </div></s:if>
<s:fielderror/>
<%	Double count =(Double)session.getAttribute("count");
	 %>
<s:include value="UserMain.jsp"/>
<div class="UserDoBox">

<div class="PageTitle">
<h1>我的订购单</h1>

<ul>
</ul>
</div>
<div class="UserShowBox">
<s:if test="#session['carts']==null">
<p class="p">订购单空空的！</p>
</s:if>
<s:elseif test="#session['carts'].book.isbn.size==0">
<p class="p">订购单空空的！</p>
</s:elseif>
<s:else>
<h2>请认真核对，结算后无法撤销！</h2>
<table border=1 class="OrderTable">
<tr>
<th>ISBN</th><th>书名</th><th>单价</th><th colspan=2>操作</th>
</tr>
<s:iterator value="#session.carts" var="book">
<tr>
<td><s:property value="book.isbn"/></td>
<td><s:property value="book.bname"/></td>
<td><s:property value="book.price"/></td>
<td>
 <a href="deleteCart.action?isbn=<s:property value="book.isbn"/>">删除</a></td>
</tr>
</s:iterator>
</table>

<p style="position:absolute;top:80%;left:80%;font-size:1.2em;color:red;font-weight:600;">合计 ：<%=count %>元</p>

<a href="payaction.action" class="url">结算</a>
</s:else>
</div>
</div>
</body>
</html>