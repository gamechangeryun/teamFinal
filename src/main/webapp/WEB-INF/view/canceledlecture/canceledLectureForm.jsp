<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>휴강신청</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myform");
		
		if(thisForm.lecture_num.value == "#"){
			alert("과목을 선택해주세요");
			return false;
		}
		
		if(!thisForm.canceled_date.value){
			alert("휴강일시를 입력하세요");
			return false;
		}
		
		if(!thisForm.supply_date.value){
			alert("보강일시를 입력하세요");
			return false;
		}
		
		if(!thisForm.canceled_reason.value){
			alert("휴강사유를 입력하세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1>휴강신청</h1>
	<form name="myform" action="/FinalProject/canceledlecture.do" method="post" onsubmit="return checkIt()">
		<select name="lecture_num">
			<option value="#" selected="selected">과목선택</option>
			<c:forEach var="item" items="${lectureList }">
				<option value="${item.lecture_num }">${item.lecture_title }</option>
			</c:forEach>
		</select>
		
		<input type="hidden" name="id" value="${id }">
		
		<h3>휴강일시</h3>
		<input type="date" name="canceled_date">

		<h3>보강일시</h3>
		<input type="date" name="supply_date">
		
		<h3>휴강사유</h3>
		<textarea rows="10" cols="50" name="canceled_reason"></textarea>	
		<p></p>
		
		<input type="submit" value="제출">
		<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
	</form>
</body>
</html>