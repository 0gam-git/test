<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>로그인 완료!</h1>

	<sec:authorize access="isAuthenticated()">
		<div>
			<p><sec:authentication property="name" /> 님 환영합니다.</p>
			
			<%-- <p><c:url value="/logout" var="logoutUrl" /> <a
				href="${logoutUrl}">로그아웃</a></p> --%>
				
			<p><a href="logout" >로그아웃</a>
		</div>
	</sec:authorize>

</body>
</html>
