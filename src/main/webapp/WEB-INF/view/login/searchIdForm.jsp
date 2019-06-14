<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>아이디찾기</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myForm");
		
		if(!thisForm.name.value){
			alert("이름을 입력하세요");
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
	<h1><strong>아이디찾기</strong></h1>
	<form action="/FinalProject/searchId.do"  method="post" name="myForm" onsubmit="return checkIt()">
		<table border="1">
			<tr>
				<td>
					이름  &nbsp;&nbsp;
					<input type="text" name="name"><br />
					이메일  
					<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="abcd@abcd.com">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="아이디찾기">
					<input type="button" value="닫기" onclick="window.close()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>