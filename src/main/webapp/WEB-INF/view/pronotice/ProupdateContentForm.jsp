<%@ page contentType="text/html; charset=UTF-8"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>글 수정</title>
<script>
	function checkIt(){
		var myform = eval("document.myform");
		
		if(!myform.subject.value){
			alert("글제목을 입력하세요");
			return false;
		}
	
		if(!myform.content.value){
			alert("글내용을 입력하세에요");
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h1><strong>글 수정하기</strong></h1>
	<form name="myform" action="<%=cp %>/ProupdateContent.do" method="post" onsubmit="return checkIt()">
		<input type="hidden" name="id" value="${nowId }">
		<input type="hidden" name="readcount" value="${detailContent.readcount }">
		<input type="hidden" name="num" value="${detailContent.num }">
		<input type="hidden" name="writedate" value="${detailContent.writedate }">
		
		<div class="form-group">
			<label for="title">글번호</label>
			<input type="text" readonly class="form-control" value="${detailContent.rn }">
		</div>
		<div class="form-group">
			<label for="title">글제목</label>
			<input type="text" class="form-control" name="title" value="${detailContent.title }">
		</div>
		<div class="form-group">
			<label for="id">강의번호</label>
			<input type="text" class="form-control" id="lecture_num" name="lecture_num" value="${detailContent.lecture_num }">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" id="content" name="content" rows="10" cols="50">${detailContent.content }</textarea>
		</div>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
			  <div class="btn-group" role="group">
				<select name="isnotice" class="btn btn-secondary dropdown-toggle">
					<option value="0" selected="selected">일반글</option>
					<option value="1" class="btn btn-secondary">중요글</option>
				</select>
				<input type="button" class="btn btn-primary btn-xs" value="목록으로" onclick="location.href='<%=cp%>/PronoticeBoardMain.do'">
				<input type="submit" class="btn btn-primary btn-xs" value="수정">
			  </div>
		</div>	
	</form>
	</div>
</body>
</html>