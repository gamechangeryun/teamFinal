<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>총학기 성적</title>
</head>
<body>
	<h1>총 학기 성적</h1>
	
	<table border="1">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>전체학기평점</th>
			<th>최대이수학점</th>
			<th>현재이수학점</th>
		</tr>
	
		<c:if test="${dto == null }">
			<tr>
				<td colspan="6">
					<h3><strong>입력된 성적이 없습니다.</strong></h3>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${dto != null }">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.name }</td>
				<td>${dto.temper_name }</td>
				<td>${dto.totalaverage }</td>
				<td>${dto.maxpoint }</td>
				<td>${dto.nowpoint }</td>
			</tr>
		</c:if>
	</table>
	
	<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
</body>
</html>