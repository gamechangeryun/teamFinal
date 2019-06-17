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
				<td>제목</td>
				<td>${detailContent.homework_title}</td>
				<td>강의번호</td>
				<td>${detailContent.lecture_num}</td>
			</tr>

			<tr>
				<td>작성자</td>
				<td>${detailContent.name}</td>
				<td colspan="3">작성일</td>
				<td><fmt:formatDate value="${detailContent.homework_date}" pattern="yyyy-MM-dd"/></td>
			</tr>

			<tr>
				<td>파일</td>
				<c:if test="${name == null}">
					<td colspan="6">첨부파일이 없습니다.</td>
				</c:if>
				
				<c:if test="${name != null}">
					<td colspan="6"><a href="/FinalProject/hw_bd/fileDownload.do?num=${detailContent.homework_num}">${name}</a></td>
				</c:if>
				
			</tr>

			<tr>
				<td colspan="6">
					<input type="button" value="목록으로" onclick="location.href='/SpringProject/hw_bd/board.do'">
					<input type="button" value="수정하기" onclick="location.href='/FinalProject/hw_bd/updateContentForm.do?num=${detailContent.homework_num}'">
					<input type="button" value="삭제하기"	onclick="location.href='/FinalProject/hw_bd/deleteContent.do?num=${detailContent.homework_num}'">
					
					<c:if test="${position == 0}">
					<input type="button" value="수정하기" onclick="location.href='/FinalProject/hw_bd/updateContentForm.do?num=${detailContent.homework_num}'">
					<input type="button" value="삭제하기"	onclick="location.href='/FinalProject/hw_bd/deleteContent.do?num=${detailContent.homework_num}'">
					</c:if>
				</td>
			</tr>

		</table>
	</form>
</body>

</html>