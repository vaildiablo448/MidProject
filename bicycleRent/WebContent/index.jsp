<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
<style>
ul{
list-style-type:none;
list-style-image:url('Images/indexButtonS.gif');
list-style-position:inside;
}
#X1{
border:thick solid 	#99BBFF;
width:700px;
border-radius:20px;
margin:200px 400px;
background-color:#FFCCCC;
height:400px;
}
h1{
color:#003C9D;
font-family:標楷體;
font-weight:700;
letter-spacing:3px;
}
a{
font-size:140%;
margin-left:100px;
}
</style>
</head>
<body>
<div id='X1'>
<div style="padding-left:50px"><h1>EEIT-10728 單車租借資訊系統</h1></div>
<div>
<ul>
<li><a href="<c:url value='Find.jsp'/>">查詢租借資訊</a><p/></li><hr>
<li><a href="<c:url value='Insert.jsp'/>">新增租借資訊</a><p/></li><hr>
<li><a href="<c:url value='Update.jsp'/>">修改租借資訊</a><p/></li><hr>
<li><a href="<c:url value='Delete.jsp'/>">刪除租借資訊</a><p/></li><hr>
</ul>
</div>
</div>
</body>
</html>