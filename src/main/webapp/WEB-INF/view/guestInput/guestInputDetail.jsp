<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>글 상세보기</title>
</head>
<body>
	<form method="post">
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${detailContent.rn }</td>
				<td>글제목</td> 
				<td>${detailContent.title }</td>
				<td>업로드게시판</td>
				<c:if test="${detailContent.selectBoard == 1 }">
					멘토멘티게시판
				</c:if>
				<c:if test="${detailContent.selectBoard == 2 }">
					취업게시판
				</c:if>
			</tr>
				
			<tr>
				<td>작성자</td> 
				<td>${detailContent.name }</td>
				<td colspan="2">작성일</td>
				<td><fmt:formatDate value="${detailContent.writedate }" pattern="yyyy-MM-dd"/></td>
			</tr>
				
			<tr>
				<td>파일</td> 
				<c:if test="${name == null }">
					<td colspan="5">첨부파일이 없습니다.</td>
				</c:if>
				
				<c:if test="${name != null }">
					<td colspan="5"><a href="/FinalProject/guestInputDetailFileDownload.do?num=${detailContent.num }">${name }</a></td>
				</c:if>
			</tr>
				
			<tr>
				<td><h5>사유</h5></td>
				<td colspan="5">${detailContent.reason }</td>
			</tr>
			
			<tr>  
				<td colspan="5">
					<input type="button" value="목록으로" onclick="location.href='/FinalProject/guestInputSubmit.do'">
					<input type="submit" value="허용" onclick="location.href='/FinalProject/addBoard.do?num=${detailContent.num }'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>