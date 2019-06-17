<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td>${detailContent.rn}</td>
				<td>글제목</td>
				<td>${detailContent.title}</td>
				<td>조회수</td>
				<td>${detailContent.readcount}</td>
			</tr>

			<tr>
				<td>작성자</td>
				<td>${detailContent.name}</td>
				<td colspan="3">작성일</td>
				<td><fmt:formatDate value="${detailContent.writedate}" pattern="yyyy-MM-dd"/></td>
			</tr>

			<tr>
				<td>파일</td>
				<c:if test="${name == null}">
					<td colspan="5">첨부파일이 없습니다.</td>
				</c:if>
				
				<c:if test="${name != null}">
					<td colspan="5"><a href="/FinalProject/job_bd/fileDownload.do?num=${detailContent.num}">${name}</a></td>
				</c:if>
				
			</tr>

			<tr>
				<td><h5>글내용</h5></td>
				<td colspan="5">${detailContent.content}
				<img src="${fn}" width="200" height="300"/>
				</td>

			</tr>

			<tr>
				<td colspan="5"><input type="button" value="목록으로" onclick="location.href='/FinalProject/job_bd/board.do'">
					<input type="button" value="수정하기" onclick="location.href='/FinalProject/job_bd/updateContentForm.do?num=${detailContent.num}'">
					<input type="button" value="삭제하기"	onclick="location.href='/FinalProject/job_bd/deleteContent.do?num=${detailContent.num}'">
				</td>
			</tr>

		</table>
	</form>
</body>

</html>