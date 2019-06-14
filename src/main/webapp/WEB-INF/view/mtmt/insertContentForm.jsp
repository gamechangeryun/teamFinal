<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<title>글 작성</title>
<style>
h2{text-align:center;}
</style>
<script>
	function checkIt(){
		var myform = eval("document.myform");
		
		if(!myform.title.value){
			alert("글제목을 입력하세요");
			return false;
		}
		
		if(!myform.id.value){
			alert("작성자를 입력하세요");
			return false;
		}
		
		if(!myform.content.value){
			alert("글내용을 입력하세요");
			return false;
		}
		
		if(!myform.maxpeople.value){
			alert("최대인원수를 입력하세요")
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<div class="h2">
<h2>게시글 작성</h2>
</div>

<div class="container">
	<form name="myform" action="<%=cp%>/mtmt/insertContent.do" method="post" enctype="multipart/form-data" onsubmit="return checkIt()">
		<input type="hidden" name="num" value="${lastNum}">
		<input type="hidden" name="readcount" value="0">
		<input type="hidden" name="nowpeople" value="0">
		<input type="hidden" name="isnotice" value="0">
		
		<div class="form-group">
			<label for="title">글제목</label>
			<input type="text" class="form-control" id="title" name="title">
		</div>
		<div class="form-group">
			<label for="id">작성자</label>
			<input type="text" class="form-control" id="id" name="id">
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea class="form-control" id="content" name="content" rows="10" cols="50"></textarea>
		</div>
		<div class="form-group">
			<label for="maxpeople">최대인원수</label>
			<input type="number" class="form-control" min="5" max="10" id="maxpeople" name="maxpeople">
		</div>
		<div class="btn-group btn-group-toggle btn-xs" data-toggle="buttons">	
			<label class="btn btn-danger btn-xs">
				<input type="radio" name="position" value="멘토" checked>멘토 
			</label> 
			<label class="btn btn-danger btn-xs">
				<input type="radio" name="position" value="멘티">멘티
			</label>
		</div>
		<div class="form-group">
			<label for="file">파일첨부</label>
			<input type="file" class="form-control" id="file" name="file">
		</div>
		<div>
		<br><br>
		</div>
		<br>
		<div class="form-group">
			<input type="submit" class="btn btn-info btn-xs" value="작성완료">
			<input type="button" class="btn btn-info btn-xs" value="목록으로" onclick="location.href='<%=cp%>/mtmt.do'">
		</div>
		
	</form>
</div>
	
	<%@ include file="bootstrap.jsp" %>
</body>
</html>