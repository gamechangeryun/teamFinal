<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 변경</title>
<script>
	function checkIt(){
		var myform = eval("document.myForm");
		
		if(!myform.nowPassword.value){
			alert("현재 비밀번호를 입력하세요");
			return false;
		}
		
		if(!myform.newPassword.value){
			alert("새로운 비밀번호를 입력하세요");
			return false;
		}
		
		if(!myform.newPassword2.value){
			alert("새로운 비밀번호를 한 번더 입력하세요");
			return false;
		}
		
		if(myform.newPassword.value != myform.newPassword2.value){
			alert("입력하신 새로운 비밀번호가 동일하지 않습니다.");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1><strong>비밀번호 변경</strong></h1>
	
	<form name="myForm" action="/FinalProject/changePassword.do"  method="post" onsubmit="return checkIt()">
		현재 비밀번호 &nbsp;&nbsp;<input type="password" name="nowPassword"><br />
		새로운 비밀번호<input type="password" name="newPassword"><br />
		비밀번호 재입력<input type="password" name="newPassword2"><br />
		<p />
		<input type="submit" value="변경">
		<input type="button" value="돌아가기" onclick="location.href='/FinalProject/${mainPage}'">
	</form>
</body>
</html>