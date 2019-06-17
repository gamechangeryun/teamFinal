<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>강의리스트</title>
</head>
<body>
	<h1>강의리스트</h1>
	
	<table border="2">
		<tr>
			<th>강의번호</th>
			<th>강의명</th>
			<th>학점</th>
			<th>학기</th>
			<th>시간코드</th>
			<th>강의실코드</th>
			<th>강의실게시판</th>
		</tr>
		
		<c:if test="${lectureList.size() == 0 }">
			<tr>
				<td>
					<strong>조회된 강의가 없습니다.</strong>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${lectureList.size() != 0 }">
			<c:forEach var="item" items="${lectureList }">
				<tr>
					<td>${item.lecture_num }</td>
					<td>${item.lecture_title }</td>
					<td>${item.lecture_grade }</td>
					<td>${item.semester }</td>
					<td>${item.timecode }</td>
					<td>${item.roomcode }</td>
					<td><input type="button" value="강의게시판이동" onclick="location.href='/FinalProject/pro/promain.do?lecture_num=${item.lecture_num }'"></td>
				</tr>
			</c:forEach>
		</c:if>
		
		<tr>
			<td>
				<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
			</td>
		</tr>
	</table>
</body>
</html>