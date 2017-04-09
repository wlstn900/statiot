<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:if test="${pageContext.request.userPrincipal.name ==null}"> --%>
	<a href="${pageContext.request.contextPath}/login">지하철 상세정보를 보려면 여기를 클릭하세요.</a>
		
	<%-- </c:if> --%>
</body>
</html>