<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<%@ include file="bootstrap.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>멘토 멘티 게시판</title>
<style type="text/css">
h2{text-align: center;}
</style>
</head>
<body>
	<div class="h2">
		<h2>멘토 멘티 게시판</h2>
	</div>
	<form>
	<div class="container">
		<table class="table table-striped">
			<tr>
				<th>번호</th>
				<th>제 목</th>
				<th>인원수</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<c:if test="${searchList.size() == 0 }">
			
				<c:if test="${mainList.size() == 0}">
					<tr>
						<td colspan="6">글이 없습니다.</td>
					</tr>
				</c:if>
			
				<c:if test="${mainList.size() > 0 }">
					<tr>
						<c:forEach var="item" items="${mainList}">
						<tr>
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
				<tr>
					<c:forEach var="item" items="${searchList}">
						<tr>
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
				        <a href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${startPage - pageSize }">[이전]</a>
				   </c:if>
	
				   <c:forEach var="i" begin="${startPage}" end="${endPage}">
				       <a href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${i}">[${i}]</a>
				   </c:forEach>
				
				   <c:if test="${endPage < pageCount}">
				        <a href="<%=cp%>/mtmt/mtmtlist.do?pageNum=${startPage + pageSize}">[다음]</a>
				   </c:if>
				</c:if>
				</td>
			</tr>
		
			<tr>
				<td colspan="6"><input type="button" class="btn btn-info btn-xs" value="글쓰기" onclick="location.href='<%=cp%>/mtmt/insertContentForm.do'" >
					<input type="button" class="btn btn-info btn-xs" value="전체글보기" onclick="location.href='<%=cp%>/mtmt/mtmtlist.do'" >
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
					<select name="options">
						<option value="0" selected="selected">제목</option>
						<option value="1">내용</option>
						<option value="2">작성자</option>
					</select>
			
					<input type="text" name="searchContent" value="">
			
					<input type="submit" value="찾기">
				</td>
			</tr>
		</table>
	</div>
	</form>


</body>
</html>