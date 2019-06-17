<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>수정 폼</title>
<script>
	function checkIt(){
		var myform = eval("document.myform");
		
		if(!myform.homework_title.value){
			alert("글제목을 입력하세요");
			return false;
		}
		if(!myform.file.value){
			alert("파일을 올리세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1><strong>글 수정하기</strong></h1>
	<form name="myform" action="/FinalProject/hw_bd/updateContent.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${nowId}">
		<input type="hidden" name="num" value="${detailContent.homework_num}">
	
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${detailContent.rn}</td>
				<td>글제목</td> 
				<td><input type="text" name="title" value="${detailContent.homework_title}"></td>
			</tr>
			
			<tr>
				<td>파일</td>   
				<td colspan="2"><input type="file" name="file" value="${path}"></td>
			</tr>
			   
			<tr>   
				<td colspan="7">
					<input type="button" value="목록으로" onclick="location.href='/FinalProject/hw_bd/board.do'">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>