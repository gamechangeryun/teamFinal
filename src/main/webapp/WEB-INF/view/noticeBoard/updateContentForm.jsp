<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>수정 폼</title>
<script>
	function checkIt(){
		var myform = eval("document.myform");
		
		if(!myform.subject.value){
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
	<h1><strong>글 수정하기</strong></h1>
	<form name="myform" action="/FinalProject/updateContent.do" method="post" enctype="multipart/form-data" onsubmit="return checkIt()">
		<input type="hidden" name="id" value="${nowId }">
		<input type="hidden" name="readcount" value="${detailContent.readcount }">
		<input type="hidden" name="num" value="${detailContent.num }">
		<input type="hidden" name="writedate" value="${detailContent.writedate }">
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${detailContent.rn }</td>
				<td>글제목</td> 
				<td><input type="text" name="title" value="${detailContent.title }"></td>
				<td>
						<select name="isnotice">
							<option value="0" selected="selected">일반글</option>
							<option value="1">중요글</option>
						</select>
				</td>
			</tr>
				
			<tr>
				<td><h5>글내용</h5></td>
				<td colspan="7"><textarea rows="5" cols="70" name="content">${detailContent.content }</textarea></td>
			</tr>
			
			<tr>
				<td>파일첨부</td>   
				<td colspan="2"><input type="file" name="file"></td>
			</tr>
			   
			<tr>   
				<td colspan="7">
					<input type="button" value="목록으로" onclick="location.href='/FinalProject/noticeBoardMain.do'">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>