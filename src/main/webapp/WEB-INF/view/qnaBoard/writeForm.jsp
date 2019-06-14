<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String cp = request.getContextPath(); //첫번째 경로(프로젝트명)을 가지고 옴
	request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지
%>
<html>
<head>
<title>게시판</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>

	function checkIt() {
		var myForm = eval("document.writeForm");

		if(!myForm.title.value) {
			alert("글제목을 입력하세요");
			return false;
		}

		if(!myForm.id.value) {
			alert("id를 입력하세요");
			return false;
		}

		if(!myForm.content.value) {
			alert("글내용을 입력하세요");
			return false;
		}
		
		if(!myForm.isnotice.value) {
			alert("공지글 여부를 확인해주세요.");
			return false;
		}

		return true;
	}
</script>
</head>
<h2>글쓰기</h2>
<form name="writeForm" method="post" action="/FinalProject/qna/writePro.do" enctype="multipart/form-data" onsubmit="return checkIt()">
	<input type="hidden" name="id" value="${id }">
	<table>
		<tr>
			<td>글제목</td>
			<td colspan="2"><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td colspan="2"><textarea rows="10" cols="50" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td>파일</td>
			<td><input type="file" name="file"></td>
		<tr>
		<tr>
			<td>공지글</td>
			<td><select name="isnotice">
				<option value="0" selected="selected">일반글</option>
				<option value="1">중요글</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="4"><input type="button" value="목록으로" onclick="location.href='/FinalProject/qna/list.do'"> 
			<input type="submit" value="작성완료">
			</td>
		</tr>
	</table>
</form>
</body>
</html>