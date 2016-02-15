<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<sec:authorize access="isAuthenticated()">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="login?logout">Logout</a>
			</h2>
		</c:if>
	</sec:authorize>
	
	<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<H1>ROLE_ADMIN!!!</H1>
	</sec:authorize>
	
	<sec:authorize access="hasAuthority('ROLE_USER')">
		<h1>ROLE_USER!!!</h1>
	</sec:authorize>
	
	
</body>
</html>