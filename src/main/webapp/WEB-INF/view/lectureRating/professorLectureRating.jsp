<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>교수 강의평가 확인</title>
</head>
<body>
	<form action="/FinalProject/selectLecture.do">
		<h3>강의평가확인 과목선택</h3>
		<select name="selectLecture">
				<option value="#" selected="selected">강의선택</option>
			<c:forEach var="item" items="${LectureList }">
				<option value="${item.lecture_num }">${item.lecture_title }</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="조회">
	</form>
	
	<h2>평균 : </h2>
	<h2>${average }</h2>
	
	<h2>교수님께 하고 싶은 말</h2>
	<c:forEach var="item" items="${comment }">
		${item.totalcomment }
		<p>
	</c:forEach>

	<input type="button" value="뒤로가기" onclick="location.href='/FinalProject/${returnPage }">
</body>
</html>