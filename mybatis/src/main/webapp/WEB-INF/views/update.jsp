<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/screen.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글 수정</title>
</head>
<body>

	<c:if test="${empty sessionScope.loginId}">
		<script type="text/javascript">
			alert("로그인 상태가 아니시네요. 로그인해주세요.");
			location.href = "login.do";
		</script>
	</c:if>

	<h1 style="text-align: center">글 보기</h1>
	<div style="text-align: right; margin-right: 30%;">
		<h5>
			${loginId} 님 <br> <a href="logout.do">로그아웃</a>
		</h5>
	</div>
	<br>

	<form name="fm" method="POST" action="update.do">
		<table border="1" id="updateTable">
			<tr>
				<th>번호</th>
				<td><input type="text" name="idx" value="${vo.idx}" size="25"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${vo.writer}"
					size="25" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${vo.title}"
					size="25" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="100" title="내용" id="content"
						name="content" readonly>${vo.content}</textarea></td>
			</tr>
		</table>

		<c:set var="sessionId" value="${loginId}" />
		<c:set var="writer" value="${vo.writer}" />

		<c:if test="${sessionId == writer}">
		<div style="text-align: right; margin-right: 30%;">
			<input type="submit" value="수정" />
			<input type="button" value="삭제" onclick="onDelete(${vo.idx});" />
		</div>
			<script type="text/javascript">
				fm.title.readOnly = false;
				fm.content.readOnly = false;
			</script>
		</c:if>
	</form>
	<br>
	<br>
	<div style="text-align: center">
		<a href="list.do?page=1" >목록으로</a>
	</div>
	<script type="text/javascript">

		function onDelete(delKey) {
			/* var idx = document.getElementById("idx"); */
			var flag = confirm("선택하신 글을 삭제 합니다.");
			if(flag == false){
				return;
			}else{
				location.href = "delete.do?idx="+delKey;
			}
			
		}
	</script>
</body>
</html>