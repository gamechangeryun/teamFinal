<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
		document.form1.action="<%=cp%>/mtmt/updateContentForm.do";
		document.form1.submit();
	});
});
</script>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css">

</head>
<body>
	<form name="form1" method="post">
	<div class="container">
		<table class="table table-striped">
			<tr class="table-primary">
				<td>글번호 : ${detailContent.num }</td>
				<td>작성일 : <fmt:formatDate value="${detailContent.writedate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr class="table-success">
				<td>제목 : ${detailContent.title }</td>
				<td>작성자 : ${detailContent.id }</td>
			</tr>
			<tr class="table-success">
				<td>파일</td> 
				<c:if test="${name == null }">
					<td colspan="2">첨부파일이 없습니다.</td>
				</c:if>
				
				<c:if test="${name != null }">
					<td colspan="2"><a href="<%=cp%>/mtmt/fileDownload.do?num=${detailContent.num }">${name }</a></td>
				</c:if>
			</tr>	
			<tr class="table-success">
				<td colspan="2">글내용 : ${detailContent.content }</td>
			</tr>
			<tr class="table-warning">
				<td colspan="2">신청인원수 :<span id="nowpeople"></span>/ ${detailContent.maxpeople }</td>
			</tr>
			<tr class="table-active">
				<td colspan="2"><input type="hidden" name="num" value="${detailContent.num }">
				<button type="button" id="btnUpdate" class="btn btn-info btn-xs">수정</button>
				<button type="button" id="btnDelete" class="btn btn-info btn-xs">삭제</button>
				<button type="button" id="btnList" class="btn btn-info btn-xs">글목록으로</button></td>
			</tr>
		</table>
		</div>
	</form>
	
	<!--멘토멘티신청jsp  -->
	<%@ include file="mtmtRequestMain.jsp" %>
	<!--댓글jsp  -->
	<%@ include file="ex_comment.jsp" %>		
	
			
</body>

</html>