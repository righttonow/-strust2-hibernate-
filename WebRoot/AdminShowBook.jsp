<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/AdminStyle.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="book.title"/></title>
<style type="text/css">
.pic{
position:absolute;
top:20%;
width:30%;
height:70%;
left:5%;
border:solid;
}
.table{
position:absolute;
top:15%;
width:50%;
height:95%;
left:40%;
}
.p{
position:absolute;
left:5%;
top:10%;
font-size:1.3em;
}
.item{
position:absolute;
width:20%;
left:80%;
}
.Title{
position:absolute;
font-size:1.2em;
left:25%;
}
.p1{
color:red;
font-size:2em;
font-weight:600;
position:absolute;
left:30%;
top:50%;
}
</style>
</head>
<body>
<s:include value="AdminMain.jsp"/>
<div class="AdminDoBox">
<h1>图书详情</h1>
<s:actionmessage class="actionMessage"/>
<s:if test="book.stockNum==-999">
<p class="p1">该商品已下架</p>
</s:if>
<s:else>
<img alt="无法加载图片" src="${book.paddress}" width="150" height="240" class="pic"/>
<div class="table">
<p class="p" style="position:absolute;top:0%;">ID</p><p class="Title" style="position:absolute;top:0%;"><s:property value="book.bookID"/></p>
<p class="p" style="position:absolute;top:10%;">书名:</p><p class="Title" style="position:absolute;top:10%;"><s:property value="book.title" /></p>
<p class="p" style="position:absolute;top:20%;">作者:</p><p class="Title" style="position:absolute;top:20%;"><s:property value="book.author"/></p>
<p class="p" style="position:absolute;top:30%;">出版社:</p><p class="Title" style="position:absolute;top:30%;"><s:property value="book.press" /></p>
<p class="p" style="position:absolute;top:40%;">定价:</p><p class="Title" style="position:absolute;top:40%;"><s:property value="book.price"/></p>
<p class="p" style="position:absolute;top:50%;">库存:</p><p class="Title" style="position:absolute;top:50%;"><s:property value="book.stockNum" /></p>
<p class="p" style="position:absolute;top:60%;">销量:</p><p class="Title" style="position:absolute;top:60%;"><s:property value="book.soldNum" /></p>
<p class="p" style="position:absolute;top:70%;">简介:</p><p class="Title" style="position:absolute;top:70%;"><s:property value="book.description" /></p>
</div>
</s:else>
</div>
</body>
</html>