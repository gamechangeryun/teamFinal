<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>댓글 수정 폼</title>
</head>
<body>
	<form action="/FinalProject/qna/cmupdatePro.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="comment_num" value="${cmlist.comment_num}"readOnly>
			<input type="hidden" name="num" value="${cmlist.num}" readOnly>
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" value="${cmlist.name}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><textarea rows="10" cols="50" name="content">${cmlist.content}</textarea></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="button" value="목록으로" 
					onclick="location.href='/FinalProject/qna/detail.do?comment_num=${cmlist.comment_num}&num=${cmlist.num}'"></td>
				<td><input type="submit" value="댓글 작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>