<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 보기</title>
<!-- jquery js파일 추가 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#confirmContent").click(function(){
		var title = $("#title").val();
		var content = $("#content").val();
		if(title == "") {
			alert("제목을 입력하세요.");
			document.showContent.title.focus();
			return;
		}
		if(content == "") {
			alert("내용을 입력하세요.");
			document.showContent.content.focus();
			return;
		}
		document.modifyContent.action="<%=cp%>/anon/modifyContent.do";
		document.modifyContent.submit();
	})
})
function goList() {
	location.href="<%=cp%>/anon/list.do?page=1";
}
</script>
</head>
<body>
	<h2>게시글 수정</h2>
	<hr>
	<form name="modifyContent" id="modifyContent" method="post">
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>${content.num}</th>
			</tr>
			<tr>
				<th>제목</th>
				<th>
					<input type="text" name="title" id="title"
					value="${content.title}">
				</th>
			</tr>
			<tr>
				<th>내용</th>
				<th>
					<textarea id="content" name="content" rows="5" cols="20">${content.content}</textarea>
				</th>
			</tr>
		</table>
		<input type="hidden" id="num" name="num" value="${content.num}">
		<button type="button" id="confirmContent">확인</button>
		<input type="button" value="목록으로 " onclick="goList();">
	</form>
	

</body>
</html>