<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>게시판</title>
</head>
<h1>게시판:${count}</h1>
<table border="1">
	<tr>
		<td>글번호</td>
		<td>id</td>
		<td>작성자</td>
		<td>제목</td>
		<td>작성일</td>
		<td>조회수</td>
	</tr>

	<c:if test="${searchList.size() == 0 }">
		<c:if test="${mainList.size() == 0}">
			<tr>
				<td colspan="6">글이 없습니다.</td>
			</tr>
		</c:if>

		<c:if test="${mainList.size() > 0}">
			<tr>
				<c:forEach var="list" items="${mainList}">
					<tr>
						<td>${list.num}</td>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td><a href="/FinalProject/qna/detail.do?num=${list.num}" style="text-decoration:none">${list.title}</a></td>
						<td><fmt:formatDate value="${list.writedate}" pattern="yyyy-MM-dd" /></td>
						<td>${list.readcount}</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if>
	</c:if>

	<c:if test="${searchList.size() > 0 }">
		<tr>
			<c:forEach var="list" items="${searchList}">
				<tr>
					<td>${list.num}</td>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td><a href="/FinalProject/qna/detail.do?num=${list.num}&id=${list.id}">${list.title}[${cmcount}]</a></td>
					<td><fmt:formatDate value="${list.writedate}" pattern="yyyy-MM-dd" /></td>
					<td>${list.readcount}</td>
				</tr>
			</c:forEach>
		</tr>
	</c:if>
	<tr>
		<td colspan="5">
			<c:if test="${count > 0}">
					<c:set var="pageCount"
						value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
					<c:set var="pageBlock" value="${5}" />
					<fmt:parseNumber var="result" value="${currentPage / pageSize}"
						integerOnly="true" />
					<c:set var="startPage" value="${result * pageSize + 1}" />
					<c:set var="endPage" value="${startPage + pageBlock-1}" />
	
					<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
	
					<c:if test="${startPage > pageSize}">
						<a href="/FinalProject/qna/list.do?pageNum=${startPage - pageSize }">[이전]</a>
					</c:if>
	
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="/FinalProject/qna/list.do?pageNum=${i}">[${i}]</a>
					</c:forEach>
	
					<c:if test="${endPage < pageCount}">
						<a href="/FinalProject/qna/list.do?pageNum=${startPage + pageSize}">[다음]</a>
					</c:if>
			</c:if>
		</td>
	</tr>

	<tr>
		<td colspan="6">
			<input type="button" value="글쓰기" onclick="location.href='/FinalProject/qna/writeForm.do'"> 
			<input type="button" value="전체글보기" onclick="location.href='/FinalProject/qna/list.do'">
		</td>
	</tr>
</table>
	<form action="list.do">
		<table border="1">
			<tr>
				<td colspan="5"><select name="options">
						<option value="0" selected="selected">제목</option>
						<option value="1">내용</option>
						<option value="2">작성자</option>
				</select> <input type="text" name="searchContent" value=""> 
				<input type="submit" value="찾기"></td>
			</tr>
		</table>
	</form>
</body>
</html>