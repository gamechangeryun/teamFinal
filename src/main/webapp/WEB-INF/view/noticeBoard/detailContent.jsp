<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>글 상세보기</title>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${detailContent.rn }</td>
				<td>조회수</td> 
				<td>${detailContent.readcount }</td>
				<td>글제목</td> 
				<td>${detailContent.title }</td>
			</tr>
				
			<tr>
				<td>작성자</td> 
				<td>${detailContent.name }</td>
				<td colspan="3">작성일</td>
				<td><fmt:formatDate value="${detailContent.writedate }" pattern="yyyy-MM-dd"/></td>
			</tr>
				
			<tr>
				<td>파일</td> 
				<c:if test="${name == null }">
					<td colspan="5">첨부파일이 없습니다.</td>
				</c:if>
				
				<c:if test="${name != null }">
					<td colspan="5"><a href="/FinalProject/fileDownload.do?num=${detailContent.num }">${name }</a></td>
				</c:if>
			</tr>
				
			<tr>
				<td><h5>글내용</h5></td>
				<td colspan="5">${detailContent.content }</td>
			</tr>
			
			<c:if test="${position == 2 }">
				<tr>  
					<td colspan="5">
						<input type="button" value="목록으로" onclick="location.href='/FinalProject/noticeBoardMain.do'">
						<input type="button" value="수정하기" onclick="location.href='/FinalProject/updateContentForm.do?num=${detailContent.num }'">
						<input type="button" value="삭제하기" onclick="location.href='/FinalProject/deleteContent.do?num=${detailContent.num }'">
					</td>
				</tr>
			</c:if>
			
			<c:if test="${position != 2 }">
				<tr>  
					<td colspan="5">
						<input type="button" value="목록으로" onclick="location.href='/FinalProject/noticeBoardMain.do'">
					</td>
				</tr>
			</c:if>
		</table>
	</form>
</body>
</html>