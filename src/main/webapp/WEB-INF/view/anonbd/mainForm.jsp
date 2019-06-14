<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 메인</title>
<!-- jquery js파일 추가 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSearch").click(function(){
		var options = $("#options").val();
		var searchString = $("searchString").val();
		document.searchContent.action="<%=cp%>/anon/searchList.do";
		document.searchContent.submit();
	})
})
function writeContent() {
	location.href="<%=cp%>/anon/write.do";
}
function allList() {
	location.href="<%=cp%>/anon/list.do?page=1";
}
</script>
</head>
<body>
	<h2>게시글</h2>
<hr>
<button type="button" id="writeContent" onclick="writeContent();">글쓰기</button>
<button type="button" id="allList" onclick="allList();">전체목록</button>
<table border="1">
	<tr>
		<th width="100">번호</th>
		<th width="100">작성자(익명)</th>
		<th width="200">제목</th>
		<th width="100">조회수</th>
		<th width="100">작성일</th>
	</tr>
	<c:forEach var="content" items="${contents}">
	<tr>
		<td>${content.num}</td>
		<td>${content.writer}</td>
		<td><a href="<%=cp%>/anon/showContent.do?num=${content.num}">${content.title}</a></td>
		<td>${content.readcount}</td>
		<td>
			<fmt:formatDate value="${content.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center">
		<c:forEach var="i" begin="1" end="${totalPage}">
			<c:if test="${options==null and searchString==null}" >
				<a href="<%=cp%>/anon/list.do?page=${i}">[${i}]</a>
			</c:if>
			<c:if test="${!(options==null and searchString==null)}" >
				<a href="<%=cp%>/anon/searchList.do?options=${options}&searchString=${searchString}&page=${i}">[${i}]</a>
			</c:if>
		</c:forEach>
		</td>
	</tr>
</table>
<form id="searchContent" name="searchContent">
<table>
	<tr>
		<td>
			<select id="options" name="options">
				<option value="0" selected="selected">작성자</option>
				<option value="1">내용</option>
				<option value="2">제목</option>
			</select>
		</td>
		<td>
			<input type="text" id="searchString" name="searchString" size="15" maxlength="50"/>
			<input type="hidden" id="page" name="page" value="1"/>
			<button type="button" id="btnSearch">검색</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>