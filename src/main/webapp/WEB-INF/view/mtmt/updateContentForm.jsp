<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>글 상세보기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "<%=cp%>/mtmt/deleteContent.do";
			document.form1.submit();
		}
	});
	
	$("#btnList").click(function(){
		document.form1.action = "<%=cp%>/mtmt/mtmtlist.do";
		document.form1.submit();
	});
	
	$("#btnUpdate").click(function(){
		var title = $("#title").val();
		var content = $("#content").val();
		if(title == ""){
			alert("제목을 입력하세요");
			document.form1.title.focus();
			return;
		}
		if(content == ""){
			alert("내용을 입력하세요");
			document.form1.content.focus();
			return;
		}
		document.form1.action="<%=cp%>/mtmt/updateContent.do";
		document.form1.submit();
	});
});

</script>	
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css">

</head>
<body>
	<div class="container">
	<h1><strong>글 수정하기</strong></h1>
		<form name="form1" method="post" enctype="multipart/form-data">
		
		<div class="form-group">
			<label for="num">글번호</label>
			<input type="text" readonly name="num" class="form-control" value="${detailContent.num }">
		</div>
		<div class="form-group">
			<label for="readcount">조회수</label>
			<input type="text" readonly class="form-control" name="readcount" value="${detailContent.readcount }">
		</div>
		<div class="form-group">
			<label for=id>작성자</label>
			<input type="text" readonly name="id" class="form-control" value="${detailContent.id }">
		</div>
		<div class="form-group">
			<label for="writedate">작성일</label>
			<fmt:formatDate value="${detailContent.writedate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</div>
		<div class="form-group">
			<label for="title"><strong>글제목</strong></label>
			<input type="text" class="form-control" name="title" value="${detailContent.title }">
		</div>
		<div class="form-group">
			<label for="content"><strong>내용</strong></label>
			<textarea class="form-control" id="content" name="content" rows="10" cols="50">${detailContent.content }</textarea>
		</div>
		<div class="form-group">
			<label for=id>최대인원설정</label>
			<input type="number" class="form-control" max="10" id="maxpeople" name="maxpeople" value="${detailContent.maxpeople }">
		</div>
		<div class="form-group">
			<label for=id>파일첨부</label>
			<input type="file" name="file" class="form-control">
		</div>
		<div class="form-group">
			<input type="hidden" name="num" value="${detailContent.num }">
			<button type="button" id="btnUpdate" class="btn btn-primary btn-xs">수정</button>
			<button type="button" id="btnDelete" class="btn btn-primary btn-xs">삭제</button>
			<button type="button" id="btnList" class="btn btn-primary btn-xs">글목록으로</button>
		</div>
		</form>			
	</div>	
</body>
</html>