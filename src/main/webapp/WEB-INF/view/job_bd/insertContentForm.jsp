<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			alert("글내용을 입력하세에요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<form name="myform" action="/FinalProject/job_bd/insertContent.do" method="post" enctype="multipart/form-data" onsubmit="return checkIt()">
		<input type="hidden" name="id" value="${nowId}">
		<input type="hidden" name="readcount" value="0">
		<table border="1">
				<tr>
					<td>글제목</td> 
					<td><input type="text" name="title"></td>
					<td>
						<select name="isnotice">
							<option value="0" selected="selected">일반글</option>
							<option value="1">중요글</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><h5>글내용작성</h5></td>
					<td colspan="3"><textarea rows="20" cols="100" name="content" >
					</textarea></td>
				</tr>
				
				<tr>
					<td>파일첨부</td> 
					<td colspan="3">
					<input type="file" name="file"></td>
			
				</tr>
				
				<tr>
					<td colspan="4">
					<input type="button" value="작성취소" onclick="location.href='/FinalProject/job_bd/board.do'">
					<input type="submit" value="작성완료"></td>
				</tr>
		</table>
	</form>
</body>
</html>