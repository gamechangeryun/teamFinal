<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>복학신청</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myform");
		
		if(!thisForm.startreindate.value){
			alert("복학날짜를 입력하세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1>복학신청</h1>
	
	<c:if test="${confirm == 1 }">
		<script>
			setTimeout(function(){
				alert("이미 복학신청을 한 상태입니다.");
				location.href="/FinalProject/${returnPage }"
			}, 100);
		</script>
	</c:if>
	
	<c:if test="${confirm == 2 }">
		<script>
			setTimeout(function(){
				alert("휴학생이 아닙니다");
				location.href="/FinalProject/${returnPage }"
			}, 100);
		</script>
	</c:if>
	
	<form name="myform" action="/FinalProject/reinApply.do" onsubmit="return checkIt()">
		
		<h3>복학날짜</h3>
		<input type="date" name="startreindate">
		
		<input type="submit" value="제출">
		<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
	</form>
</body>
</html>