<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta charset=utf-8>
<meta name=description content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link rel="import" href="http://www.polymer-project.org/components/paper-ripple/paper-ripple.html">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/meterial.css">
<script src="/js/jquery-2.1.3.min.js"></script>
</head>
<body>
	<div class="landing" id="landing">
		<div class="start-form">
			<div class="landing-form">
				<div class="group">
					<input type="text" name="member" required> <span class="highlight"></span> <span class="bar"></span> <label>참여자 수</label>
					<div id="button" class="button raised green">
						<div class="center" fit>START</div>
						<paper-ripple fit></paper-ripple>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="ladder" class="ladder">
		<div class="dim"></div>
		<canvas class="ladder_canvas" id="ladder_canvas"></canvas>
	</div>
	<script src="/js/ladder.js"></script>
</body>
</html>