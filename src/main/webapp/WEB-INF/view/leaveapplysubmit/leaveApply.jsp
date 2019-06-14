<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>휴학신청</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myform");
		
		if(thisForm.reason.value == "#"){
			alert("휴학분류를 선택하세요");
			return false;
		}
		
		if(!thisForm.startleavedate.value){
			alert("휴학시작날짜를 입력하세요");
			return false;
		}
		
		if(!thisForm.endleavedate.value){
			alert("휴학끝날짜를 입력하세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1>휴학신청</h1>
	
	<c:if test="${confirm == 1 }">
		<script>
			setTimeout(function(){
				alert("이미 휴학신청을 한 상태입니다.");
				location.href="/FinalProject/${returnPage }"
			}, 100);
		</script>
	</c:if>
	
	<c:if test="${confirm == 2 }">
		<script>
			setTimeout(function(){
				alert("이미 휴학한 상태 입니다.");
				location.href="/FinalProject/${returnPage }"
			}, 100);
		</script>
	</c:if>
	
	<form name="myform" action="/FinalProject/leaveApply.do" onsubmit="return checkIt()">
		<input type="hidden" name="id" value="${nowId }">
		
		<h3>휴학분류</h3>
		<select name="reason">
			<option value="#" selected="selected">휴학분류</option>
			<option value="1">일반휴학</option>
			<option value="2">군휴학</option>
		</select>
		
		<h3>휴학시작날짜</h3>
		<input type="date" name="startleavedate">
		
		<h3>휴학끝날짜</h3>
		<input type="date" name="endleavedate">
		
		<input type="submit" value="제출">
	</form>
</body>
</html>