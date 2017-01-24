function loginSubmit() {

	if ($('#input-id').val() == '') {
		alert('아이디 또는 비밀번호를 다시 확인해 주세요');
		$('#input-id').get(0).focus();
		return

	} else if ($('#input-pw').val() == '') {
		alert('아이디 또는 비밀번호를 다시 확인해 주세요');
		$('#input-pw').get(0).focus();
		return 

	}

	var reqUrl = "userInfo";
	var login_id = $('#input-id').val();
	var login_pw = $('#input-pw').val();
	var reqData = {
		'userId' : login_id,
		'userPw' : login_pw
	};
	var json_data = JSON.stringify(reqData);
	console.log(json_data);
	$.ajax({
		type : 'POST', // Http Request Method로 POST로 지정
		url : reqUrl, // 서버 요청 주소
		dataType : 'json',
		data : json_data,
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log(data);
		},
		error : function(xhr, textStatus) {
			alert(textStatus + " : " + xhr);
		}
	});
}