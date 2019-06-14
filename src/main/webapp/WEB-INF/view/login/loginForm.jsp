<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인 메인 페이지</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myForm");
		
		if(!thisForm.id.value){
			alert("ID를 입력하세요");
			return false;
		}
		
		if(!thisForm.password.value){
			alert("PW를 입력하세요");
			return false;
		}
		
		return true;
	}
	
	function searchId(){
		// url과 사용자 입력 id를 조회합니다.
		url = "/FinalProject/searchIdForm.do"
		
		// 새로운 윈도우를 엽니다.
		open(url, "confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
	}
	
	function searchPw(){
		// url과 사용자 입력 id를 조회합니다.
		url = "/FinalProject/searchPwForm.do"
		
		// 새로운 윈도우를 엽니다.
		open(url, "confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300,height=200");
	}
</script>
</head>
<body>
	<h1><strong>로그인 메인 페이지입니다</strong></h1>
	
	<c:if test="${confirm == 1 }">
		<script>
			setTimeout(function(){
				alert("비밀번호가 틀렸습니다.");
				location.href="/FinalProject/start.do"
			}, 100);
		</script>
	</c:if>
	
	<c:if test="${confirm == 2 }">
		<script>
			setTimeout(function(){
				alert("아이디가 틀렸습니다.");
				location.href="/FinalProject/start.do"
			}, 100);
		</script>
	</c:if>
	
	<form action="/FinalProject/login.do" method="post" name="myForm" onsubmit="return checkIt()">
		<table border="1">
			<tr>
				<td>
					로그인  &nbsp;&nbsp;
					<input type="text" name="id"><br />
					비밀번호  
					<input type="password" name="password">
				</td>
				<td>
					<input type="submit" value="로그인">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<a href="#" onclick="searchId()"><strong>아이디 찾기</strong></a>
					<a href="#" onclick="searchPw()"><strong>비밀번호 찾기</strong></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>