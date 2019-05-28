<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜尋資料</title>

<style>
form {
	margin: 0 auto;
	width: 700px;
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

ul{
list-style-type:circle;


}

h2{
padding-left:50px

}


</style>
</head>



<body>
<div id='X1'>
<div style="padding-left:50px"><h1>EEIT-10728 單車租借資訊系統</h1>
<h2 >編號 ${bicycleBean.caseNum}的資料搜尋如下</h2>
<ul><li>租借時間: ${bicycleBean.rentTime}</li><hr>
<li>租借車站: ${bicycleBean.rentStation}</li><hr>
<li>歸還時間: ${bicycleBean.returnTime}</li><hr>
<li>歸還地點: ${bicycleBean.returnStation}</li><hr>
<li>總租借時間: ${bicycleBean.totalRentTime}</li>
</ul></div>
<div style="text-align:center;padding-top:20px">
<a href="<c:url value='index.jsp'/>">返回首頁</a></div>
</div>

</body>
</html>