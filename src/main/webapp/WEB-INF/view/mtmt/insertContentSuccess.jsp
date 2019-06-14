<%@ page contentType="text/html; charset=UTF-8"%>
<%
    String cp = request.getContextPath(); //첫번째 경로를 가져온다
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<title>글 추가 성공</title>
<meta http-equiv="refresh" content="3;url=<%=cp%>/mtmt/mtmtlist.do">
</head>
<body>
	글 추가 성공<br>
	3초후 글목록으로 이동합니다.<br>
	<input type="button" value="즉시이동" onclick="location.href='<%=cp%>/mtmt/mtmtlist.do'">
</body>
</html>