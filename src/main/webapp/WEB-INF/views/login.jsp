<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<style>
		html {
			height: 100%;
		}
		
		body {
			height: 100%;
			background: url(<c:url value = "/resources/images/background3.jpg"/>) no-repeat center fixed;
			background-size: cover;
			text-align: center;
		}
		
		.container-fluid {
			height: 100%;
		}
		
		.row {
			position: relative;
			height: 100%;
		}
		
		.login {
			color: white;
			font-family: 'Malgun Gothic';
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
		}
		
		.login h1 {
			font-size: 70px;
			font-weight: bold;
			margin-top: 0;
		}
		
		.form-group {
			border-bottom: 1px solid white;
		}
		
		.login form .form-group input {
			color: white;
			background: transparent;
			border: none;
		}
		
		.login form .btn {
			border: 1px solid white;
			border-radius: 0;
			color: white;
			background: transparent;
		}
		
		.login form .btn:hover {
			color: black;
			background-color: white;
		}
		
		input::-webkit-input-placeholder { /* Chrome/Opera/Safari */
			color: white !important;
		}
		
		input::-moz-placeholder { /* Firefox 19+ */
			color: white;
		}
		
		input:-ms-input-placeholder { /* IE 10+ */
			color: white;
		}
		
		input:-moz-placeholder { /* Firefox 18- */
			color: white;
		}
	</style>
	<!-- bootstrap css -->
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!-- [if lt IE 9]>
		<script src="<c:url value="/resources/html5shiv/html5shiv.min.js"/>">
		<script src="<c:url value="/resources/respond/respond.min.js"/>">
	<![endif]-->
	
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="login">
				<h1>STATIOT</h1>
				<h3>Status Station in IoT</h3>
		
				<c:if test="${not empty logout}">
					<div style="color: #0000ff">
						<h3>${logout}</h3>
					</div>
				</c:if>
		
				<c:if test="${not empty error}">
					<div style="color: #ff0000">
						<h3>${error}</h3>
					</div>
				</c:if>
		
				<c:if test="${pageContext.request.userPrincipal.name !=null}">
					<div>
						<a href="<c:url value="/subway"/>" style="color: #ff0000" >
						<h3>${pageContext.request.userPrincipal.name}님 환영합니다.</h3></a>
					</div>
				</c:if>
				
				<c:if test="${pageContext.request.userPrincipal.name ==null}">
					<!-- <form role="form" name="loginform" id="loginform" action="/statiot/login" method="post"> -->
					<form role="form" name="loginform" id="loginform"
						action="<c:url value="/login"/>" method="post">
						<div class="form-group">
							<label for="user_login" class="sr-only">username</label> <input
								type="text" name="username" class="form-control"
								placeholder="username">
						</div>
						<div class="form-group">
							<label for="user_pass" class="sr-only">password</label> <input
								type="password" name="password" class="form-control"
								placeholder="password">
						</div>
			
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="submit" name="submit"
							id="submit" class="btn btn-default btn-block" value="LOGIN">
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>