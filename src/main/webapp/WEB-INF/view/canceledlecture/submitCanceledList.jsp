<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>휴강허용리스트</title>
</head>
<body>
	<h1>휴강허용리스트 : ${count }</h1>
	<table border="1">
		<tr>
			<th>강의번호</th>
			<th>강의명</th>
			<th>휴강일시</th>
			<th>보강일시</th>
			<th>휴강사유</th>
		</tr>
		
		<c:if test="${CanceledList.size() == 0 }">
			<tr>
				<td colspan="5">
					<h4><strong>휴강내역이 없습니다.</strong></h4>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${CanceledList.size() != 0 }">
			<tr>
				<c:forEach var="item" items="${CanceledList }">
					<tr>
						<td>${item.lecture_num }</td>
						<td>${item.lecture_title }</td>
						<td><fmt:formatDate value="${item.canceled_date }" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${item.supply_date }" pattern="yyyy-MM-dd"/></td>
						<td>${item.canceled_reason }</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if>
		
		
		<tr>
			<td colspan="5">
				<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
			</td>
		</tr>
	</table>
</body>
</html>