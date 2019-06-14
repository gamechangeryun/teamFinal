<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>세부글</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
	function checkIt() {
		var myForm = eval("document.reForm");

		if (!myForm.id.value) {
			alert("글제목을 입력하세요");
			return false;
		}

		if (!myForm.name.value) {
			alert("id를 입력하세요");
			return false;
		}

		if (!myForm.content.value) {
			alert("글내용을 입력하세요");
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>${list.num}</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>${list.title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${list.name}</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td colspan="3"><textarea rows="10" cols="50" name="content"
						readOnly>${list.content}</textarea></td>
			</tr>
			<tr>
				<td>업로드한 파일</td>
				<c:if test="${name == null }">
					<td colspan="5">첨부파일이 없습니다.</td>
				</c:if>
				<c:if test="${name != null }">
					<td colspan="5"><a href="/FinalProject/qna/Download.do?num=${list.num}">${name}</a></td>
				</c:if>
			</tr>
			<tr>
				<td><input type="button" value="목록으로"
					onclick="location.href='/FinalProject/qna/list.do'"></td>
				<td><input type="button" value="수정하기"
					onclick="location.href='/FinalProject/qna/updateForm.do?num=${list.num}'"></td>
				<td><input type="button" value="삭제하기"
					onclick="location.href='/FinalProject/qna/deletePro.do?num=${list.num}&comment_num=${cmlist.comment_num}'"></td>
				<%-- <td><input type="button" value="답변글 작성"
					onclick="location.href='reply.do?num=${list.num}'"></td> --%>
			</tr>
		</table>
	</form>
	<form action="/FinalProject/qna/cminsert.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${list.num}">
		<table>
			<tr>
				<td>답변 댓글</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="submit" value="댓글 작성"></td>
			</tr>
		</table>
	</form>
	<c:if test="${cmcount > 0}">
		<table>
			<c:forEach var="cmlist" items="${cmList}">
				<tr>
					<td>답변 댓글</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${cmlist.name}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate value="${cmlist.writedate}"
							pattern="yyyy-MM-dd" /></td>
				<tr>
					<td>내용</td>
					<td colspan="3"><textarea rows="10" cols="50" name="content"
							readOnly>${cmlist.content}</textarea></td>
				</tr>
				<tr>
					<td>파일</td>
					<c:if test="${name == null }">
						<td colspan="5">첨부파일이 없습니다.</td>
					</c:if>
					<c:if test="${name != null }">
						<td colspan="5"><a href="/FinalProject/qna/Download.do?num=${list.num}">${name}</a></td>
					</c:if>
				</tr>
				<tr>
					<td><input type="button" value="댓글 삭제"
						onclick="location.href='/FinalProject/qna/cmdelete.do?comment_num=${cmlist.comment_num}&num=${list.num}'"></td>
					<td><input type="button" value="댓글 수정"
						onclick="location.href='/FinalProject/qna/cmupdate.do?comment_num=${cmlist.comment_num}&num=${list.num}'"></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		<c:if test="${cmcount > 0}">
			<c:set var="pageCount"
				value="${cmcount / pageSize + ( cmcount % pageSize == 0 ? 0 : 1)}" />
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
</body>
</html>

