<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<%-- <c:if test="${pageContext.request.userPrincipal.name!=null}"/> --%>
<head>
	
	<meta charset="UTF-8">
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
	
	.clearfix:before,.clearfix:after {
		content: " ";
		display: table;
	}
	
	.clearfix:after {
		clear: both;
	}
	
	.clearfix {
		*zoom: 1;
	}
	
	.morris-hover {
		position: absolute;
		z-index: 1000;
	}
	
	.morris-hover.morris-default-style {
		border-radius: 10px;
		padding: 6px;
		color: white;
		background: rgba(0, 0, 0, 0.6);
		font-family: sans-serif;
		font-size: 16px;
		text-align: center;
	}
	
	.morris-hover.morris-default-style .morris-hover-row-label {
		font-weight: bold;
		margin: 0.25em 0;
		font-size: 20px;
	}
	
	.morris-hover.morris-default-style .morris-hover-point {
		font-weight: bold;
		white-space: nowrap;
		margin: 0.1em 0;
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
	
	.popover {
		position: absolute;
		display: none;
		background: #fff;
		border: 1px solid #999;
		padding: 10px;
		width: auto;
		box-shadow: 0 0 10px rgba(0, 0, 0, .5);
		text-align: center;
	}
	
	.popover:after,.popover:before {
		right: 100%;
		border: solid transparent;
		content: " ";
		height: 0;
		width: 0;
		position: absolute;
		pointer-events: none;
	}
	
	.popover:after {
		border-color: rgba(255, 255, 255, 0);
		border-right-color: #ffffff;
		border-width: 10px;
		top: 50%;
		margin-top: -10px;
	}
	
	.popover:before {
		border-color: rgba(201, 201, 201, 0);
		border-right-color: #c9c9c9;
		border-width: 11px;
		top: 50%;
		margin-top: -11px;
	}
	</style>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	        <script src="<c:url value="/resources/html5shiv/html5shiv.min.js"/>">
			<script src="<c:url value="/resources/respond/respond.min.js"/>">
	    <![endif]-->
	
	<!-- jQuery Version 1.11.1 -->
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	
	<script src="<c:url value="/resources/js/raphael-min.js"/>"></script>
	<script src="<c:url value="/resources/js/morris.min.js"/>"></script>
	
	<script src="<c:url value="/resources/js/svg-pan-zoom.min.js"/>"></script>
	<script src="<c:url value="/resources/js/thumbnailViewer.js"/>"></script>
	
	<script>
	    $(document).ready(function() {
		    var today = new Date();
		    //var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
		    var time = new Array(5);
		    var temp = new Array(5);
		    var humid = new Array(5);
		    
		    temp[0] = "${tempAndHumid0.temperature}";
		    temp[1] = "${tempAndHumid1.temperature}";
		    temp[2] = "${tempAndHumid2.temperature}";
		    temp[3] = "${tempAndHumid3.temperature}";
		    temp[4] = "${tempAndHumid4.temperature}";
		    
		    humid[0] = "${tempAndHumid0.humidity}";
		    humid[1] = "${tempAndHumid1.humidity}";
		    humid[2] = "${tempAndHumid2.humidity}";
		    humid[3] = "${tempAndHumid3.humidity}";
		    humid[4] = "${tempAndHumid4.humidity}";
		    				
		    time[0] = "${tempAndHumid0.date}";
		    time[1] = "${tempAndHumid1.date}";
		    time[2] = "${tempAndHumid2.date}";
		    time[3] = "${tempAndHumid3.date}";
		    time[4] = "${tempAndHumid4.date}"; 
		   
		    var data = [
		      { x: time[0], a: temp[0], b: humid[0]},
		      { x: time[1], a: temp[1], b: humid[1]},
		      { x: time[2], a: temp[2], b: humid[2]},
		      { x: time[3], a: temp[3], b: humid[3]},
		      { x: time[4], a: temp[4], b: humid[4]}
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
	    });
    </script>

	<script>
    	var obj;
    	
        $(document).ready(function() {
        	$('#seoulSubwayMap')[0].addEventListener('load', function() {
                obj = svgPanZoom('#seoulSubwayMap');

                obj.pan({x: 0, y: 0});
                obj.zoomAtPointBy(1.455, {x: $('#mainViewContainer').width()/2, y: 0});
                obj.setZoomScaleSensitivity(0.4);
                obj.setMinZoom(1.455);
                obj.setMaxZoom(15);
                obj.setOnPan(function(e) {
                    if ($('.popover').css('display') == 'block') {
                        $('.popover').hide(); 
                        console.log("TTTT");
                    }
                });
                var svgDoc = $('#seoulSubwayMap')[0].getSVGDocument();

                svgDoc.onmousemove = function(evt) {
                    var clickedElement = evt.target;
                     
                    $(svgDoc).find('text').attr('font-size', '20px');
                    $(svgDoc).find('tspan').attr('font-size', '20px');
                    if ($(clickedElement).is("text") || $(clickedElement).is("tspan")) {
                        if ($(clickedElement).parent().attr('id') != 'legend_x5F_ko' 
                        		&& $(clickedElement).parent().attr('id') != 'legend') {
                            $(clickedElement).css('cursor', 'pointer');
                            $(clickedElement).attr('font-size', '30px');
                            if ($(clickedElement).is("tspan")) {
                                $(clickedElement).siblings().css('cursor', 'pointer');
                                $(clickedElement).siblings().attr('font-size', '30px');
                            }
                        }
                    }
                }
                
                svgDoc.onclick = function(evt) {
                    var clickedElement = evt.target;
                    if ($(clickedElement).is("text") || $(clickedElement).is("tspan")) {
                    	if (($(clickedElement).parent().attr('id') != 'legend_x5F_ko' 
                    			&& $(clickedElement).parent().attr('id') != 'legend') 
                    			|| $(clickedElement).is("tspan")) {
	                        //console.log($(clickedElement).text());
	                        var left = evt.clientX;
	                        var top = evt.clientY;
	                        var theHeight = $('.popover').height();
	                        var leftWidth = $('#leftContent').width();
	                        var titleHeight = $('nav').height(); 
	                        
	                      	// json 방식
	                        $.ajax({
	                            url : "/statiot/otherInfo/" + $(clickedElement).text(),
	                            dataType : "json",
	                            type : "get",
	                            //data : $('#formId').serializeArray(),
	                            success : function(data) {
									//console.log(data);
									$('#popupTitle').html("<b>" + $(clickedElement).text() + "</b>");
									if ($(clickedElement).is("tspan")) {
									    if ($(clickedElement).next().is("tspan")) {
									        $('#popupTitle').append("<b>" + $(clickedElement).siblings().text() + "</b>");
									    } else {
									        $('#popupTitle').prepend("<b>" + $(clickedElement).siblings().text() + "</b>");
									    }
									}
									$('#popupContents').html("온도 &nbsp;:&nbsp;" + data.temperature + " ℃<br>습도 &nbsp;:&nbsp;" + data.humidity + " %<br><br>");
									$('.popover').show();
									$('.popover').css("left", (left + leftWidth + 60) + 'px');
									$('.popover').css("top", (top + (titleHeight + 10) - (theHeight / 2)) + 'px');
									
									$('.modal-title').html("<b>" + $(clickedElement).text() + "</b>");
									$('#transformerRoom').attr('src', '<c:url value="/resources/images/transformer-room.jpg"/>');
									$('#machineRoom').attr('src', '<c:url value="/resources/images/machine-room.jpg"/>');
									$('#tDecibel').html("20" + "dB");
									$('#mDecibel').html("35" + "dB");
									$('#rDecibel').html("50" + "dB");
	                            },
	                            error : function(request, status, error) {
	                            	alert($(clickedElement).text() + "역에 대한 정보가 없습니다.");
	                                //alert("code:"+request.status+"\n"+"error:"+error);
	                            } 
	                        });
                    	}
                    } else {
                        if ($('.popover').css('display') == 'block') {
                            $('.popover').hide();  
                        }
                    }   
                }
            });
        	
            $("#checkAll").click(function() {
                if ($("#checkAll").prop("checked"))
                    $("input[name=chk]").prop("checked", true);
                else
                    $("input[name=chk]").prop("checked", false);
            });
            
            $("#confirmChecked").click(function() {
                $("#checkAll").prop("checked", false);
                $("input[name=chk]").prop("checked", false);
                $("#eIcon1").css('color', '#ABF200');
                $("#eIcon2").css('color', '#ABF200');
                $("#eIcon3").css('color', '#ABF200');
                $(this).blur();
            });
            
            $("#confirm1").click(function() {
                $("#check1").prop("checked", false);
                $("#eIcon1").css('color', '#ABF200');
                $(this).blur();
            });
            
            $("#confirm2").click(function() {
                $("#check2").prop("checked", false);
                $("#eIcon2").css('color', '#ABF200');
                $(this).blur();
            });
            
            $("#confirm3").click(function() {
                $("#check3").prop("checked", false);
                $("#eIcon3").css('color', '#ABF200');
                $(this).blur();
            });
        });
    </script>

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
				<a class="navbar-brand" href="#"><i class="fa fa-subway"></i> STATIOT</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li>
							<a href="#"><span class="glyphicon glyphicon-user"></span> Welcome ${pageContext.request.userPrincipal.name}</a>
						</li>
						<li>
							<a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
						</li>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container-fluid" id="wrap">

		<div class="row" id="content">

			<div class="col-sm-3 text-center" id="leftContent">

				<h3 class="text-center">TEMPERATURE</h3>
				<div id="line-chart"></div>

				<h3 class="text-center">
					AMOUNT OF<br>TOILET PAPER
				</h3>
				<!-- man -->
				<div class="clearfix">

					<img class="col-sm-3 col-xs-4" src="<c:url value="/resources/images/icon-man.png"/>"
						alt="man" style="width: 70px; padding: 5px 0 0 0" />

					<div class="col-sm-9 col-xs-8">
						<c:if test="${ultraSonic_male<15}">
							<div class="c100 p${ultraSonic_male} small red">
						</c:if>
						<c:if test="${ultraSonic_male>=15&&ultraSonic_male<60}">
							<div class="c100 p${ultraSonic_male} small yellow">
						</c:if>
						<c:if test="${ultraSonic_male>=60}">
							<div class="c100 p${ultraSonic_male} small">
						</c:if>
							<span>${ultraSonic_male}%</span>
							<div class="slice">
								<div class="bar"></div>
								<div class="fill"></div>
							</div>
						</div>
	
						<c:if test="${ultraSonic_male<15}">
							<div class="c100 p${ultraSonic_male} small red">
						</c:if>
						<c:if test="${ultraSonic_male>=15&&ultraSonic_male<60}">
							<div class="c100 p${ultraSonic_male} small yellow">
						</c:if>
						<c:if test="${ultraSonic_male>=60}">
							<div class="c100 p${ultraSonic_male} small">
						</c:if>
							<span>${ultraSonic_male}%</span>
							<div class="slice">
								<div class="bar"></div>
								<div class="fill"></div>
							</div>
						</div>
					</div>

				</div>
				<!-- /man -->

				<!-- woman -->
				<div class="clearfix">

					<img class="col-sm-3 col-xs-4" src="<c:url value="/resources/images/icon-woman.png"/>"
						alt="woman" style="width: 70px; padding: 5px 0 0 0" />

					<div class="col-sm-9 col-xs-8">
						<c:if test="${ultraSonic_female<15}">
							<div class="c100 p${ultraSonic_female} small red">
						</c:if>
						<c:if test="${ultraSonic_female>=15&&ultraSonic_female<60}">
							<div class="c100 p${ultraSonic_female} small yellow">
						</c:if>
						<c:if test="${ultraSonic_female>=60}">
							<div class="c100 p${ultraSonic_female} small">
						</c:if>
							<span>${ultraSonic_female}%</span>
							<div class="slice">
								<div class="bar"></div>
								<div class="fill"></div>
							</div>
						</div>

						<c:if test="${ultraSonic_female<15}">
							<div class="c100 p${ultraSonic_female} small red">
						</c:if>
						<c:if test="${ultraSonic_female>=15&&ultraSonic_female<60}">
							<div class="c100 p${ultraSonic_female} small yellow">
						</c:if>
						<c:if test="${ultraSonic_female>=60}">
							<div class="c100 p${ultraSonic_female} small">
						</c:if>
							<span>${ultraSonic_female}%</span>
							<div class="slice">
								<div class="bar"></div>
								<div class="fill"></div>
							</div>
						</div>
					</div>
					
				</div>
				<!-- /woman -->

			</div>

			<div class="col-sm-7"
				style="padding: 0; margin-top: 20px; overflow: hidden; box-shadow: 0 0 4px #888888">
				<embed id="seoulSubwayMap" type="image/svg+xml"
					src="<c:url value="resources/images/Seoul_subway_linemap_ko.svg"/>"
					width="200%" height="500px">
			</div>

			<div class="col-sm-2">
				<h3 class="text-center">EMERGENCY</h3>
				<div class="form-group">
					<hr>
					<input type="checkbox" id="checkAll">
					<span>전체선택 &nbsp;&nbsp;&nbsp;</span>
					<button type="button" class="btn btn-default" id="confirmChecked">선택확인</button>
				</div>
				<div class="form-group">
					<hr>
					<label>
						<input type="checkbox" name="chk" id="check1">&nbsp;
						<%-- <c:if test="${subwayInfo0.men_rest_room_sound>=100}">
							<i class="material-icons" style="color: #FF0000">brightness_1</i>
						</c:if>
						<c:if test="${subwayInfo0.men_rest_room_sound<100}">
							<i class="material-icons" style="color: #ABF200">brightness_1</i>
						</c:if> --%>
						<i class="material-icons" id="eIcon1" style="color: #ABF200">brightness_1</i>
						<span>변전실 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
					</label>
					<button type="submit" class="btn btn-default" id="confirm1">확인</button>
				</div>
                <div class="form-group">
                    <hr>
                    <label>
                    	<input type="checkbox" name="chk" id="check2">&nbsp;
                    	<i class="material-icons" id="eIcon2" style="color: #FF0000">brightness_1</i>
                    	<span>기계실 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                    </label>
                    <button type="submit" class="btn btn-default" id="confirm2">확인</button>
                </div>
                <div class="form-group">
                    <hr>
                    <label>
                    	<input type="checkbox" name="chk" id="check3">&nbsp;
                    	<i class="material-icons" id="eIcon3" style="color: #ABF200">brightness_1</i>
                    	<span>화장실(여)</span>
                    </label>
                    <button type="submit" class="btn btn-default" id="confirm3">확인</button>
                    <hr>
                </div>
				<a href="#" class="btn btn-info btn-block btn-lg" style="margin: 50px 0 0 0">
					<span class="glyphicon glyphicon-refresh"></span> &nbsp;REFRESH
				</a>
			</div>

		</div>
		<!-- /.row -->

		<!-- popover -->
		<div class="popover" style="z-index: 1030">
			<h3 id="popupTitle">popupTitle</h3>
			<hr>
			<h3 id="popupContents">popupContents</h3>
			<button type="submit" class="btn btn-default" id="detailInfo"
				data-toggle="modal" data-target="#myModal">상세정보</button>
		</div>
		<!-- /popover -->

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Modal Header</h3>
                    </div>
                    <div class="modal-body row">
                        <div class="col-sm-4">
                            <h4><b>변전실</b></h4>
                            <img src='' alt='변전실' width="250px" id="transformerRoom" />
                            <h4 id="tDecibel">- - dB</h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><b>기계실</b></h4>
                            <img src='' alt='기계실' width="250px" id="machineRoom" />
                            <h4 id="mDecibel">- - dB</h4>
                        </div>
                        <div class="col-sm-4">
                            <h4><b>화장실(여)</b></h4>
                            <img src='<c:url value="/resources/images/restroom.png"/>' alt='화장실(여)' width="250px" id="restroom" />
                            <h4 id="rDecibel">- - dB</h4>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

			</div>
		</div>

	</div>
	<!-- /.container -->
	
    <footer class="footer text-center">
        <div class="container">
            <h5 style="color: white">Copyright &copy; Synergy 2017</h5>
        </div>
    </footer>

</body>

</html>
