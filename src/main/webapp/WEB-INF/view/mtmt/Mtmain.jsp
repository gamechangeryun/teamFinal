<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>멘토 멘티 게시판</title>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="../bootstrap.min.css">

</head>
<body>
	<form>
	<div class="container">
		<h2>멘토 멘티 게시판</h2>
		<table class="table table-hover">
			<tr class="table-primary">
				<th>번호</th>
				<th>제 목</th>
				<th>인원수</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:if test="${searchList.size() == 0 }">
			
				<c:if test="${mainList.size() == 0}">
					<tr class="table-primary">
						<td colspan="6">글이 없습니다.</td>
					</tr>
				</c:if>
			
				<c:if test="${mainList.size() > 0 }">
					<tr class="table-success">
						<c:forEach var="item" items="${mainList}">
						<tr class="table-success">
							<td>${item.num}</td>
							<td><a href="<%=cp%>/mtmt/detailContent.do?num=${item.num}">${item.title}</a></td>
							<td>${item.nowpeople} / ${item.maxpeople}</td>
							<td>${item.id}</td>
							<td><fmt:formatDate value="${item.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${item.readcount}</td>
						</tr>
						</c:forEach>
					</tr>
				</c:if>
				
			</c:if>
			
			<c:if test="${searchList.size() > 0 }">
				<tr class="table-success">
					<c:forEach var="item" items="${searchList}">
						<tr class="table-success">
							<td>${item.num}</td>
							<td><a href="<%=cp%>/mtmt/detailContent.do?num=${item.num}">${item.title }</a></td>
							<td>${item.nowpeople} / ${item.maxpeople}</td>
							<td>${item.id}</td>
							<td><fmt:formatDate value="${item.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${item.readcount}</td>
						</tr>
					</c:forEach>
				</tr>
			</c:if>
			
			<tr class="table-secondary">
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
				         
				  <%--  <c:if test="${startPage > pageSize}">
				        <a href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${startPage - pageSize }">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${startPage + pageSize}">[다음]</a>
				   </c:if> --%>
				   
				   <ul class="pagination pagination-sm">
				   <c:if test="${startPage > pageSize}">
					    <li class="page-item disabled">
					      <a class="page-link" href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${startPage - pageSize }">&laquo;</a>
					    </li>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
					    <li class="page-item active">
					      <a class="page-link" href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${i}">${i}</a>
					    </li>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
					    <li class="page-item">
					      <a class="page-link" href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${startPage + pageSize}">&raquo;</a>
					    </li>
				   </c:if>
				   </ul>
				   
				</c:if>
				</td>
			</tr>
		
			<tr class="table-active">
				<td colspan="6"><input type="button" class="btn btn-primary btn-xs" value="글쓰기" onclick="location.href='<%=cp%>/mtmt/insertContentForm.do'" >
					<input type="button" class="btn btn-primary btn-xs" value="전체글보기" onclick="location.href='<%=cp%>/mtmt/mtmtlist.do'" >
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
				
					<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
					  <div class="btn-group" role="group">
						<select name="options" class="btn btn-secondary dropdown-toggle">
							<option value="0" class="btn btn-secondary" selected="selected">제목</option>
							<option value="1" class="btn btn-secondary">내용</option>
							<option value="2" class="btn btn-secondary">작성자</option>
						</select>
					  </div>
						&nbsp; &nbsp;<input name="searchContent" class="form-control mr-sm-2" type="text" placeholder="Search">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
					</div>
				
				</td>
			</tr>
		</table>
	</div>
	</form>


</body>
</html>