<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
숭기가리
</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name=description content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<script src="/js/login.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<div class = loginLayer>
		<form name ="login_proc" id = "login_proc" action = "isLogin" method = "post">
			<fieldset>
				<h>숭기가리 로그인</h>
				<table>
					<tr>
						<th>아이디</th><td><input type="text" value="" class="w150" id="input-id" name="input-id"></td>
					</tr>
					<tr>
						<th>비밀번호</th><td><input type="text" value="" class="w150" id="input-pw" name="input-pw"></td>
					</tr>
					<tr>
						<th><button type="button" class="btnLogin" onclick="javascript:loginSubmit()">로그인</button></th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>