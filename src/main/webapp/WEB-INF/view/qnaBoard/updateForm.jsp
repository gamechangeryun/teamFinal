<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String cp = request.getContextPath(); //첫번째 경로(프로젝트명)을 가지고 옴
	request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지
%>
<html>
<head>
<title>글 수정하기</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>

	function checkIt() {
		var myForm = eval("document.updateForm");

		if(!myForm.title.value) {
			alert("글제목을 입력하세요");
			return false;
		}

		if(!myForm.id.value) {
			alert("id를 입력하세요");
			return false;
		}

		if(!myForm.content.value) {
			alert("글내용을 입력하세에요");
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
<body>
<form name="updateForm" action="/FinalProject/qna/updatePro.do" enctype="multipart/form-data" method="post" onsubmit="return checkIt()">
	<table border="1">
		<tr>
			<td>글번호</td>
			<td><input type="text" name="num" value="${list.num}" readonly></td>
			<td>글제목</td>
			<td><input type="text" name="title" value="${list.title}"></td>
		</tr>
		<tr>
			<td>id</td>
			<td><input type="text" name="id" value="${list.id}"></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td colspan="3"><textarea rows="5" cols="60" name="content">${list.content}</textarea></td>
		</tr>
		<tr>
			<td>파일첨부</td>   
			<td colspan="2"><input type="file" name="file"></td>
		</tr>
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