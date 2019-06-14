<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>강의개설신청리스트</title>
</head>
<body>
	<h1><strong>강의개설신청서</strong></h1>
	<form id="myform">
		<table border="1">
			<tr>
				<th>정렬번호</th>
				<th>교수명</th>
				<th>학과</th>
				<th>강의명</th>
				<th>학점</th>
				<th>시간코드</th>
				<th>강의실코드</th>
				<th>신청일</th>
				<th colspan="2">허용</th>
			</tr>
			
			<c:if test="${searchList.size() == 0 }">
			
				<c:if test="${mainList.size() == 0}">
					<tr>
						<td colspan="10">글이 없습니다.</td>
					</tr>
				</c:if>
			
				<c:if test="${mainList.size() > 0 }">
					<tr>
						<c:forEach var="item" items="${mainList }">
								<tr id="send">
									<td>${item.rn }</td>
									<td>${item.name }</td>
									<td>${item.temper_name }</td>
									<td>${item.lecture_title }</td>
									<td>${item.lecture_grade }</td>
									<td>${item.timecode }</td>
									<td>${item.roomcode }</td>
									<td><fmt:formatDate var="w_date" value="${item.writedate }" pattern="yyyy-MM-dd"/>${w_date }</td>
									<td><input type="button" value="허용" onclick="location.href='/FinalProject/lectureapplySubmit.do?id=${item.id}&lecture_title=${item.lecture_title }&lecture_grade=${item.lecture_grade }&timecode=${item.timecode }&roomcode=${item.roomcode }&writedate=${w_date }'"></td>
									<td><input type="button" value="취소" onclick="location.href='/FinalProject/lectureapplyRefus.do?id=${item.id}&lecture_title=${item.lecture_title}'"></td>
								</tr>
						</c:forEach>
					</tr>
				</c:if>
				
			<tr>
				<td colspan="10">
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
				        <a href="/FinalProject/lectureapplyList.do?pageNum=${startPage - pageSize }">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/lectureapplyList.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/lectureapplyList.do?pageNum=${startPage + pageSize}">[다음]</a>
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
							<td>${item.name }</td>
							<td>${item.temper_name }</td>
							<td>${item.lecture_title }</td>
							<td>${item.lecture_grade }</td>
							<td>${item.timecode }</td>
							<td>${item.roomcode }</td>
							<td><fmt:formatDate var="w_date" value="${item.writedate }" pattern="yyyy-MM-dd" />${w_date }</td>
							<td><input type="button" value="허용" onclick="location.href='/FinalProject/lectureapplySubmit.do?id=${item.id}&lecture_title=${item.lecture_title }&lecture_grade=${item.lecture_grade }&timecode=${item.timecode }&roomcode=${item.roomcode }&writedate=${w_date }'"></td>
							<td><input type="button" value="취소" onclick="location.href='/FinalProject/lectureapplyRefus.do?id=${item.id}&lecture_title=${item.lecture_title }'"></td>
						</tr>
					</c:forEach>
				</tr>
				
				<tr>
				<td colspan="10">
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
				        <a href="/FinalProject/lectureapplyList.do?pageNum=${startPage - pageSize}&options=${options}&searchContent=${searchContent}">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/lectureapplyList.do?pageNum=${i}&options=${options}&searchContent=${searchContent}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/lectureapplyList.do?pageNum=${startPage + pageSize}&options=${options}&searchContent=${searchContent}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
			</c:if>
			
			<tr>
				<td colspan="10">
					<select name="options">
						<option value="0" selected="selected">강의명</option>
						<option value="1">교수명</option>
					</select>
			
					<input type="text" name="searchContent" value="">
			
					<input type="submit" value="찾기">
					<input type="button" value="전체글보기" onclick="location.href='/FinalProject/lectureapplyList.do'">
					<input type="button" value="뒤로가기" onclick="location.href='/FinalProject/${returnPage}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>