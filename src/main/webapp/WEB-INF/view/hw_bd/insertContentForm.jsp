<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>글 작성</title>
<script>
	function checkIt(){
		var myform = eval("document.myform");
		
		if(!myform.homework_title.value){
			alert("과제명을 입력하세요");
			return false;
		}
		if(!myform.file.value){
			alert("첨부파일을 입력하세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<form name="myform" action="/FinalProject/hw_bd/insertContent.do" method="post" enctype="multipart/form-data" onsubmit="return checkIt()">
		<input type="hidden" name="id" value="${nowId}">
		<input type="hidden" name="homework_sub" value="0">
		<table border="1">
				<tr>
					<td>글제목</td> 
					<td><input type="text" name="homework_title"></td>
				</tr>
				<tr>
					<td>강의번호</td>
					<td>
					<select name="lecture_num">
						<option value="0" selected="selected">번  호</option>
						<option value="1">101</option>
						<option value="2">102</option>
					</select>
				</tr>
				
				<tr>
					<td>파일첨부</td> 
					<td colspan="3">
					<input type="file" name="file"></td>
			
				</tr>
				
				<tr>
					<td colspan="4">
					<input type="button" value="작성취소" onclick="location.href='/FinalProject/hw_bd/board.do'">
					<input type="submit" value="작성완료"></td>
				</tr>
		</table>
	</form>
</body>
</html>