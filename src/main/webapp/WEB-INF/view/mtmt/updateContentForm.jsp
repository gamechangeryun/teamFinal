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

</head>
<body>
	<form name="form1" method="post" enctype="multipart/form-data">
	<div class="container">
		<table class="table table-striped">
			<tr>
				<td>글번호</td>
				<td>${detailContent.num }</td>
				<td>글제목</td> 
				<td><input type="text" name="title" id="title" value="${detailContent.title }"></td>
				<td>조회수</td> 
				<td>${detailContent.readcount }</td>
			</tr>
				
			<tr>
				<td>작성자</td> 
				<td>${detailContent.id }</td>
				<td>작성일</td>
				<td><fmt:formatDate value="${detailContent.writedate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
				
			<tr>
				<td><h5>글내용</h5></td>
				<td colspan="5"><textarea rows="5" cols="70" name="content" id="content">${detailContent.content }</textarea></td>
			</tr>
			
			<tr>
				<td>최대인원수</td>
				<td><input type="number" class="form-control" min="5" max="10" id="maxpeople" name="maxpeople" value="${detailContent.maxpeople }"></td>
			</tr>
			
			<tr>
				<td>파일첨부</td>   
				<td colspan="2"><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="num" value="${detailContent.num }">
				<button type="button" id="btnUpdate" class="btn btn-info btn-xs">수정</button>
				<button type="button" id="btnDelete" class="btn btn-info btn-xs">삭제</button></td>
				<td><button type="button" id="btnList" class="btn btn-info btn-xs">글목록으로</button></td>
			</tr>
			
		</table>
	</div>	
	</form>
	<%@ include file="bootstrap.jsp" %>
</body>
</html>