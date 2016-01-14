<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/screen.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>
<body>

	<h1 style="text-align: center"> 리스트 폼 </h1>
	
<%-- 	<c:if test="${empty sessionScope.loginId}">
	<script type="text/javascript">
		alert("로그인 상태가 아니시네요. 로그인해주세요.");
		location.href ="login.do";
	</script>
	</c:if> --%>
	
	<div style="text-align: right; margin-right: 30%;">
		<h5> ${loginId} 님 <br><a href="logout.do">로그아웃</a></h5>
	</div>
	<br>
	
	<table border="1" id="listTable">
	<thead>
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>날짜</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="result" items="${viewVo}" varStatus="status">
	<tr>
		<td>${result.idx}</td>
		<td><a href="updateForm.do?idx=${result.idx}">${result.writer}</a></td>
		<td>${result.title}</td>
		<td>${result.regdate}</td>
	</tr>
	 </c:forEach>
	 </tbody>
	</table>
	<div style="text-align: right; margin-right: 30%;">
		<c:if test="${searchFlag == true}">
			<a href="list.do?page=1">목록으로</a>
		</c:if>
		<a href="insertForm.do">글쓰기</a>
	</div>
	<br>
	<div style="text-align: center">
	  	<c:forEach var="i" begin="1" end="${pageCount}" step="1">
		      <a href="list.do?page=${i}">${i}</a>
	    </c:forEach>
   </div>
   
    <form action="search.do" method="POST" >
    <table id="searchTable">
	    <tr>
			<td>
			    <select name="searchSelect">
			    	<option value="w">작성자</option>
			    	<option value="t">제목</option>
			    	<option value="w+c">작성자+내용</option>
			    	<option value="t+c">제목+내용</option>
			    </select>
			</td>    
			<td>
		    	<input type="text" id="searchText" name="searchText">
			</td>    
			<td>
		    	<input type="submit" id="serachButton" value="검색" >
			</td>    
	    </tr>
    </table>
    </form>
</body>
</html>