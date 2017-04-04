<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<%-- <c:if test="${pageContext.request.userPrincipal.name!=null}"></c:if> --%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title></title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    
    <link href="<c:url value="/resources/css/circle.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        html {
            height: 100%;
        }
        
        body {
            height: 100%;
            padding-top: 70px;
            text-align: center;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        
        .clearfix:before,.clearfix:after {content: " "; display: table;}
        .clearfix:after {clear: both;}
        .clearfix {*zoom: 1;}
        
        .morris-hover{position:absolute;z-index:1000}
        .morris-hover.morris-default-style{border-radius:10px;padding:6px;color:white;background:rgba(0,0,0,0.6);font-family:sans-serif;font-size:16px;text-align:center}
        .morris-hover.morris-default-style .morris-hover-row-label{font-weight:bold;margin:0.25em 0;font-size:20px}
        .morris-hover.morris-default-style .morris-hover-point{font-weight:bold;white-space:nowrap;margin:0.1em 0}
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="<c:url value="/resources/html5shiv/html5shiv.min.js"/>">
		<script src="<c:url value="/resources/respond/respond.min.js"/>">
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">STATIOT</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                    	<c:if test="${pageContext.request.userPrincipal.name !=null}">
							<li><a>Welcome : ${pageContext.request.userPrincipal.name}</a></li>
							
							<li><a href="<c:url value="/logout"/>">Logout</a></li>
						</c:if>
               
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container" style="margin: 0">

        <div class="row">
            <div class="col-sm-4 text-center">
                <h3 class="text-center">
                    TEMPERATURE
                </h3>
                <div id="line-chart"></div>
                
                <h3 class="text-center">
                    AMOUNT OF TOILET PAPER
                </h3>
                <!-- man -->
                <div class="clearfix">

                    <img src="<c:url value="/resources/images/icon-man.png"/>" style="float: left; padding-top: 10px" />

                    <div class="c100 p70 small">
                        <span>70%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>

                    <div class="c100 p43 small yellow">
                        <span>43%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>

                    <div class="c100 p12 small red">
                        <span>12%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>

                </div>
                <!-- /man -->

                <!-- woman -->
                <div class="clearfix">

                    <img src="<c:url value="/resources/images/icon-woman.png"/>" style="float: left; padding-top: 10px" />

                    <div class="c100 p35 small yellow">
                        <span>35%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>

                    <div class="c100 p7 small red">
                        <span>7%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>

                    <div class="c100 p90 small">
                        <span>90%</span>
                        <div class="slice">
                            <div class="bar"></div>
                            <div class="fill"></div>
                        </div>
                    </div>

                </div>
                <!-- /woman -->
            </div>
            <img src="<c:url value="/resources/images/subway_map2.jpg"/>" width="66%">
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.1 -->
    <script src="<c:url value="/resources/js/jquery.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

    <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.2/raphael-min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.0/morris.min.js'></script>

    <script>
    
    var today=new Date();
    var time=today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    var temp = new Array(5);
    var humid = new Array(5);
    
    temp[0]="${subwayInfo0.temperature}";
    temp[1]="${subwayInfo1.temperature}";
    temp[2]="${subwayInfo2.temperature}";
    temp[3]="${subwayInfo3.temperature}";
    temp[4]="${subwayInfo4.temperature}";
    
    humid[0]="${subwayInfo0.humidity}";
    humid[1]="${subwayInfo1.humidity}";
    humid[2]="${subwayInfo2.humidity}";
    humid[3]="${subwayInfo3.humidity}";
    humid[4]="${subwayInfo4.humidity}";

    var data = [
      { x: time, a: temp[0], b: humid[0]},
      { x: time, a: temp[1], b: humid[1]},
      { x: time, a: temp[2], b: humid[2]},
      { x: time, a: temp[3], b: humid[3]},
      { x: time, a: temp[4], b: humid[4]}
    ],
    config = {
      parseTime: false,
      data: data,
      xkey: 'x',
      ykeys: ['a', 'b'],
      labels: ['Temperature', 'Humidity'],
      fillOpacity: 0.6,
      hideHover: 'auto',
      behaveLikeLine: true,
      resize: true,
      pointFillColors: ['white'],
      pointStrokeColors: ['white'],
      lineColors: ['red','blue']
    };

    /* config.element = 'area-chart';
    Morris.Area(config); */
    config.element = 'line-chart';
    Morris.Line(config);
    /* config.element = 'bar-chart';
    Morris.Bar(config);
    config.element = 'stacked';
    config.stacked = true;
    Morris.Bar(config);
    Morris.Donut({
      element: 'pie-chart',
      data: [
        {label: "Friends", value: 30},
        {label: "Allies", value: 15},
        {label: "Enemies", value: 45},
        {label: "Neutral", value: 10}
      ]
    }); */
    </script>

</body>

</html>
