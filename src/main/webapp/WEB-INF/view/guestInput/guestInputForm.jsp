<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게스트 글 쓰기 신청페이지</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myform");
		
		if(!thisForm.title.value){
			alert("제목을 입력하세요");
			return false;
		}
		
		if(!thisForm.name.value){
			alert("이름을 입력하세요");
			return false;
		}
		
		if(!thisForm.phone.value){
			alert("전화번호를 입력하세요");
			return false;
		}
		
		if(!thisForm.email.value){
			alert("이메일을 입력하세요");
			return false;
		}
		
		if(!thisForm.reason.value){
			alert("사유를 입력하세요");
			return false;
		}
		
		if(thisForm.selectBoard.value == 0){
			alert("게시판을 선택하세요");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<form name="myform" method="post" enctype="multipart/form-data" onsubmit="return checkIt()">
		<input type="hidden" name="id" value="${nowId }">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
				
				<td>이름</td>
				<td><input type="text" name="name"></td>
				
				<td>
					<select name="selectBoard">
						<option value="0">게시판선택</option>
						<option value="1">멘토멘티게시판</option>
						<option value="2">취업게시판</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>전화번호</td>
				<td><input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="000-0000-0000"></td>
				<td>이메일</td>
				<td><input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="abcd@abcd.com"></td>
			</tr>
	
			<tr>
				<td >사유</td>
				<td colspan="4">
					<textarea rows="5" cols="70"  name="reason"></textarea>
				</td>
			</tr>	
			
			<tr>
				<td>파일첨부</td>
				<td colspan="4"><input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>