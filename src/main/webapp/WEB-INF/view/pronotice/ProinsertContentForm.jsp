<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>글 작성</title>
<script>
	function checkIt(){
		var myform = eval("document.myform");
		
		if(!myform.title.value){
			alert("글제목을 입력하세요");
			return false;
		}

		if(!myform.content.value){
			alert("글내용을 입력하세요");
			return false;
		}
		
		if(!myform.lecture_num.value){
			alert("강의번호를 입력하세요");
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
		<form name="myform" action="<%=cp%>/ProinsertContent.do" method="post" onsubmit="return checkIt()">
			
			<div class="form-group">
				<label for="title">글제목</label>
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="id">강의번호</label>
				<input type="text" class="form-control" id="lecture_num" name="lecture_num">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="content" rows="10" cols="50"></textarea>
			</div>
			<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
				  <div class="btn-group" role="group">
					<select name="isnotice" class="btn btn-secondary dropdown-toggle">
						<option value="0" selected="selected">일반글</option>
						<option value="1" class="btn btn-secondary">중요글</option>
					</select>
					<input type="submit" class="btn btn-primary btn-xs" value="작성완료">
					<input type="button" class="btn btn-primary btn-xs" value="목록으로" onclick="location.href='<%=cp%>/PronoticeboardMain.do'">
				  </div>
			</div>		
		</form>
	</div>
</body>
</html>