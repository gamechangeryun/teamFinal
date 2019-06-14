<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항</title>
</head>
<body>
<div class="container">
	<h1><strong>공지사항</strong></h1>
	<form>
		<table class="table table-striped">
			<tr>
				<th>글번호</th>
				<th>강의번호</th>
				<th>제 목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:if test="${searchList.size() == 0 }">
			
				<c:if test="${mainList.size() == 0}">
					<tr>
						<td colspan="5">글이 없습니다.</td>
					</tr>
				</c:if>
			
				<c:if test="${mainList.size() > 0 }">
					<tr>
						<c:forEach var="item" items="${mainList }">
							<c:if test="${item.isnotice == 1 }">
								<tr>
									<td><strong>${item.rn }</strong></td>
									<td><strong>${item.lecture_num }</strong></td>
									<td><strong><a href="/FinalProject/ProdetailContent.do?num=${item.num}">[공지]${item.title }</a></strong></td>
									<td><strong><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd"/></strong></td>
									<td><strong>${item.readcount }</strong></td>
								</tr>
							</c:if>
							
							<c:if test="${item.isnotice == 0 }">
								<tr>
									<td>${item.rn }</td>
									<td>${item.lecture_num }</td>
									<td><a href="/FinalProject/ProdetailContent.do?num=${item.num}">${item.title }</a></td>
									<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd"/></td>
									<td>${item.readcount }</td>
								</tr>
							</c:if>
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
				        <a href="/FinalProject/PronoticeboardMain.do?pageNum=${startPage - pageSize }">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/FinalProject/PronoticeboardMain.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/PronoticeboardMain.do?pageNum=${startPage + pageSize}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
				
			</c:if>
			
			<!--검색완료 목록  -->
			<c:if test="${searchList.size() > 0 }">
				<tr>
					<c:forEach var="item" items="${searchList }">
						<tr>
							<td>${item.rn }</td>
							<td>${item.lecture_num }</td>
							<td><a href="/FinalProject/ProdetailContent.do?num=${item.num}">${item.title }</a></td>
							<td><fmt:formatDate value="${item.writedate }" pattern="yyyy-MM-dd"/></td>
							<td>${item.readcount }</td>
						</tr>
					</c:forEach>
				</tr>
				
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
				        <a href="/FinalProject/PronoticeboardMain.do?pageNum=${startPage - pageSize}&options=${options}&searchContent=${searchContent}">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="/SR_mtmt/PronoticeboardMain.do?pageNum=${i}&options=${options}&searchContent=${searchContent}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="/FinalProject/PronoticeboardMain.do?pageNum=${startPage + pageSize}&options=${options}&searchContent=${searchContent}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
			</c:if>
			
			<tr>
				<td colspan="5">
					<input type="button" class="btn btn-info btn-xs" value="글쓰기" onclick="location.href='/FinalProject/ProinsertContentForm.do'" />
					<input type="button" class="btn btn-info btn-xs" value="전체글보기" onclick="location.href='/FinalProject/PronoticeboardMain.do'" >
					<input type="button" class="btn btn-info btn-xs" value="돌아가기" onclick="location.href='/FinalProject/${returnPage}'" >
				</td>
			</tr>
			
			<tr>
				<td colspan="5">
					<select name="options">
						<option value="0" selected="selected">제목</option>
						<option value="1">내용</option>
						<option value="2">강의번호</option>
					</select>
			
					<input type="text" name="searchContent" value="">
			
					<input type="submit" class="btn btn-info btn-xs" value="찾기">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>