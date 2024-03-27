<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="icon" type="image/png" href="/img/favicon.png" />
<link rel="stylesheet"  href="/css/common.css" />
<style>
   input:not(input[type=submit]) { width:100%; }
   input[type=submit] { width : 100px; }
   #goList  { width : 80px; }
   
   td { 
      padding:10px;
      width: 700px;
      text-align: center;
   }
   td:nth-of-type(1) {
      width : 200px;
   }
   td:nth-of-type(2) {
      text-align: left;
   }
   
   td:not([colspan]):first-child {
      background: black;
      color : white;
      font-weight: bold;
   }
   
   input[readonly] {
      background: #EEE;
   }

</style>
</head>
<body>
  <main>
  <%@include file="/WEB-INF/include/menus.jsp" %>
	<h2> ${vo.menu_id}  정보</h2>	
	<table>
	 <tr>
	   <td>bno</td>
	   <td>${vo.bno}</td>
	 </tr>
	 <tr>
	   <td>아이디</td>
	   <td>${vo.menu_id}</td>
	 </tr>
	 <tr>
	   <td>타이틀</td>
	   <td>${vo.title}</td>
	 </tr>
	 <tr>
	   <td>내용</td>
	   <td>${vo.content}</td>
	 </tr>
	 <tr>
	   <td>글쓴이</td>
	   <td>${vo.writer}</td>
	 </tr>
	 <tr>
	   <td>날짜</td>
	   <td>${vo.regdate}</td>
	 </tr>
	<tr>
	   <td>좋아요</td>
	   <td>${vo.hit}</td>
	 </tr>
	 <tr>
	   <td colspan="2">
	    
	    <a class="btn btn-primary btn-sm" role="button" 
	    href="/Board/List?menu_id=${vo.menu_id}" >게시판 목록</a>
	    <a class="btn btn-primary btn-sm" role="button" 
	    href="/" >Home</a> 
	   </td>
	 </tr>
	</table>
	
  </main>
  
  <script>
  	
  
  </script>
  
</body>
</html>





