<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생성적정정사유입력</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
function checkIt(){
	var myform = eval("document.myform");
	
	if(!myform.changereason.value){
		alert("내용을 입력하세요")
		return false;
	}
	
	return true;
}
</script>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css">

</head>
<body>

<div class="h2">
<h2>게시글 작성</h2>
</div>
	<c:if test="${confirm == 1 }">
		<script>
			setTimeout(function(){
				alert("이미 성적정정 신청중입니다.");
				location.href='/FinalProject/semesterScore.do';
			}, 100);
		</script>
	</c:if>
<div class="container">
	<form name="myform" action="<%=cp%>/ChangescoreinputInsertPro.do" method="post" onsubmit="return checkIt()">
		<div class="form-group">
			<label for="title">강의번호</label>
			<input type="hidden" name="lecture_num" value=${dto.lecture_num }>
			${dto.lecture_num }
		</div>
		<div class="form-group">
			<label for="id">학번</label>
			<input type="hidden" name="id" value=${dto.id }>
			${dto.id }
		</div>
		<div class="form-group">
			<label for="id">학생이름</label> 
			<input type="hidden" name="name" value=${dto.name }>
			${dto.name }
		</div>
		<div>
			정정신청사유<br>
			<textarea class="form-control" id="changereason" name="changereason" rows="10" cols="50"></textarea>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-info btn-xs" value="작성완료">
			<input type="reset" class="btn btn-info btn-xs" value="취소">
			<input type="button" class="btn btn-info btn-xs" value="메인으로" onclick="location.href='<%=cp%>/${returnPage }'">
		</div>
		
	</form>
</div>
</body>
</html>