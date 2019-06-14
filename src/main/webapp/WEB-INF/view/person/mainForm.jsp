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
<title>Person List</title>
<!-- jquery js파일 추가 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSearch").click(function(){
		document.searchContent.action="<%=cp%>/person/main.do";
		document.searchContent.submit();
	})
})
function writePerson() {
	location.href="<%=cp%>/person/write.do";
}

function goList() {
	location.href="<%=cp%>/person/main.do?page=1";
}
</script>
</head>
<body>
<form id="showList" name="showList">
	<button type="button" id="btnInsertPerson" onclick="writePerson();">신규인원추가</button>
	<input type="button" value="목록으로" onclick="goList();">
	<input type="button" value="메인으로" onclick="location.href='/FinalProject/${returnPage}'">
	<table border="1">
		<tr>
			<th>id</th>
			<th>temper_num</th>
			<th>password</th>
			<th>name</th>
			<th>gender</th>
			<th>birthday</th>
			<th>grade</th>
			<th>phone</th>
			<th>email</th>
			<th>postcode</th>
			<th>address1</th>
			<th>address2</th>
		</tr>
		<c:forEach var="person" items="${persons}">
		<tr>
			<td>${person.id}</td>
			<td>${person.temper_num}</td>
			<td>${person.password}</td>
			<td>${person.name}</td>
			<td>${person.gender}</td>
			<td>${person.birthday}</td>
			<td>${person.grade}</td>
			<td>${person.phone}</td>
			<td>${person.email}</td>
			<td>${person.postcode}</td>
			<td>${person.address1}</td>
			<td>${person.address2}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="12" align="center">
				<c:forEach var="i" begin="1" end="${totalPage}">
					<c:if test="${searchOption==null and searchString==null}" >
						<a href="<%=cp%>/person/main.do?page=${i}">[${i}]</a>
					</c:if>
					<c:if test="${!(searchOption==null and searchString==null)}" >
						<a href="<%=cp%>/person/main.do?page=${i}&searchOption=${searchOption}&searchString=${searchString}">[${i}]</a>
					</c:if>
				</c:forEach>
			</td>
		</tr>
	</table>
</form>
<form id="searchContent" name="searchContent">
<input type="hidden" id="page" name="page" value="1"/>
	<table>
		<tr>
			<td>
				<select id="searchOption" name="searchOption">
					<option value="0" selected="selected">Name</option>
					<option value="1">Grade</option>
					<option value="2">Temper_num</option>
				</select>
			</td>
			<td>
				<input type="text" id="searchString" name="searchString" size="15" maxlength="50"/>
				<button type="button" id="btnSearch">검색</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
