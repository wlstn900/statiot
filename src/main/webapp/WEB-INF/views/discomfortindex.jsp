<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title></title>

    <!-- Bootstrap Core CSS -->
   <link href="<c:url value="/resources/css/bootstrap.min.css"/>"
      rel="stylesheet">
   
   <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
   
   <link href="<c:url value="/resources/css/circle.css"/>" rel="stylesheet">
   
   <!-- icon -->
   <link href="<c:url value="/resources/css/icon.css"/>" rel="stylesheet">
   
   <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        html {
            height: 100%;
        }
        
        body {
            height: 100%;
            padding-top: 50px;
            text-align: center;
            margin: 0;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        
        .navbar {
            margin-bottom: 0;
        }
        
        .navbar-inverse .navbar-brand {
            color: white;
        }
        
        .navbar-inverse .navbar-nav>li>a {
            color: lightgray;
        }
        
        #wrap {
            min-height: 100%;
        }
        
        #content {
            padding-bottom: 40px;
        }
        
        .footer {
            bottom: 0px;
            width: 100%;
            height: 40px;
            margin-top: -40px;
            background-color: darkgray;
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- jQuery Version 1.11.1 -->
   <script src="<c:url value="/resources/js/jquery.js"/>"></script>
   
   <!-- Bootstrap Core JavaScript -->
   <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="${pageContext.request.contextPath}/subway"/>"> <i class="fa fa-subway"></i> STATIOT</a>
                <a class="navbar-brand" href="#" style="position: absolute; width: 100%; left: 0; text-align: center; margin: 0 auto">한성대입구역</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="myNavbar">
               <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/discomfortindex">불쾌지수</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#"><span class="glyphicon glyphicon-user"></span> ${pageContext.request.userPrincipal.name} 님</a>
                    </li>
                    <li>
                        <a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <div class="container-fluid" id="wrap">

        <div class="row" id="content" style="padding-top: 100px">
            
            <div class="col-sm-2"></div>
            
            <div class="col-sm-3">
                <div style="padding: 0 10px 0 10px; background-color: #FBFBFB; box-shadow: 0 0 4px #888888">
                    <h2 style="padding: 20px 0 10px 0"><b>불쾌지수 단계</b></h2>
                    <div style="text-align: left">
                        <span style="display: inline-block; width: 80px; height: 50px; background-color: #C30C0C"></span>
                        <span style="display: inline-block">
                            <p style="font-size: 15px"><b style="color: #C30C0C">매우 높음</b> (80 이상)</p>
                            <p style="font-size: 15px">전원 불쾌감을 느낌</p>
                        </span>
                    </div>
                    <div style="text-align: left">
                        <span style="display: inline-block; width: 80px; height: 50px; background-color: #FF9921"></span>
                        <span style="display: inline-block">
                            <p style="font-size: 15px"><b style="color: #FF9921">높음</b> (75 ~ 80)</p>
                            <p style="font-size: 15px">50% 정도 불쾌감을 느낌</p>
                        </span>
                    </div>
                    <div style="text-align: left">
                        <span style="display: inline-block; width: 80px; height: 50px; background-color: #FFD966"></span>
                        <span style="display: inline-block">
                            <p style="font-size: 15px"><b style="color: #FFD966">보통</b> (68 ~ 75)</p>
                            <p style="font-size: 15px">불쾌감을 나타내기 시작함</p>
                        </span>
                    </div>
                    <div style="text-align: left">
                        <span style="display: inline-block; width: 80px; height: 50px; background-color: #ABF200"></span>
                        <span style="display: inline-block">
                            <p style="font-size: 15px"><b style="color: #ABF200">낮음</b> (68 미만)</p>
                            <p style="font-size: 15px">전원 쾌적함을 느낌</p>
                        </span>
                    </div>
                </div>
            </div>
            
            <div class="col-sm-1"></div>
            
            <div class="col-sm-4">
                <div style="padding: 0 10px 10px 10px; margin-top: 40px; background-color: #FBFBFB; box-shadow: 0 0 4px #888888">
                    <h2 style="padding: 20px 0 10px 0"><b>오늘의 불쾌지수</b></h2>
                    <h4><b>${DI}</b></h4>
                </div>
                <div style="padding: 0 10px 10px 10px; margin: 40px 0 20px 0; background-color: #FBFBFB; box-shadow: 0 0 4px #888888">
                    <h2 style="padding: 20px 0 10px 0"><b>불쾌지수 공식</b></h2>
                    <h4><b>DI = 9 / 5Ta - 0.55(1 - RH)(9 / 5Ta - 26) + 32</b></h4>
                    <h4>[ Ta : 건구온도 (℃), RH : 상대습도 (소수단위) ]</h4>
                </div>
            </div>
            
            <div class="col-sm-2"></div>
            
        </div>
        <!-- /.row -->
        
    </div>
    <!-- /.container -->
    
    <footer class="footer text-center">
        <div class="container">
            <h5 style="color: white">&copy; 2017 Synergy.</h5>
        </div>
    </footer>

</body>

</html>