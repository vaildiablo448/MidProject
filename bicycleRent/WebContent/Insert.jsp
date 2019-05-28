<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增租借資訊</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
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
h2{
text-align:center;

}

#Y1{
text-align:center;
}
</style>
</head>
<body>
<div id='X1'>
<div style="padding-left:50px"><h1>EEIT-10728 單車租借資訊系統</h1></div>
<form name="insertForm" action="<c:url value='insert.do' />" method="POST">
<h2>新增租借資料</h2>
租借編號:
<input id='num' style="text-align: left" value="${param.caseNum}" name="caseNum" type="text" size="15">
<div style="color:#FF0000; font-size:60%; display:inline">${ErrorMsg.caseNum}</div>
<hr>
租借時間:
<input id='num' style="text-align: left" value="${param.rentTime}" name="rentTime" type="text" size="15">
<div style="color:#FF0000; font-size:60%; display:inline">${ErrorMsg.rentTime}</div>
<hr>
租借車站:
<input value="${param.rentStation}" name="rentStation" type="text" size="15">
<div style="color:#FF0000; font-size:60%; display:inline">${ErrorMsg.rentStation}</div>
<hr>
歸還時間:
<input value="${param.returnTime}" name="returnTime" type="text" size="15">
<div style="color:#FF0000; font-size:60%; display:inline">${ErrorMsg.returnTime}</div>
<hr>
歸還車站:
<input value="${param.returnStation}" name="returnStation" type="text" size="15">
<div style="color:#FF0000; font-size:60%; display:inline">${ErrorMsg.returnStation}</div>
<hr>
借用時間:
<input value="${param.totalRentTime}" name="totalRentTime" type="text" size="15">
<hr>
<div style="text-align:center">
<input type="submit" value="送出">
<div style="color:#FF0000; display:inline">${ErrorMsg.exception}</div></div>
				
</form>
</div>


</body>
</html>