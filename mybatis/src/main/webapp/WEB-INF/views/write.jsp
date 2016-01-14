<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/screen.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글 작성</title>
</head>
<body>
	<h1 style="text-align: center">글쓰기</h1>
	
	<%-- <c:if test="${empty sessionScope.loginId}">
	<script type="text/javascript">
		alert("로그인 상태가 아니시네요. 로그인해주세요.");
		location.href ="login.do";
	</script>
	</c:if>
	 --%>
	<div style="text-align: right; margin-right: 30%;">
		<h5> ${loginId} 님 <br><a href="logout.do">로그아웃</a></h5>
	</div>
	<br>
	
	<form method="POST" action="insert.do" >
	<table border="1" id="wrtieTable">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${loginId}" size="25" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="25"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="100" name="content"></textarea></td>
		</tr>
	</table>
	<div style="text-align: center">
	<input type="submit" value="작성 완료"/>
	</div>
</form>
<br><br>
	<div style="text-align: center">
	<a href="list.do?page=1">목록으로</a>
	</div>
</body>
</html>