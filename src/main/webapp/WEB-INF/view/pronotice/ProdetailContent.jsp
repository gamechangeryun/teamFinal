<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>글 상세보기</title>
<%@ include file="../bootstrap.jsp" %>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
</head>
<body>
<div class="container">
	<form>
		<table class="table table-hover">
			<tr class="table-primary">
				<td>글번호</td>
				<td>${detailContent.rn }</td>
				<td>조회수</td> 
				<td>${detailContent.readcount }</td>
				<td>글제목</td> 
				<td>${detailContent.title }</td>
			</tr>
				
			<tr class="table-success">
				<td>강의번호</td> 
				<td>${detailContent.lecture_num }</td>
				<td colspan="3">작성일</td>
				<td><fmt:formatDate value="${detailContent.writedate }" pattern="yyyy-MM-dd"/></td>
			</tr>
				
			<tr class="table-success">
				<td><h5>글내용</h5></td>
				<td colspan="5">${detailContent.content }</td>
			</tr>
			
			<c:if test="${position == 2 }">
				<tr class="table-active">  
					<td colspan="5">
						<input type="button" value="목록으로" class="btn btn-primary" onclick="location.href='/FinalProject/PronoticeboardMain.do'">
						<input type="button" value="수정하기" class="btn btn-primary" onclick="location.href='/FinalProject/ProupdateContentForm.do?num=${detailContent.num }'">
						<input type="button" value="삭제하기" class="btn btn-danger" onclick="location.href='/FinalProject/ProdeleteContent.do?num=${detailContent.num }'">
					</td>
				</tr>
			</c:if>
			
			<c:if test="${position != 2 }">
				<tr class="table-active">  
					<td colspan="5">
						<input type="button" value="목록으로" class="btn btn-primary" onclick="location.href='/FinalProject/PronoticeboardMain.do'">
					</td>
				</tr>
			</c:if>
		</table>
	</form>
</div>
</body>
</html>