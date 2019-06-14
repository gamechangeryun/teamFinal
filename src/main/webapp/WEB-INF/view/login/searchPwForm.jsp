<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myForm");
		
		if(!thisForm.id.value){
			alert("아이디를 입력하세요");
			return false;
		}
		
		if(!thisForm.email.value){
			alert("이메일을 입력하세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1><strong>비밀번호찾기</strong></h1>
	<form action="/FinalProject/searchPw.do"  method="post" name="myForm" onsubmit="return checkIt()">
		<table border="1">
			<tr>
				<td>
					아이디  &nbsp;&nbsp;
					<input type="text" name="id"><br />
					이메일  &nbsp;&nbsp;
					<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="abcd@abcd.com">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="비밀번호찾기">
					<input type="button" value="닫기" onclick="window.close()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>