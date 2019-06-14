<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>휴강신청자 리스트</title>
</head>
<body>
	<h1><strong>휴강신청자리스트</strong></h1>
	<form>
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>강의번호</th>
				<th>강의명</th>
				<th>교번</th>
				<th>교수명</th>
				<th>학과명</th>
				<th>휴강일자</th>
				<th>보강일자</th>
				<th>휴강이유</th>
				<th>휴강신청일</th>
				<th>허용여부</th>
			</tr>
			
			<c:if test="${searchList.size() == 0 }">
			
				<c:if test="${mainList.size() == 0}">
					<tr>
						<td colspan="11">글이 없습니다.</td>
					</tr>
				</c:if>
			
				<c:if test="${mainList.size() > 0 }">
					<tr>
						<c:forEach var="item" items="${mainList }">
								<tr>
									<td>${item.rn }</td>
									<td>${item.lecture_num }</td>
									<td>${item.lecture_title }</td>
									<td>${item.id }</td>
									<td>${item.name }</td>
									<td>${item.temper_name }</td>
									<td><fmt:formatDate var="c_date" value="${item.canceled_date }" pattern="yyyy-MM-dd"/>${c_date}</td>
									<td><fmt:formatDate var="s_date" value="${item.supply_date }" pattern="yyyy-MM-dd"/>${s_date}</td>
									<td>${item.canceled_reason }</td>
									<td><fmt:formatDate var="r_date" value="${item.applydate }" pattern="yyyy-MM-dd"/>${r_date}</td>

								<td>
									<input type="button" value="허용" onclick="location.href='/FinalProject/canceledlistSubmit.do?lecture_num=${item.lecture_num}&id=${item.id}&canceled_date=${c_date}&supply_date=${s_date }&canceled_reason=${item.canceled_reason } '">
									<input type="button" value="기각" onclick="location.href='/FinalProject//canceledListRefus.do?id=${item.id}'">
								</td>
							</tr>
						</c:forEach>
					</tr>
				</c:if>
				
			<tr>
				<td colspan="11">
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
				        <a href="/FinalProject/canceledList.do?pageNum=${startPage - pageSize }">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/canceledList.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/canceledList.do?pageNum=${startPage + pageSize}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
				
			</c:if>
			
			<c:if test="${searchList.size() > 0 }">
				<tr>
					<c:forEach var="item" items="${searchList }">
						<tr>
							<td>${item.rn }</td>
							<td>${item.lecture_num }</td>
							<td>${item.lecture_title }</td>
							<td>${item.id }</td>
							<td>${item.name }</td>
							<td>${item.temper_name }</td>
							<td><fmt:formatDate var="c_date" value="${item.canceled_date }" pattern="yyyy-MM-dd" />${c_date}</td>
							<td><fmt:formatDate var="s_date" value="${item.supply_date }" pattern="yyyy-MM-dd" />${s_date}</td>
							<td>${item.canceled_reason }</td>
							<td><fmt:formatDate var="r_date" value="${item.applydate }" pattern="yyyy-MM-dd" />${r_date}</td>
							<td>
								<input type="button" value="허용" onclick="location.href='/FinalProject/canceledlistSubmit.do?lecture_num=${item.lecture_num}&id=${item.id}&canceled_date=${c_date}&supply_date=${s_date }&canceled_reason=${item.canceled_reason }'">
								<input type="button" value="기각" onclick="location.href='/FinalProject/canceledListRefus.do?id=${item.id}'">
							</td>
						</tr>
					</c:forEach>
				</tr>
				
				<tr>
				<td colspan="11">
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
				        <a href="/FinalProject/canceledList.do?pageNum=${startPage - pageSize}&options=${options}&searchContent=${searchContent}">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/canceledList.do?pageNum=${i}&options=${options}&searchContent=${searchContent}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/canceledList.do?pageNum=${startPage + pageSize}&options=${options}&searchContent=${searchContent}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
			</c:if>
			
			<tr>
				<td colspan="11">
					<input type="button" value="돌아가기" onclick="location.href='/FinalProject/${returnPage}'" >
				</td>
			</tr>
			
			<tr>
				<td colspan="11">
					<select name="options">
						<option value="0" selected="selected">학번</option>
						<option value="1">학과</option>
						<option value="2">작성자</option>
					</select>
			
					<input type="text" name="searchContent" value="">
			
					<input type="submit" value="찾기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>