<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 쓰기</title>
<!-- jquery js파일 추가 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#confirmContent").click(function(){
		var title = $("#title").val();
		var content = $("#content").val();
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		if(title == "") {
			alert("제목을 입력하세요.");
			document.insertContent.title.focus();
			return;
		}
		if(content == "") {
			alert("내용을 입력하세요.");
			document.insertContent.content.focus();
			return;
		}
		if(id == "") {
			alert("ID를 입력하세요.");
			document.insertContent.id.focus();
			return;
		}
		if(writer == "") {
			alert("writer를 입력하세요.");
			document.insertContent.id.focus();
			return;
		}
		document.insertContent.action="<%=cp%>/anon/insertContent.do";
		document.insertContent.submit();
	})
})
function goList() {
	location.href="<%=cp%>/anon/list.do?page=1";
}
</script>
</head>
<body>
<h2>게시글 쓰기</h2>
<hr>
<form name="insertContent" id="contentForm" method="post">
<table border="1" >
	<tr>
		<th>제목</th>
		<th>
			<input type="text" name="title" id="title" placeholder="제목을 입력해주세요.">
		</th>
	</tr>
	<tr>
		<th>내용</th>
		<th>
			<textarea id="content" name="content" rows="5" cols="20" placeholder="내용을 입력해주세요"></textarea>
		</th>
	</tr>
	<tr>
		<th>id</th>
		<th>
			<input type="text" name="id" id="id" placeholder="id를 입력해주세요.">
		</th>
	</tr>
	
	<tr>
		<th>writer</th>
		<th>
			<input type="text" name="writer" id="writer" placeholder="writer를 입력해주세요">
		</th>
	</tr>
</table>
<input type="hidden" id="isnotice" name="isnotice" value="0">
<!-- <input type="submit" value="확인" onclick="confirmContent();"> -->
<button type="button" id="confirmContent">확인</button>
<input type="reset" value="다시쓰기">
<input type="button" value="목록으로 " onclick="goList();"> 
</form>
</body>
</html>