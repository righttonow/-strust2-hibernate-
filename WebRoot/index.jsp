<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.*" import="org.apache.struts2.ServletActionContext" import="action.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	<title>主页</title>
	
  </head>
  
  <body>
  <s:include value="UserMain.jsp"/>
  <%
  		Student s=(Student)session.getAttribute("loginstudent");
  		String sname=s.getSname();
  		Double price=s.getPrice();
   %>
   
<!-- <%=sname%>同学，欢迎您！
&nbsp;&nbsp;&nbsp;
<a href="loginoff.action" style="text-decoration:none">注销</a>

<br/> -->

	 <s:if test="hasActionMessages()">
        <div class="actionmessage">
            <s:actionmessage />     
            </div></s:if>
<s:fielderror/>
<br/>
<table class="OrderTable" style="position:absolute;top:30%;left:10%;right:15%;">
<tr>
<td>书号</td>
<td>书名</td>
<td>价格</td>
</tr>
<s:iterator value="#session.bookList" var="book" status="index">
<tr>
<td><s:property value="#book.isbn"/></td>
<td><s:property value="#book.bname"/></td>
<td><s:property value="#book.price"/></td>
<td>

 <a href="Addcart.action?isbn=<s:property value="#book.isbn"/>">
加入订购单</a></td>
</tr>
</s:iterator>

</table>
<br/>

<!--  
<a href="carts.action" style="text-decoration:none">查看订购单</a>-->
</body>
</html>
