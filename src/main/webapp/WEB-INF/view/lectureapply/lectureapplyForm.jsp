<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>강의개설신청서</title>
<script>
	function checkIt(){
		var thisForm = eval("document.myform");
		
		if(!thisForm.lecture_title.value){
			alert("강의명을 입력하세요");
			return false;
		}
		
		if(!thisForm.lecture_grade.value){
			alert("학점을 입력하세요");
			return false;
		}
		
		if(!thisForm.roomcode.value){
			alert("강의실번호를 입력하세요");
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
				<td>강의명</td>
				<td><input type="text" name="lecture_title"></td>
				
				<td>학점</td>
				<td>
					<select name="lecture_grade">
						<option value="1" selected="selected">1학점</option>
						<option value="2">2학점</option>
						<option value="3">3학점</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>강의실</td>
				<td colspan="3">
					시간코드
					<input type="text" name="timecode">
					강의실코드
					<input type="text" name="roomcode">
					<input type="button" value="강의실조회" onclick="">
				</td>
			</tr>
			
			<tr>
				<td colspan="4">
					<input type="submit" value="전송">
					<input type="button" value="뒤로가기" onclick="location.href='/FinalProject/${returnPage}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>