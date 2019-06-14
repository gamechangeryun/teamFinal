<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<title>졸업생관리 페이지</title>
</head>
<body>

<h1>졸업생관리</h1>

<form>
		<table border="1">
		
			<tr>
				<td colspan="5">
					<select name="searchContent">
						<option value="0" selected="selected">학과</option>
						<option value="10">정보통신공학과</option>
						<option value="20">신학과</option>
						<option value="30">영문학과</option>
						<option value="40">화학공학과</option>
					</select>
					<input type="submit" value="찾기">
				</td>
			</tr>
			
			<tr>
				<th>학과</th>
				<th>학번</th>
				<th>이름</th>
				<th>평점</th>
			</tr>
			
			<c:if test="${searchList.size() == 0}">
			
				<c:if test="${mainList.size() == 0}">
					<tr>
						<td colspan="5">글이 없습니다.</td>
					</tr>
				</c:if>
			
				<c:if test="${mainList.size() > 0}">
					<tr>
						<c:forEach var="item" items="${mainList}">
						<tr>
							<td>${item.temper_name}</td>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.totalaverage}</td>
						</tr>
						</c:forEach>
					</tr>
				</c:if>
				
			</c:if>
			
			<c:if test="${searchList.size() > 0}">
				<tr>
					<c:forEach var="item" items="${searchList}">
						<tr>
							<td>${item.temper_name}</td>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.totalaverage}</td>
						</tr>
					</c:forEach>
				</tr>
			</c:if>
			
			
			<tr>   
				<td colspan="5">
				<c:if test="${count > 0}">
				   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/><!-- 총 페이지 개수 -->
				   <c:set var="pageBlock" value="${5}"/><!-- [1][2][3][4][5][다음] 이런식으로 나오기 위해서 -->
				   <fmt:parseNumber var="result" value="${currentPage / pageSize}" integerOnly="true" /><!-- 시작페이지를 정해주기 위해서 -->
				   <c:set var="startPage" value="${result * pageSize + 1}" /><!-- 시작페이지 -->
				   <c:set var="endPage" value="${startPage + pageBlock-1}"/><!-- 끝페이지 -->
				   
				   <c:if test="${endPage > pageCount}">
				        <c:set var="endPage" value="${pageCount}"/>
				   </c:if>
				         
				   <c:if test="${startPage > pageSize}">
				        <a href="/FinalProject/gra/graboard.do?pageNum=${startPage - pageSize}">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/gra/graboard.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/gra/graboard.do?pageNum=${startPage + pageSize}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
			
			<tr>
				<td colspan="5">
					<input type="button" value="전체목록" onclick="location.href='/FinalProject/gra/graboard.do'" >
					<input type="button" value="확인" onclick="location.href='/FinalProject/${returnPage}'" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>