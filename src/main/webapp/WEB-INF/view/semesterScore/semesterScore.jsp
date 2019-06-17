<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>학기별 성적 조회</title>
</head>
<body>
	<form action="/FinalProject/selectSemester.do">
		<h2>학기별 성적조회  </h2>
		<select name="selectSemester">
				<option value="#" selected="selected">학기선택</option>
			<c:forEach var="item" items="${semesters }">
				<option value="${item }">${item }</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="조회">
	</form>
	
	<table border="1">
		<tr>
			<th>강의번호</th>
			<th>강의명</th>
			<th>학점</th>
			<th>성적</th>
			<th>성적정정신청</th>
		</tr>
		<c:if test="${dataList.size() == 0 }">
			<td colspan="4">성적이 입력되지 않았습니다.</td>
		</c:if>
		
		<c:if test="${dateList.size() != 0 }">
			<tr>
			<c:forEach var="item" items="${dataList }">
				<tr>
					<td>${item.lecture_num }</td>
					<td>${item.lecture_title }</td>
					<td>${item.lecture_grade }</td>
					<td>${item.score }</td>
					<td><input type="button" value="성적정정신청" 
					onclick="location.href='/FinalProject/changescore/ChangescoreinputInsert.do?lecture_num=${item.lecture_num}'"></td>
				</tr>
			</c:forEach>
			</tr>
			
			<tr>
				<td colspan="3">해당학기 평점</td>
				<td colspan="2">${average }</td>
			</tr>
		</c:if>
		
		<tr>
			<td>
				<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
			</td>
		</tr>
	</table>
	
	
</body>
</html>