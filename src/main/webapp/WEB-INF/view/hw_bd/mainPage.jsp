<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<title>과제 제출 게시판</title>
</head>
<body>
	<h1>과제 제출 게시판</h1>
	<form>
		<table border="1">
			<tr>
				<th>과제번호</th>
				<th>강의번호</th>
				<th>과제명</th>
				<th>제출자</th>
				<th>제출여부</th>
				<th>제출기간</th>
			</tr>

			<c:if test="${searchList.size() == 0}">

				<c:if test="${mainList.size() == 0}">
					<tr>
						<td colspan="6">글이 없습니다.</td>
					</tr>
				</c:if>

				<c:if test="${mainList.size() > 0}">
					<tr>
						<c:forEach var="item" items="${mainList}">
								<tr>
									<td><strong>${item.rn}</strong></td>
									<td><strong>${item.lecture_num}</strong></td>
									<td><strong><a href="/FinalProject/hw_bd/detailContent.do?num=${item.homework_num}">${item.homework_title}</a></strong></td>
									<td><strong>${item.name}</strong></td>
									<td><strong>${item.homework_sub}</strong>
									<c:if test="${position == 1}">
									<strong>
									<input type="button" value="제출확인"	onclick="location.href='/FinalProject/hw_bd/hwsubon.do?num=${item.homework_num}'">
									</strong>
									</c:if>
									</td>
									<td><strong><fmt:formatDate	value="${item.homework_date}" pattern="yyyy-MM-dd" /></strong></td>
									
								</tr>
						</c:forEach>
					</tr>
				</c:if>
<tr>
				<td colspan="6">
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
				        <a href="/FinalProject/hw_bd/board.do?pageNum=${startPage - pageSize }">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/hw_bd/board.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/hw_bd/board.do?pageNum=${startPage + pageSize}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>


			</c:if>

			<c:if test="${searchList.size() > 0}">
				<tr>
					<c:forEach var="item" items="${searchList}">
						<tr>
							<td>${item.rn}</td>
							<td><strong>${item.lecture_num}</strong></td>
							<td><a href="/FinalProject/hw_bd/detailContent.do?num=${item.homework_num}">${item.homework_title}</a></td>
							<td><strong>${item.id}</strong></td>
							<td><strong>${item.homework_sub}</strong></td>
							<td><strong><fmt:formatDate value="${item.homework_date}" pattern="yyyy-MM-dd" /></strong></td>
						</tr>
					</c:forEach>
				</tr>

				<tr>
					<td colspan="6">
						<c:if test="${count > 0}">
							<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
							<!-- 총 페이지 개수 -->
							<c:set var="pageBlock" value="${5}" />
							<!-- [1][2][3][4][5][다음] 이런식으로 나오기 위해서 -->
							<fmt:parseNumber var="result" value="${currentPage / pageSize}"
								integerOnly="true" />
							<!-- 시작페이지를 정해주기 위해서 -->
							<c:set var="startPage" value="${result * pageSize + 1}" />
							<!-- 시작페이지 -->
							<c:set var="endPage" value="${startPage + pageBlock-1}" />
							<!-- 끝페이지 -->

							<c:if test="${endPage > pageCount}">
								<c:set var="endPage" value="${pageCount}" />
							</c:if>

							<c:if test="${startPage > pageSize}">
								<a href="/FinalProject/hw_bd/board.do?pageNum=${startPage - pageSize}">[이전]</a>
							</c:if>

							<c:forEach var="i" begin="${startPage}" end="${endPage}">
								<a href="/FinalProject/hw_bd/board.do?pageNum=${i}">[${i}]</a>
							</c:forEach>

							<c:if test="${endPage < pageCount}">
								<a href="/FinalProject/hw_bd/board.do?pageNum=${startPage + pageSize}">[다음]</a>
							</c:if>
						</c:if></td>
				</tr>
			</c:if>

			<c:if test="${position == 0}">

				<tr>
					<td colspan="6"><input type="button" value="글쓰기"
						onclick="location.href='/FinalProject/hw_bd/insertContentForm.do'">
						<input type="button" value="전체글보기"
						onclick="location.href='/FinalProject/hw_bd/board.do'">
						<input type="button" value="메인으로"
						onclick="location.href='/FinalProject/${returnPage}'">
					</td>
				</tr>

			</c:if>

			<c:if test="${position != 0}">
				<tr>
					<td colspan="6">
						<input type="button" value="전체글보기"
						onclick="location.href='/FinalProject/hw_bd/board.do'">
						<input type="button" value="메인으로"
						onclick="location.href='/FinalProject/${returnPage}'">
					</td>
				</tr>
			</c:if>


			<tr>
				<td colspan="6"><select name="options">
						<option value="0" selected="selected">제목</option>
						<option value="1">내용</option>
						<option value="2">작성자</option>
				</select> <input type="text" name="searchContent" value=""> <input
					type="submit" value="찾기"></td>
			</tr>
		</table>
	</form>
</body>
</html>