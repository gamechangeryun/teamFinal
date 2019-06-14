<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>장학금</title>
</head>
<body>
	<form action="/FinalProject/scholarshipSelect.do">
		<select name="temper">
			<option value="0">학과선택</option>
			<option value="10">정보통신공학과</option>
			<option value="20">박준희학과</option>
		</select> 
		<input type="submit" value="조회">


		<table border="5">
			<tr>
				<th>학번</th>
				<th>학과</th>
				<th>이름</th>
				<th>장학금명</th>
				<th>장학금액</th>
				<th>장학금번호</th>
				<th>장학금받은학기</th>
			</tr>

			<tr>
				<c:if test="${scholarship.size() == 0 }">
					<td colspan="7"><strong>장학금 수상내역이 없습니다.</strong>
					<td>
				</c:if>

				<c:if test="${scholarship.size() != 0 }">
					<c:forEach var="item" items="${scholarship }">
						<tr>
							<td>${item.id }</td>
							<td>${item.temper_name }</td>
							<td>${item.name }</td>
							<td>${item.scholarship_name }</td>
							<td>${item.scholarship_money }</td>
							<td>${item.scholarship_num }</td>
							<td>${item.scholarship_semester }</td>
						</tr>
					</c:forEach>
				</c:if>
			</tr>

			<c:if test="${check == 1 }">
				<tr>
					<td colspan="7"><c:if test="${count > 0}">
							<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" /><!-- 총 페이지 개수 -->
							<c:set var="pageBlock" value="${5}" /><!-- [1][2][3][4][5][다음] 이런식으로 나오기 위해서 -->
							<fmt:parseNumber var="result" value="${currentPage / pageSize}" integerOnly="true" /><!-- 시작페이지를 정해주기 위해서 -->
							<c:set var="startPage" value="${result * pageSize + 1}" /><!-- 시작페이지 -->
							<c:set var="endPage" value="${startPage + pageBlock-1}" /><!-- 끝페이지 -->

							<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>

							<c:if test="${startPage > pageSize}">
								<a href="/FinalProject/scholarship.do?pageNum=${startPage - pageSize }">[이전]</a>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<a href="/FinalProject/scholarship.do?pageNum=${i}">[${i}]</a>
							</c:forEach>

							<c:if test="${endPage < pageCount}">
								<a href="/FinalProject/scholarship.do?pageNum=${startPage + pageSize}">[다음]</a>
							</c:if>
						</c:if></td>
				</tr>
			</c:if>

			<c:if test="${check == 2 }">
				<tr>
					<td colspan="7"><c:if test="${count > 0}">
							<c:set var="pageCount"
								value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" /><!-- 총 페이지 개수 -->
							<c:set var="pageBlock" value="${5}" /><!-- [1][2][3][4][5][다음] 이런식으로 나오기 위해서 -->
							<fmt:parseNumber var="result" value="${currentPage / pageSize}"
								integerOnly="true" /><!-- 시작페이지를 정해주기 위해서 -->
							<c:set var="startPage" value="${result * pageSize + 1}" /><!-- 시작페이지 -->
							<c:set var="endPage" value="${startPage + pageBlock-1}" /><!-- 끝페이지 -->

							<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>

							<c:if test="${startPage > pageSize}">
								<a href="/FinalProject/scholarshipSelect.do?pageNum=${startPage - pageSize }">[이전]</a>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<a href="/FinalProject/scholarshipSelect.do?pageNum=${i}">[${i}]</a>
							</c:forEach>

							<c:if test="${endPage < pageCount}">
								<a href="/FinalProject/scholarshipSelect.do?pageNum=${startPage + pageSize}">[다음]</a>
							</c:if>
						</c:if>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td>
					<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
					<input type="button" value="전체리스트" onclick="location.href='/FinalProject/scholarship.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>